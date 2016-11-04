package pl.mjankowski.codility.lesson11_sieve

/**
  * 100%    https://codility.com/demo/results/training6E6YNF-NCZ/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 02.11.16
  */
class CountSemiprimes {

  def isSemiprime(s: Int, p: Array[Int]): Boolean = {

    def isPrime(n: Int) = p(n) == 0

    val first = p(s)
    first > 0 && isPrime(first) && isPrime(s / first)
  }

  def firstDividors(n: Int): Array[Int] = {

    val f = Array.fill[Int](n)(0)

    var i=2
    while(i < math.sqrt(n)) {
      var k = i * i
      while (k < n) {
        if (f(k) == 0) {
          f(k) = i
        }
        k += i
      }
      i += 1
    }
    f
  }

  def solution(n: Int, p: Array[Int], q: Array[Int]): Array[Int] = {

    val f = firstDividors(n+1)

    val sp = (0 to n).map(i => if(isSemiprime(i,f)) 1 else 0)
    val prefixSum = sp.scanLeft(0)(_ + _)

    p.zip(q).map{ case(from,to) => prefixSum(to+1) - prefixSum(from) }
  }
}


object CountSemiprimes {

  def main(args: Array[String]) {
    check(26, Array[Int](1,4,16), Array[Int](26,10,20), Array(10,4,0))
    check(1, Array[Int](0,1,0), Array[Int](0,1,1), Array(0,0,0))
    check(10, Array[Int](0), Array[Int](10), Array(4))
  }

  private def check(N: Int, A: Array[Int], B: Array[Int], expected: Array[Int]) {

    println(s"Input A=${A.mkString(", ")}, B=${B.mkString(", ")}, expected ${expected.mkString(", ")}")

    val obj: CountSemiprimes = new CountSemiprimes
    val ret: Array[Int] = obj.solution(N, A, B)
    if (ret.deep != expected.deep) throw new RuntimeException("expected " + expected.mkString(", ") + ", but got " + ret.mkString(", "))
    println("OK!")
  }

}