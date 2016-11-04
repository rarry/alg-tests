package pl.mjankowski.codility.lesson9_max_slice

/**
  * 53%   https://codility.com/demo/results/trainingUUUGPH-W3F/
  * 100%  https://codility.com/demo/results/trainingSKVVS4-UT3/
 *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 31.10.16
  */
class MaxSliceSum {

  def solution(a: Array[Int]): Int = {
    var maxEnd = 0l
    var maxSlice = a(0).toLong

    a.foreach { e =>
      maxEnd = math.max(maxEnd + e.toLong, e.toLong)
      maxSlice = math.max(maxEnd, maxSlice)
    }

    maxSlice.toInt
  }
}


object MaxSliceSum {

  def main(args: Array[String]) {
    check(Array[Int](5, -7, 3, 5, -2, 4, -1), 10)
    check(Array[Int](3,2,-6,4,0), 5)
    check(Array[Int](3), 3)
    check(Array[Int](-3), -3)
    check(Array[Int](-10, -9, -8, -7, -6), -6)
    check(Array[Int](-2, 0), 0)

  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input ${A.mkString(", ")}, expected $expected")

    val obj: MaxSliceSum = new MaxSliceSum
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}
