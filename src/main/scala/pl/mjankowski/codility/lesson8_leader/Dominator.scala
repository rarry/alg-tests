package pl.mjankowski.codility.lesson8_leader

/**
  * https://codility.com/demo/results/trainingJG49CP-K76/
  * 100% https://codility.com/demo/results/training989C2X-FQG/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 29.10.16
  */
class Dominator {

  def solution(a: Array[Int]): Int = {

    if (a.isEmpty) {
      -1
    } else {
      var candidate: Int = a.head
      var count = 1

      val tail = a.tail
      tail.foreach { e =>
        if (count == 0) {
          candidate = e
          count += 1
        } else {
          if (e != candidate) {
            count -= 1
          } else {
            count += 1
          }
        }
      }

      if (count > 0) {
        val candidateCount = a.filter(x => x == candidate).length
        if (candidateCount > a.length / 2) {
          a.zipWithIndex.find { case (x, i) => x == candidate }.get._2
        } else {
          -1
        }
      } else {
        -1
      }
    }
  }
}


object Dominator {

  def main(args: Array[String]) {
    check(Array[Int](3, 4, 3, 2, 3, -1, 3, 3), 0)
    check(Array[Int](), -1)
    check(Array[Int](1, 2, 1, 3, 4, 5, 6, 7), -1)
    check(Array[Int](1, 2, 1, 3, 4, 5, 6, 7, 1), -1)
  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input ${A.mkString(", ")}, expected $expected")

    val obj: Dominator = new Dominator
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}