package pl.mjankowski.codility.lesson14_binary_search

import java.util

import scala.annotation.tailrec

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 06.11.16
  */
class BinarySearch {

  def solution(a: Array[Int], k: Int): Boolean = {

    @tailrec
    def binarySearch(from: Int, to: Int): Boolean = {
      if(from > to) false
      else if (from == to) {
        if(a(from) == k) true
        else false
      } else {
        val mid = (from + to) / 2
        if (a(mid) == k) true
        else if (a(mid) < k) binarySearch(mid + 1, to)
        else binarySearch(from, mid - 1)
      }
    }

    binarySearch(0, a.length-1)
  }
}

object BinarySearch {
  val r = scala.util.Random

  def generateRandom(size: Int): Array[Int] = {
    (0 until size).map(i => r.nextInt(2*size-1)+1).toArray.sorted
  }

  def main(args: Array[String]) {

    val size = 100

    for(i <- (0 until 100)) {
      val a = generateRandom(size)
      val k = r.nextInt(2 * size - 1)
      check(a, k, util.Arrays.binarySearch(a, k) >= 0)
    }
  }

  private def check(a: Array[Int], k:Int, expected: Boolean) {

    println(s"Input A=${a.mkString(", ")}, k=$k, expected ${expected}")

    val obj: BinarySearch = new BinarySearch
    val ret: Boolean = obj.solution(a, k)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }
}