package sym.parse

import scala.util.parsing.combinator.{JavaTokenParsers, PackratParsers}

class ArithExprParser extends JavaTokenParsers with PackratParsers {
  import sym.ast._
  type R = Expr
  lazy val expr: PackratParser[R] = chainl1(term, "+" ^^^ OpAdd | "-" ^^^ OpSub)
  lazy val term: PackratParser[R] = chainl1(prim, "*" ^^^ OpMul | "/" ^^^ OpDiv)
  lazy val prim: PackratParser[R] = "-" ~ prim ^^ { case _ ~ p => OpUnaryMinus(p) } |
                                    chainl1(prim, "**" ^^^ OpPow)                     |
                                    ident ~ opt(func) ^^ { case id ~ None => Variable(id)
                                                           case id ~ Some(args) => OpFun(id, args)  } |
                                    floatingPointNumber ^^{ case n => Number(n.toDouble) }  |
                                    "(" ~> expr <~ ")"
  lazy val func: PackratParser[List[R]] = "(" ~> repsep(farg, ",") <~ ")"
  lazy val farg: PackratParser[R] = expr
}
