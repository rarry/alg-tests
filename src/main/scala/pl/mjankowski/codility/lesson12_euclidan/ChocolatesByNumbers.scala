package pl.mjankowski.codility.lesson12_euclidan

/**
  * 62%   https://codility.com/demo/results/trainingDCGNXZ-T6K/ (Java Heap Space)
  * 100%  https://codility.com/demo/results/trainingWCVCVJ-MJM/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 03.11.16
  */
class ChocolatesByNumbers {

  def solution(n: Int, m: Int): Int = {

    val a = n.toLong
    val b = m.toLong

    def findNwd(n: Long, m: Long): Long = {
      if(n % m == 0) m
      else findNwd(m, n % m)
    }

    val nwd = findNwd(a,b)
    val nww = a*b/nwd
    (nww / b).toInt
  }
}


object ChocolatesByNumbers {

  def test(n: Int, m: Int): Int = {

    val visited = Array.fill(n)(false)
    var count = 0

    var i = 0
    while (!visited(i)) {
      visited(i) = true
      count += 1
      i = (i + m) % n
    }

    count
  }

  def testLarge = {
    val r = scala.util.Random
    val s: Seq[(Int, Int)] = (0 until 3).map(_ => (r.nextInt(1000000000 - 1) + 1, r.nextInt(1000000000 - 1) + 1))
    s.foreach { case (n, m) => check(n, m) }
  }

  def main(args: Array[String]) {
//    check(10, 4)
//    check(1, 1)
    check(457371313, 9506108)

//    testLarge
  }

  private def check(n: Int, m: Int) {

    val expected: Int = test(n, m)

    println(s"Input n=$n, m=$m, expected $expected")

    val obj: ChocolatesByNumbers = new ChocolatesByNumbers
    val ret = obj.solution(n, m)
    if (ret != expected) throw new RuntimeException(s"expected $expected but got $ret")
    println("OK!")
  }

}