package pl.mjankowski.codility.lesson9_max_slice

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 29.10.16
  */
class MaxSlice {

  def findMaxSlice(a: Array[Int]): Int = {
    var maxEnding = 0
    var maxSlice = 0

    a.foreach{ e =>
      maxEnding = math.max(0, maxEnding + e)
      maxSlice = math.max(maxSlice, maxEnding)
    }

    maxSlice
  }
}

object MaxSlice {

  def main(args: Array[String]) {
    check(Array[Int](5, -7, 3, 5, -2, 4, -1), 10)
    check(Array[Int](3,2,-6,4,0), 5)
  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input ${A.mkString(", ")}, expected $expected")

    val obj: MaxSlice = new MaxSlice
    val ret: Int = obj.findMaxSlice(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}
