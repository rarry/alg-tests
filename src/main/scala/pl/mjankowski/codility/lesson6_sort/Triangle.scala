package pl.mjankowski.codility.lesson6_sort

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 25.10.16
  */
class Triangle {

  def solution(a: Array[Int]): Int = {

    if(a.length <= 2) 0
    else {
      val s = a.sorted
      val b = s.sliding(3).exists(a => a(0).toLong + a(1).toLong > a(2).toLong)
      if (b) 1 else 0
    }
  }
}

object Triangle {

  def main(args: Array[String]) {
    check(Array[Int](10,2,5,1,8,20), 1)
    check(Array[Int](10,50,5,1), 0)
    check(Array[Int](), 0)
    check(Array[Int](1), 0)
    check(Array[Int](1,2), 0)
    check(Array[Int](-1,-2, 1), 0)
    check(Array[Int](-1,-2, 0), 0)
    check(Array[Int](-1,-2, -3), 0)
  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input ${A.mkString(", ")}, expected $expected")

    val obj: Triangle = new Triangle
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
  }

}




