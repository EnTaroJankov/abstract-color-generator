package groups

import java.util

class MultiplicativeIntegerGroup(val n: Int) extends IntegerGroup {

  override def op(base: Int, exponent: Int): util.Iterator[Int] = {

    val values = new util.ArrayList[Int]()

    var ans = base

    for (_ <- 0 until n) {
      if (exponent == 0) {
        values.add(1)
      }

      ans = ans * base % n
      values.add(ans)

    }
    values.iterator()
  }
}
