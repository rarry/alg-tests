package pl.mjankowski.codility.lesson12_euclidan

/**
  * 69%   https://codility.com/demo/results/trainingJFD3F9-YX5/
  * 46%   https://codility.com/demo/results/trainingKG4HZ8-QZY/
  * 30%   https://codility.com/demo/results/trainingT56AFK-U2B/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 03.11.16
  */
class CommonPrimeDivisors {

  def solution(a: Array[Int], b: Array[Int]): Int = {
    def gcd(n: Int, m: Int): Int = {
      if(n % m == 0) m
      else gcd(m, n % m)
    }

    def samePrimeDivisors(n: Int, m: Int): Int = {
      val nwd = gcd(n,m)
      val first = n / nwd
      val second = m / nwd

      if(n % first == 0 && m % first == 0 && n % second == 0 && m % second == 0) 1
      else 0
    }

    a.zip(b).map{case (n,m) => samePrimeDivisors(n,m)}.sum
  }
}


object CommonPrimeDivisors {

  def main(args: Array[String]) {
    check(Array[Int](15,10,3), Array[Int](75,30,5), 1)
    check(Array[Int](15), Array[Int](75), 1)
    check(Array[Int](1), Array[Int](1), 1)
    check(Array[Int](15), Array[Int](135), 1)
  }

  private def check(A: Array[Int], B: Array[Int], expected: Int) {

    println(s"Input A=${A.mkString(", ")}, B=${B.mkString(", ")}, expected ${expected}")

    val obj: CommonPrimeDivisors = new CommonPrimeDivisors
    val ret: Int = obj.solution(A, B)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}