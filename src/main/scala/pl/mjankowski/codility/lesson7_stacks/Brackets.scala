package pl.mjankowski.codility.lesson7_stacks

import scala.collection.mutable

/**
  * 100%    https://codility.com/demo/results/training4T3JEV-DJT/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 27.10.16
  */
class Brackets {

  def solution(s: String): Int = {

    def isOpening(c: Char): Boolean = c == '{' || c == '[' || c == '('

    def isClosing(c: Char): Boolean = c == '}' || c == ']' || c == ')'

    def matches(c1: Char, c2: Char): Boolean = {
      (c1,c2) == ('{', '}') || (c1,c2) == ('[', ']') || (c1,c2) == ('(', ')')
    }

    val stack = mutable.Stack[Char]()
    val chars = s.toCharArray

    val proper = chars.forall{ c =>

      if(isClosing(c)){
        !stack.isEmpty && matches(stack.pop(),c)
      }else{
        if(isOpening(c)) stack.push(c)
        true
      }
    }

    if(proper && stack.isEmpty) 1 else 0
  }

}

object Brackets {

  def main(args: Array[String]) {
    check("{[()()]}", 1)
    check("{[()()]", 0)
    check("([)()]", 0)

    val long = new StringBuilder
    (1 to 25000).foreach(i => long ++= "{[()()]}")

    check(long.toString(), 1)
    long ++= ")"
    check(long.toString(), 0)
  }

  private def check(s: String, expected: Int) {

    println(s"Input ${s}, expected $expected")

    val obj: Brackets = new Brackets
    val ret: Int = obj.solution(s)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)

    println("OK!")
  }

}

