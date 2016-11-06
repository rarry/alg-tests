package pl.mjankowski.codility.lesson13_fibonacci

import scala.collection.mutable.ArrayBuffer

/**
  * 91%   https://codility.com/demo/results/trainingEWYFD9-5T6/
  * 100%  https://codility.com/demo/results/training6EMVKG-UPK/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 04.11.16
  */
class FibFrog {


  def solution(a: Array[Int]): Int = {

    val n = a.length
    var fibs = ArrayBuffer[Int]()

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

    generateFib(n + 2)
    fibs = fibs.tail.tail

    val minJumps = Array.fill(n + 2)(-1)

    def d(i: Int): Int = {
      if(i <= 0)  0
      else{
        minJumps(i)
      }
    }

    def allowed(k: Int): Boolean = {
      val i = k-1
      if(i < 0) true
      else if(i>=n) true
      else a(i) == 1
    }

    for (i <- (-1 to n+1)) {

      if (allowed(i)) {
        val fibs2 = fibs.collect {
          case f if i - f >= 0 && allowed(i - f) && d(i - f) >= 0 => f
        }
        val candidates = fibs2.map(f => d(i - f) + 1)
        if (candidates.length > 0) {
          minJumps(i) = candidates.min
        }
      }
    }

    minJumps(n + 1)
  }

}

object FibFrog {

  def main(args: Array[String]) {
    check(Array[Int](0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0), 3)
    check(Array[Int](0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1), 3)
    check(Array[Int](), 1)
    check(Array[Int](1), 1)
    check(Array[Int](0,0), 1)
    check(Array[Int](0,0, 0), -1)
  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input A=${A.mkString(", ")}, expected ${expected}")

    val obj: FibFrog = new FibFrog
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}