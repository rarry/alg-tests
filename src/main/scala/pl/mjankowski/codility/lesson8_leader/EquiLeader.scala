package pl.mjankowski.codility.lesson8_leader

/**
  * 100%    https://codility.com/demo/results/training3UWHJ7-DSB/
 *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 29.10.16
  */
class EquiLeader {


  def findLeader(a: Array[Int]): Option[Int] = {
    if (a.isEmpty) {
      None
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
          Some(candidate)
        } else {
          None
        }
      } else {
        None
      }
    }
  }

  def solution(a: Array[Int]): Int = {

    var equiLeaderCount = 0
    var leaderCount = 0
    findLeader(a) match {
      case Some(leader) =>
        val allLeadersCount = a.filter(x => x == leader).length

        a.zipWithIndex.foreach { case (e, i) =>
          if (e == leader) {
            leaderCount += 1
          }
          if (leaderCount > (i + 1) / 2 && (allLeadersCount - leaderCount) > (a.length - (i + 1)) / 2) {
            equiLeaderCount += 1
          }
        }
        equiLeaderCount
      case None =>
        0
    }

  }
}


object EquiLeader {

  def main(args: Array[String]) {
    check(Array[Int](4,3,4,4,4,2), 2)
    check(Array[Int](1), 0)
    check(Array[Int](1, 1), 1)

    check(Array[Int](-1, 1, 1, 2, 2, 2, 3, -1), 0)
  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input ${A.mkString(", ")}, expected $expected")

    val obj: EquiLeader = new EquiLeader
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}