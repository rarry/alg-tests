package pl.mjankowski.codility.lesson6_sort

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 25.10.16
  */
class MaxProductOfThree {

  def solution(a: Array[Int]): Int = {

    val l = a.length

    val s = a.sorted
    val max = s(l-3) * s(l-2) * s(l-1)


    if(s(1) < 0){
      val tmp = s(0) * s(1) * s(l-1)
      if(tmp > max) tmp else max
    }else max

  }
}

object MaxProductOfThree {

  def main(args: Array[String]) {
    check(Array[Int](-3, 1, 2, -2, 5, 6), 60)
    check(Array[Int](-10, 1, 2, -6, 5, 6), 360)
    check(Array[Int](10, 1, 2, 6, 5, 6), 360)
  }

  private def check(A: Array[Int], expected: Int) {
    val obj: MaxProductOfThree = new MaxProductOfThree
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
  }

}
