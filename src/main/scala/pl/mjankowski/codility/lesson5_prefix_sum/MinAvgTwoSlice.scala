package pl.mjankowski.codility.lesson5_prefix_sum

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 24.10.16
  */
class MinAvgTwoSlice {

  // 4 2 2 5 1 5 8
  // 0 4 6 8 13 14 19 27

  def solution(a: Array[Int]): Int = {

    val p = a.scanLeft(0)(_ + _)

    def getAvg(start: Int, end: Int): Double = (p(end + 1) - p(start)) / (end - start + 1).toDouble

    var smallestAvg = getAvg(0, 1)
    var smallestIdx = 0
    var start = 0
    var end = 1

    while(end < a.length) {

      while(a(end) >= smallestAvg && end < a.length-1){
        end +=1
      }

      //end = a.indexWhere(_ < smallestAvg)

      val avg = getAvg(start, end)
      if (avg < smallestAvg) {
        smallestAvg = avg
      }

      while (start < end) {

        val avg = getAvg(start, end)
        if (avg < smallestAvg) {
          smallestAvg = avg
          smallestIdx = start
        }
        start += 1
      }
      if (start == end) {
        start -= 1
      }
      end += 1
    }

    return smallestIdx

  }

}

object MinAvgTwoSlice {

  def main(args: Array[String]) {
    check(Array[Int](1, 10000000, 1), 0)
    check(Array[Int](4, 2), 0)
    check(Array[Int](4, 2, 2, 5, 1, 5, 8), 1)
    check(Array[Int](4, 2, 2, 51, 75, 100, 1, 1, 8), 6)
  }

  private def check(A: Array[Int], expected: Int) {
    val obj: MinAvgTwoSlice = new MinAvgTwoSlice
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
  }

}
