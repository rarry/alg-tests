package pl.mjankowski.codility.lesson15_caterpilar

import scala.collection.mutable.ArrayBuffer

/**
  * 100%    https://codility.com/demo/results/trainingC3XG6T-S5C/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 05.11.16
  */
class AbsDistinct {

  def solution(a: Array[Int]): Int = {

    def split(a: Array[Int]): (Array[Int], Array[Int]) = {

      val b = ArrayBuffer[Int]()
      val c = ArrayBuffer[Int]()

      var i = 0
      while (i < a.length) {

        if (a(i) < 0) {
          b.prepend(math.abs((a(i))))
        } else {
          c.append(a(i))
        }
        i += 1
      }
      (b.toArray, c.toArray)
    }

    def merge(a: Array[Int], b: Array[Int]): Array[Int] = {

      val m = ArrayBuffer[Int]()
      var i = 0
      var j = 0
      while (i<a.length || j < b.length) {
        if(i<a.length && j < b.length){
          val x = a(i)
          val y = b(j)
          if(x < y){
            m.append(x)
            i +=1
          }else{
            m.append(y)
            j += 1
          }
        }else if(i<a.length){
          m.append(a(i))
          i += 1
        }else if(j<b.length){
          m.append(b(j))
          j += 1
        }
      }
      m.toArray
    }

    val (aa,bb) = split(a)
    val m = merge(aa,bb)

    var start = 0
    var distinctCount = 0

    while(start < m.length){
      distinctCount += 1
      var end = start + 1
      while(end < m.length && m(end) == m(start)){
        end += 1
      }
      start = end
    }
    distinctCount
  }




//  def solution(a: Array[Int]): Int = {
//
//    if(a.length == 0) 0
//    else {
//
//      var distinctCount = 1
//      var right = a.length / 2
//      var left = a.length / 2
//
//
//      while (left -1 >= 0 || right +1 < a.length) {
//
//        if(right + 1 < a.length) {
//          do {
//            right += 1
//            if (math.abs(a(right)) != math.abs(a(left))) distinctCount += 1
//          } while (right + 1 < a.length && math.abs(a(right)) <= math.abs(a(left)))
//        }
//
//        if(left - 1 >= 0) {
//          do {
//            left -= 1
//            if (math.abs(a(right)) != math.abs(a(left))) distinctCount += 1
//          } while (left - 1 >= 0 && math.abs(a(left)) <= math.abs(a(right)))
//        }
//
//      }
//      distinctCount
//    }
//  }

}

object AbsDistinct {

  def calculateExpected(a: Array[Int]): Int = a.map(x => math.abs(x)).distinct.length

  def generateRandom(size: Int): Array[Int] = {
    val r = scala.util.Random

    (0 until size) map(i => r.nextInt(size) - (size / 2)) toArray
  }

  def main(args: Array[String]) {
    check(Array[Int](-5,-3,-1,0,3,6), 5)

    val a = generateRandom(100).sorted
    check(a, calculateExpected(a))
//
    val b = generateRandom(1000).sorted
    check(b, calculateExpected(b))
  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input A=${A.mkString(", ")}, expected ${expected}")

    val obj: AbsDistinct = new AbsDistinct
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}