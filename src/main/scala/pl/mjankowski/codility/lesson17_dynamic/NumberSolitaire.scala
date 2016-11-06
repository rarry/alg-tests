package pl.mjankowski.codility.lesson17_dynamic

/**
  * 100%    https://codility.com/demo/results/trainingWYX55E-CRJ/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 05.11.16
  */
class NumberSolitaire {

  def solution(a: Array[Int]): Int = {

    val maxSum = Array.fill(a.length)(0)
    maxSum(0) = a(0)

    var i = 1
    while(i < a.length){
      val maxs = (1 to math.min(i, 6)).map(j => maxSum(i-j) + a(i))
      maxSum(i) = maxs.max
      i += 1
    }
    maxSum(a.length-1)
  }
}


object NumberSolitaire {

  def main(args: Array[String]) {
    check(Array[Int](1,-2,0,9,-1,-2), 8)
    check(Array[Int](1,-1), 0)
  }

  private def check(a: Array[Int], expected: Int) {

    println(s"Input A=${a.mkString(", ")}, expected ${expected}")

    val obj: NumberSolitaire = new NumberSolitaire
    val ret: Int = obj.solution(a)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }
}