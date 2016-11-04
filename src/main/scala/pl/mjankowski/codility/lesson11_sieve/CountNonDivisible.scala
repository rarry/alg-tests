package pl.mjankowski.codility.lesson11_sieve

/**
  * 77%   https://codility.com/demo/results/trainingA9GT5E-48Y/
  * 100%  https://codility.com/demo/results/trainingMAKH2G-ESS/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 03.11.16
  */
class CountNonDivisible {

  def solution(a: Array[Int]): Array[Int] = {

    val countDivisable = Array.fill(2*a.length + 1)(0)

    var i=0
    while(i < a.length) {
      val e = a(i)
      var k = e
      while (k < countDivisable.length) {
        countDivisable(k) += 1
        k += e
      }
      i += 1
    }

    a.map(e => a.length - countDivisable(e))
  }
}

object CountNonDivisible {

  def test(a: Array[Int]): Array[Int] = {

    val counts = Array.fill(a.length)(0)

    var i = 0
    while(i < a.length){
      var j = 0
      while(j < a.length){
        if(i != j && a(i) % a(j) != 0){
          counts(i) += 1
        }
        j += 1
      }
      i += 1
    }
    counts
  }

  def generateRandom(size: Int): Array[Int] = {
    val r = scala.util.Random

    (0 until size) map(i => r.nextInt(2*size-1)+1) toArray
  }

  def main(args: Array[String]) {
    check(Array[Int](3,1,2,3,6))
    check(Array[Int](2))
    check(generateRandom(10000))
    check(generateRandom(50000))
  }

  private def check(A: Array[Int]) {

    val expected: Array[Int] = test(A)

    println(s"Input A=${A.mkString(", ")}, expected ${expected.mkString(", ")}")

    val obj: CountNonDivisible = new CountNonDivisible
    val ret: Array[Int] = obj.solution(A)
    if (ret.deep != expected.deep) throw new RuntimeException("expected " + expected.mkString(", ") + ", but got " + ret.mkString(", "))
    println("OK!")
  }

}