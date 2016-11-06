package pl.mjankowski.codility.lesson13_fibonacci

/**
  * 50%   https://codility.com/demo/results/trainingVRY5FQ-TNX/
  * 100%  https://codility.com/demo/results/trainingC4DRBP-ZT2/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 05.11.16
  */
class Ladder {

  def solution(a: Array[Int], b: Array[Int]): Array[Int] = {


    def generateFibs(n: Int): Array[Long] = {

      val counts = Array.fill(n+1)(0l)
      if(n > 0) counts(1) = 1l
      if(n > 1) counts(2) = 2l

      if(n > 3) {
        var last = 2l
        var beforeLast = 1l
        for (i <- (3 to n)) {
          val current = (last + beforeLast) % math.pow(2, 30).toLong
          counts(i) = current
          beforeLast = last
          last = current
        }
      }
      counts
    }

    val maxL = a.max
    val counts = generateFibs(maxL)

    a.zip(b).map{case (n, b) => (counts(n) % math.pow(2,b).toLong).toInt }

  }
}

object Ladder {

  def main(args: Array[String]) {
    check(Array[Int](4,4,5,5,1), Array[Int](3,2,4,3,1), Array(5,1,8,0,1))
    check(Array[Int](0), Array[Int](1), Array(0))
  }

  private def check(A: Array[Int], B: Array[Int], expected: Array[Int]) {

    println(s"Input A=${A.mkString(", ")}, B=${B.mkString(", ")}, expected ${expected.mkString(", ")}")

    val obj: Ladder = new Ladder
    val ret: Array[Int] = obj.solution(A, B)
    if (ret.deep != expected.deep) throw new RuntimeException("expected " + expected.mkString(", ") + ", but got " + ret.mkString(", "))
    println("OK!")
  }

}