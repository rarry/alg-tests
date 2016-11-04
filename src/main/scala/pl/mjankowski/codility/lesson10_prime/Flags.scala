package pl.mjankowski.codility.lesson10_prime

import scala.collection.mutable.ListBuffer

/**
  * 40%   https://codility.com/demo/results/trainingT74Q4B-6FV/
  * 93%   https://codility.com/demo/results/trainingYZE98C-6W8/
  * 100%  https://codility.com/demo/results/trainingC6XWF7-DNW/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 31.10.16
  */
class Flags {

  def findPeaks(a: Array[Int]): Array[Int] = {
    var l = new ListBuffer[Int]()
    var i=1
    while(i<a.length-1){
      if(a(i)>a(i-1) && a(i) > a(i+1))
        l += i
      i+=1
    }

    l.toArray
  }

  def countFlags(peeks: Array[Int], k: Int): Int = {

    if(!peeks.isEmpty){
      var p = peeks(0)
      var count = 1
      var i = 1

      while(count < k && i < peeks.length) {
        val q = peeks(i)

        if (math.abs(p - q) >= k) {
          count += 1
          p = q
        }
        i += 1
      }
      count
    }else{
      0
    }
  }


  def solution(a: Array[Int]): Int = {

    val peeks = findPeaks(a)
    println(s"Found ${peeks.length} peeks")
    val maxFlags = math.sqrt(a.length).floor.toInt + 1
    println(s"There can be at most $maxFlags flags")
    var flagsCount = 0

    var i=maxFlags
    while(i > 0 && i > flagsCount){
      println(s"Trying $i flags")
      val flagsPlaced: Int = countFlags(peeks, i)
      println(s"Could place only $flagsPlaced")
      flagsCount = math.max(flagsCount, flagsPlaced)

      i-=1
    }

    flagsCount
  }
}

object Flags {

  def main(args: Array[String]) {
    check(Array[Int](1,5,3,4,3,4,1,2,3,4,6,2), 3)
    check(Array[Int](1,2,1,1,1,2,1,1,1,2,1,1,1,2,1), 4)
    check(Array[Int](1), 0)
    check(Array[Int](1,2), 0)
    check(Array[Int](1,2,1), 1)
  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input ${A.mkString(", ")}, expected $expected")

    val obj: Flags = new Flags
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}