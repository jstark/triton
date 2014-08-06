package sym.ast

sealed trait Expr
// numbers
case class Number(val value: Double) extends Expr
// for constants (e.g pi = 3.14159) and variables (e.g t, x etc)
case class Const(val value: Double, val name: String) extends Expr
case class Variable(val name: String) extends Expr
// binary operators
case class OpAdd(val leftOp: Expr, val rightOp: Expr) extends Expr
case class OpSub(val leftOp: Expr, val rightOp: Expr) extends Expr
case class OpMul(val leftOp: Expr, val rightOp: Expr) extends Expr
case class OpDiv(val leftOp: Expr, val rightOp: Expr) extends Expr
case class OpPow(val leftOp: Expr, val rightOp: Expr) extends Expr
// unary operators
case class OpUnaryPlus(val rightOp: Expr) extends Expr
case class OpUnaryMinus(val rightOp: Expr) extends Expr 
// function
case class OpFun(val name: String, val args: List[Expr]) extends Expr
