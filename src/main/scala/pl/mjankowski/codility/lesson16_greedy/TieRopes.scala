package pl.mjankowski.codility.lesson16_greedy


/**
  * 100%    https://codility.com/demo/results/trainingX8V97C-VGH/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 05.11.16
  */
class TieRopes {

  def solution(k: Int, a: Array[Int]): Int = {

    var sum = 0
    var count = 0
    for(r <- a){
      sum += r
      if(sum >= k){
        count += 1
        sum = 0
      }
    }
    count
  }

}


object TieRopes {

  def main(args: Array[String]) {
    check(4, Array[Int](1, 2, 3, 4, 1, 1, 3), 3)
    check(4, Array[Int](4), 1)
    check(4, Array[Int](3), 0)
  }

  private def check(k: Int, a: Array[Int], expected: Int) {

    println(s"Input k = $k, A=${a.mkString(", ")}, expected ${expected}")

    val obj: TieRopes = new TieRopes
    val ret: Int = obj.solution(k, a)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }
}
