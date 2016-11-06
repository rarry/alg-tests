package pl.mjankowski.codility.lesson15_caterpilar

/**
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 05.11.16
  */
class Sticks {

  def solution(a: Array[Int]): Int = {

    var count = 0

    for(x <- (0 until a.length - 2)){
      var z = x + 2
      for(y <- (x + 1 until a.length - 1)){

        while(z < a.length && a(x) + a(y) > a(z)){
          z += 1
        }
        count += z - y - 1
      }
    }
    count
  }
}

object Sticks {

  def main(args: Array[String]) {
    val obj: Sticks = new Sticks
    println(obj.solution(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)))
  }
}