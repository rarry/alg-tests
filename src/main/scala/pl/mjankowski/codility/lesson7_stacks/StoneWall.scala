package pl.mjankowski.codility.lesson7_stacks

import scala.collection.mutable

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 28.10.16
  */
class StoneWall {

  def solution(h: Array[Int]): Int = {

    val stack = mutable.Stack[Int]()
    var count = 0

    h.foreach{ l =>

      if(stack.isEmpty) {
        stack.push(l)
        count += 1
      } else{

        if(stack.top < l){
          stack.push(l)
          count += 1
        }else if(stack.top > l){
          stack.pop

          while(!stack.isEmpty && stack.top > l) stack.pop()

          if(stack.isEmpty || stack.top < l) {
            stack.push(l)
            count += 1
          }

          // stack.top == l
        }

        // stack.top == l
      }
    }
    count

  }
}

object StoneWall {

  def main(args: Array[String]) {
    check(Array[Int](8,8,5,7,9,8,7,4,8), 7)
    check(Array[Int](8), 1)
  }

  private def check(A: Array[Int], expected: Int) {

    println(s"Input ${A.mkString(", ")}, expected $expected")

    val obj: StoneWall = new StoneWall
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}