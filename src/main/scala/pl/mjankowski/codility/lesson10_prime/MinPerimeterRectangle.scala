package pl.mjankowski.codility.lesson10_prime

/**
  * 100%    https://codility.com/demo/results/trainingYTTK4E-HH6/
 *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 31.10.16
  */
class MinPerimeterRectangle {

  def solution(n: Int): Int = {

    var i = 1
    val sqrtN = math.sqrt(n)
    var minPerimiter = Int.MaxValue
    while(i <= sqrtN){
      if(n % i == 0) {
        val p = 2 * (i + (n/i))
        minPerimiter = math.min(minPerimiter, p)
      }
      i += 1
    }

    minPerimiter
  }
}

object MinPerimeterRectangle {

  def main(args: Array[String]) {
    check(30, 22)
    check(25, 20)
    check(1, 4)
  }

  private def check(n: Int, expected: Int) {

    println(s"Input ${n}, expected $expected")

    val obj: MinPerimeterRectangle = new MinPerimeterRectangle
    val ret: Int = obj.solution(n)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}