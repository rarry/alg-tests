package pl.mjankowski.codility.lesson16_greedy

/**
  * 100%  https://codility.com/demo/results/training7U8XHQ-YCH/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 05.11.16
  */
class MaxNonoverlappingSegments {

  case class Interval(from: Int, to: Int) {
    def intersects(that: Interval): Boolean =
      that.from <= this.to && that.to >= this.from
  }

  def solution(a: Array[Int], b: Array[Int]): Int = {

    var covered = Interval(-1,-1)
    var count = 0

    for(i <- (0 until b.length)){

      val int = Interval(a(i), b(i))
      if(!int.intersects(covered)){
        count += 1
        covered = Interval(math.min(covered.from, int.from), math.max(covered.to, int.to))
      }
    }
    count
  }
}


object MaxNonoverlappingSegments {

  def main(args: Array[String]) {
    check(Array[Int](1,3,7,9,9), Array[Int](5,6,8,9,10), 3)
  }

  private def check(a: Array[Int], b: Array[Int], expected: Int) {

    println(s"Input A=${a.mkString(", ")}, B=${b.mkString(", ")}, expected ${expected}")

    val obj: MaxNonoverlappingSegments = new MaxNonoverlappingSegments
    val ret: Int = obj.solution(a,b)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}