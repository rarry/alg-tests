package pl.mjankowski.codility.lesson6_sort

/**
  * 6%    https://codility.com/demo/results/trainingEJ4C68-3QH/
  * 93%   https://codility.com/demo/results/trainingPD6JZ7-ZNF/
  * 93%   https://codility.com/demo/results/training3WD3G5-DVQ/
  * 100%  https://codility.com/demo/results/training6ZYN8X-ZZA/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 25.10.16
  */
class NumberOfDiscIntersections {

  case class Interval(from: Long, to: Long) {
    def intersects(that: Interval): Boolean =
      that.from <= this.to && that.to >= this.from
  }

  def solution(a: Array[Int]): Int = {

    val intervals = a.zipWithIndex.map { case (e, i) => Interval(i.toLong - e.toLong, i.toLong + e.toLong) }
    val sorted = intervals.sortWith(_.from < _.from)

    def findFLastIntersecting(interval1: Interval, idx: Int, n: Int): Int = {
      var lastIntersecting = idx
      var firstNotIntersecting = n

      while(firstNotIntersecting - lastIntersecting > 1){

        val j = (lastIntersecting + firstNotIntersecting)/2
        val interval2 = sorted(j)
        if(interval1.intersects(interval2)){
          lastIntersecting = j
        }else{
          firstNotIntersecting = j
        }
      }
      lastIntersecting
    }

    def countIntersecting(interval1: Interval, idx: Int): Int = {

      val n = sorted.length - 1
      if(interval1.intersects(sorted(n))){
        n-idx
      }else{
        val last = findFLastIntersecting(interval1, idx, n)
        last - idx
      }
    }

    var sum = 0
    var i = 0

    while (i < sorted.length) {
      val interval1 = sorted(i)
      sum += countIntersecting(interval1, i)
      if(sum > 10000000){
        sum = -1
        i = sorted.length
      }else{
        i += 1
      }
    }

    sum
  }

}

object NumberOfDiscIntersections {

  val r = scala.util.Random

  def generateArray = {

  }

  def main(args: Array[String]) {
    check(Array[Int](1, 5, 2, 1, 4, 0), 11)
    check(Array[Int](), 0)
    check(Array[Int](1,1,1), 2)
    check(Array[Int](1,2,3), 3)
    check(Array[Int](3,3,3), 3)



  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input ${A.mkString(", ")}, expected $expected")

    val obj: NumberOfDiscIntersections = new NumberOfDiscIntersections
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}