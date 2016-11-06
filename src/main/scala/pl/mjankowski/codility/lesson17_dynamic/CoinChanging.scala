package pl.mjankowski.codility.lesson17_dynamic

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 05.11.16
  */
class CoinChanging {

  def solution(k: Int, a: Array[Int]): Int = {

    val d = Array.ofDim[Int](a.length+1, k+1)

    for (i <- (0 until a.length+1)) {
      for (j <- (0 until k+1)) {
        if (i == 0) d(i)(j) = Int.MaxValue
        else if (j == 0) d(i)(j) = 0
        else {
          if(j < a(i-1)){
            d(i)(j) = d(i - 1)(j)
          }else{
            d(i)(j) = math.min(d(i)(j - a(i - 1))+1, d(i - 1)(j))
          }

        }
      }
    }

    d(a.length)(k)
  }
}

object CoinChanging {

  def main(args: Array[String]) {
    check(6, Array[Int](1,3,4), 2)
  }

  private def check(k: Int, a: Array[Int], expected: Int) {

    println(s"Input k = $k, A=${a.mkString(", ")}, expected ${expected}")

    val obj: CoinChanging = new CoinChanging
    val ret: Int = obj.solution(k, a)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }
}
