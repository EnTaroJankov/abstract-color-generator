package groups

import java.util

class AdditiveIntegerGroup(val n: Int) extends IntegerGroup {

  def getGenerators(): Unit = {
    // TODO
  }

  override def toString: String = s"($n)"

  override def op(base: Int, exponent: Int): util.Iterator[Int] = {
    var total: Int = 0
    val values = new util.ArrayList[Int]
    for (i <- 0 until n) {
      if (exponent == 0) {
        values.add(0)
      } else {
        total = (total + base) % n
        values.add(total)
      }
    }
    values.iterator()
  }

}

