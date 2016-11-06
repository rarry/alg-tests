package pl.mjankowski.codility.lesson15_caterpilar

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 05.11.16
  */
class Caterpilar {

  def solution(a: Array[Int], sum: Int): Boolean = {

    var front = 0
    var total = 0

    for (back <- (0 to a.length) if back <= front) {

      while (total + a(front) <= sum && front < a.length) {
        total += a(front)
        front += 1
      }

      if (total == sum) return true
      else {
        total -= a(back)
      }

    }
    false
  }
}

object Caterpilar {

  def main(args: Array[String]) {
    check(Array[Int](6, 2, 7, 4, 1, 3, 6), true)
  }

  private def check(A: Array[Int], expected: Boolean) {

    println(s"Input A=${A.mkString(", ")}, expected ${expected}")

    val obj: Caterpilar = new Caterpilar
    val ret: Boolean = obj.solution(A, 12)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}