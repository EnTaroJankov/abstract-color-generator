package groups

import java.util

trait IntegerGroup {
  val n: Int
  def op(base: Int, exponent: Int): util.Iterator[Int]
}