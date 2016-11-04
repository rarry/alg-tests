package pl.mjankowski.codility.lesson7_stacks

import scala.collection.mutable

/**
  * https://codility.com/demo/results/training6JM23S-UKA/
  * https://codility.com/demo/results/trainingM6AYGQ-BTC/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 28.10.16
  */
class Fish {

  val upstream = 0
  val downstream = 1

  case class Fish(direction: Int, size: Int){

    def fight(that: Fish): Fish =
      if(this.size > that.size) this else that
  }

  def fightWithStack(stack: mutable.Stack[Fish], Q: Fish): Unit = {

    if(!stack.isEmpty) {
      var P = stack.pop

      if(P.direction == downstream && Q.direction == upstream){
        val winner = P.fight(Q)
        if(winner == Q) fightWithStack(stack, winner)
        else stack.push(P)
      }else {
        stack.push(P)
        stack.push(Q)
      }
    }else {
      stack.push(Q)
    }
  }

  def solution(a: Array[Int], b: Array[Int]): Int = {
    val stack = new mutable.Stack[Fish]()

    (0 until a.length).foreach{ i =>

      val Q = Fish(b(i), a(i))
      fightWithStack(stack, Q)
    }

    stack.length
  }
}

object Fish {

  def main(args: Array[String]) {
    check(Array[Int](4,3,2,5,1), Array[Int](1,1,1,0,1), 2)
    check(Array[Int](4,3,2,5,6), Array[Int](1,1,1,1,0), 1)
    check(Array[Int](4,3,2,1,5), Array[Int](0,1,0,0,0), 2)
    check(Array[Int](4), Array[Int](0), 1)
  }

  private def check(a: Array[Int], b: Array[Int], expected: Int) {

    println(s"Input ${a.mkString(", ")}, ${b.mkString(", ")} expected $expected")

    val obj: Fish = new Fish
    val ret: Int = obj.solution(a,b)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}
