package pl.mjankowski.codility.lesson7_stacks

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 29.10.16
  */
class Nesting {

  def solution(s: String): Int = {

    var correct: Boolean = true
    var countLeft = 0
    val chars = s.toCharArray

    var i: Int = 0
    while(i < s.length){

      val c = chars(i)
      if(c == ')'){
        if(countLeft == 0){
          correct = false
          i = s.length
        }else{
          countLeft -= 1
        }
      }else if(c == '('){
          countLeft += 1
      }
      i += 1
    }

    if(correct && countLeft == 0) 1 else 0
  }
}

object Nesting {

  def main(args: Array[String]) {
    check( "(()(())())", 1)
    check("())", 0)
    check("", 1)

    val long = new StringBuilder
    (1 to 25000).foreach(i => long ++= "(()(())())")

    check(long.toString(), 1)
    long ++= ")"
    check(long.toString(), 0)
  }

  private def check(s: String, expected: Int) {

    println(s"Input ${s}, expected $expected")

    val obj: Nesting = new Nesting
    val ret: Int = obj.solution(s)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)

    println("OK!")
  }

}

