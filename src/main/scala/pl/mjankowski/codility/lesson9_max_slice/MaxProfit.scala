package pl.mjankowski.codility.lesson9_max_slice

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 29.10.16
  */
class MaxProfit {

  def solution(a: Array[Int]): Int = {

    if (a.length == 0) {
      0
    } else if (a.length == 1) {
      math.max(0, a(0))
    } else {

      val diffs = a.sliding(2).map(s => s(1).toLong - s(0).toLong)

      var maxEnding: Long = 0
      var maxSlice: Long = 0

      diffs.foreach { e =>
        maxEnding = math.max(0, maxEnding + e)
        maxSlice = math.max(maxSlice, maxEnding)
      }
      maxSlice.toInt
    }
  }
}

object MaxProfit {

  def main(args: Array[String]) {
    check(Array[Int](23171, 21011, 21123, 21366, 21013, 21367), 356)
    check(Array[Int](0), 0)
    check(Array[Int](0, 1), 1)
    check(Array[Int](1, 0), 0)
    check(Array[Int](200, 100), 0)
  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input ${A.mkString(", ")}, expected $expected")

    val obj: MaxProfit = new MaxProfit
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}