package pl.mjankowski.codility.lesson10_prime

import scala.collection.mutable.{ArrayBuffer, ListBuffer}


/**
  * 27%   https://codility.com/demo/results/trainingJGVKTH-JST/
  * 72%   https://codility.com/demo/results/trainingK7F7HY-CBQ/
  * 81%   https://codility.com/demo/results/trainingT8KZCV-T2E/
  * 100%  https://codility.com/demo/results/trainingRHTYR8-T4G/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 01.11.16
  */
class Peaks {

  def findPeaks(a: Array[Int]): Array[Int] = {
    var l = new ListBuffer[Int]()
    var i = 1
    while (i < a.length - 1) {
      if (a(i) > a(i - 1) && a(i) > a(i + 1))
        l += i
      i += 1
    }

    l.toArray
  }

  def findDividorsSorted(n: Int): Array[Int] = {

    val d1 = new ArrayBuffer[Int]()
    val d2 = new ArrayBuffer[Int]()
    val sqrtN = math.sqrt(n).floor.toInt
    var i = sqrtN
    while (i > 0) {
      if (n % i == 0) {
        d1 += i
        d2 += n / i
      }
      i -= 1
    }

    (d1.reverse ++ d2).toArray
  }


  def checkDivision(peaks: Array[Int], d: Int, n: Int): Boolean = {
    val i = n/d
    var k = 1
    var end = k * i
    var peekIdx = 0
    var found = true

    while (end < n + 1 && found) {

      found = false
      while (peekIdx < peaks.length && peaks(peekIdx) >= (end - i) && peaks(peekIdx) < end) {
        found = true
        peekIdx += 1
      }

      k += 1
      end = k * i
    }

    if (end < n + 1 || !found) false
    else true
  }

  def solution(a: Array[Int]): Int = {

    val peaks = findPeaks(a)
    println(s"Found ${peaks.length} peaks")
    val dividorsSorted = findDividorsSorted(a.length)
    println(s"Found ${dividorsSorted.length} dividors ${dividorsSorted.mkString(", ")}")
    var divCount = 0
    var break = false

    var dividor: Int = 0
    var i = dividorsSorted.length - 1
    while (i >= 0 && !break) {

      dividor = dividorsSorted(i)
      if (dividor <= peaks.length) {
        println(s"checking dividor = ${dividor}")
        val accepted = checkDivision(peaks, dividor, a.length)
        if (accepted) {
          break = true
        }
      }else{
        dividor = 0
      }
      i -= 1
    }
    dividor
  }

}

object Peaks {

  def main(args: Array[String]) {
    check(Array[Int](1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2), 3)
    check(Array[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), 0)
    check(Array[Int](1,2,1,1,1,2,1,1,1,2,1,1,1,2,1), 3)
    check(Array[Int](1), 0)
    check(Array[Int](1,2,1), 1)
    check(Array[Int](1,2,1,1,2,1,1,2,1,1,2,1,1,2,1,1,2,1,1,2,1), 7)
    check(Array[Int](1,2,1,1,1,1,2,1,2,1,2,1,1,2,1,1,2,1,1,2,1), 3)
    check(Array[Int](1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1), 1)
  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input ${A.mkString(", ")}, expected $expected")

    val obj: Peaks = new Peaks
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }
}
