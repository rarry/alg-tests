package pl.mjankowski.codility.lesson14_binary_search

import java.util

import scala.annotation.tailrec

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 06.11.16
  */
class MinMaxDivision {

  def solution(k: Int, m: Int, a: Array[Int]): Int = {

    var currentMax = Int.MaxValue


    def binarySearch(from: Int, to: Int): Int = {
//      if(from > to) currentMax
//      else if (from == to) {
//        if(a(from) == k) true
//        else false
//      } else {
//        val mid = (from + to) / 2
//        if (a(mid) == k) true
//        else if (a(mid) < k) binarySearch(a, mid + 1, to, k)
//        else binarySearch(a, from, mid - 1, k)
//      }
      0
    }

    binarySearch(a.length / k, a.length)
  }
}

object MinMaxDivision {
//  val r = scala.util.Random
//
//  def generateRandom(size: Int): Array[Int] = {
//    (0 until size).map(i => r.nextInt(2 * size - 1) + 1).toArray.sorted
//  }

  def main(args: Array[String]) {

    check(3, 5, Array(2,1,5,1,2,2,2), 6)

//    val size = 100
//
//    for (i <- (0 until 10000)) {
//      val a = generateRandom(size)
//      val k = r.nextInt(2 * size - 1)
//      check(a, k, util.Arrays.binarySearch(a, k) >= 0)
//    }
  }

  private def check(k: Int, m: Int, a: Array[Int], expected: Int) {

    println(s"Input A=${a.mkString(", ")}, k=$k, expected ${expected}")

    val obj: MinMaxDivision = new MinMaxDivision
    val ret: Int = obj.solution(k, m, a)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }
}
