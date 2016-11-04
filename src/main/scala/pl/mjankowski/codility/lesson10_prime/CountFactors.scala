package pl.mjankowski.codility.lesson10_prime

/**
  * 93%   https://codility.com/demo/results/training67U3UW-XHR/
  * 100%  https://codility.com/demo/results/trainingFVU5RC-TY5/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 31.10.16
  */
class CountFactors {

  def solution(n: Int): Int = {

    var i=1
    var result = 0
    val sqrtN = math.sqrt(n)
    while(i < sqrtN){
      if(n % i == 0) result += 2
      i += 1
    }
    if(i*i == n) result += 1

    result
  }
}

object CountFactors {

  def main(args: Array[String]) {
    check(24, 8)
  }

  private def check(n: Int, expected: Int) {

    println(s"Input ${n}, expected $expected")

    val obj: CountFactors = new CountFactors
    val ret: Int = obj.solution(n)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}