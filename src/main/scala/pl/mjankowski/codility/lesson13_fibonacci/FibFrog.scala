package pl.mjankowski.codility.lesson13_fibonacci

import scala.collection.mutable.ArrayBuffer

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 04.11.16
  */
class FibFrog {


  def solution(a: Array[Int]): Int = {

    val fibs = ArrayBuffer[Int]()

    def generateFib(n: Int): Unit = {

      if (n >= 0) fibs += 0
      if (n >= 1) fibs += 1

      var i = 3
      var fib = 1
      while (fib <= n) {
        fibs += fib
        fib = fibs(i - 1) + fibs(i - 2)
        i += 1
      }
    }

    def getBiggestSmallerThan(k: Int): Int = {
      var i = fibs.length
      while(i >= 0){
        val f = fibs(i)
        if(f<=k) return f
      }
      0
    }

    generateFib(a.length)

    val first = -1
    val last = a.length + 2
    var jumps = 0
    var sum = 0

    val biggest = getBiggestSmallerThan(last)
    if(biggest == last) jumps
    else{

    }

    0
  }
}

object FibFrog {

  def main(args: Array[String]) {
    check(Array[Int](15, 10, 3), 1)
    check(Array[Int](15), 1)
    check(Array[Int](1), 1)
    check(Array[Int](15), 1)
  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input A=${A.mkString(", ")}, expected ${expected}")

    val obj: FibFrog = new FibFrog
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}