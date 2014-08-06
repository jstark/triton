package sym.test

import sym.parse._
import scala.io.Source

/**
 * Created by Ioannis on 7/16/2014.
 */
object test extends App {
  val parser = new ArithExprParser
  for (ln <- Source.stdin.getLines)
    println(parser.parseAll(parser.expr, ln))
}
