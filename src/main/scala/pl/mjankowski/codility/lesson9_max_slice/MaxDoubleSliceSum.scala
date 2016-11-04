package pl.mjankowski.codility.lesson9_max_slice

/**
  * 61%   https://codility.com/demo/results/trainingYNG67N-R36/
  * 69%   https://codility.com/demo/results/trainingCU5ZQA-Y3H/
 *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 29.10.16
  */
class MaxDoubleSliceSum {

  // 3, 2, 6, -1, 4, 5, -1, 2
  // 0 3, 5, 11, 10, 14, 19, 18, 20

  def solution(a: Array[Int]): Int = {

    val pSum = a.scanLeft(0l) { case (a, b) => a + b }
    var maxSum = 0l
    var start = 0
    var middle = 1
    var min = a(1)

    (2 until a.length).foreach { r =>

      if(a(r-1) < min){
        min = a(r-1)
        middle = r-1

        (start until middle).foreach { p =>
          val sum = pSum(r) - pSum(p + 1) - a(middle).toLong
          if(sum > maxSum){
            maxSum = sum
            start = p
            min = a(middle)
          }
        }
      }else{
        (middle until r).foreach { q =>
          (start until q).foreach { p =>
            val sum = pSum(r) - pSum(p + 1) - a(q).toLong
            if(sum > maxSum){
              maxSum = sum
              start = p
              middle = q
              min = a(middle)
            }
          }
        }
      }
    }
    maxSum.toInt
  }
}

object MaxDoubleSliceSum {



  def test(a: Array[Int]): Int = {

    val pSum = a.scanLeft(0l) { case (a, b) => a + b }
    var maxSum = 0l

    (2 until a.length).foreach { r =>
      (1 until r).foreach { q =>
        (0 until q).foreach { p =>
          val sum = pSum(r) - pSum(p + 1) - a(q).toLong
          maxSum = math.max(maxSum, sum)
        }
      }
    }
    maxSum.toInt
  }

  def generateRandom(size: Int): Array[Int] = {
    val r = scala.util.Random

    (0 until size) map(i => r.nextInt(20000) - 10000) toArray
  }

  def main(args: Array[String]) {
    check(Array[Int](3, 2, 6, -1, 4, 5, -1, 2))
    check(Array[Int](10000, 10000, 10000, 10000))
    check(generateRandom(1000))
//    check(generateRandom(10000))
  }

  private def check(A: Array[Int]) {

    val expected: Int = test(A)
    println(s"Input ${A.mkString(", ")}, expected $expected")

    val obj: MaxDoubleSliceSum = new MaxDoubleSliceSum
    val ret: Int = obj.solution(A)
    if (ret != expected) throw new RuntimeException("expected " + expected + ", but got " + ret)
    println("OK!")
  }

}