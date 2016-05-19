package pl.mjankowski.tests.algs.sort

/**
 * Created by mjankowski on 2016-04-29.
 */

object MergeSort{

  def main(args: Array[String]) {
//    val l = List(2,4,6,8,10)
//    val r = List(1,2,3,5,7,9, 10, 11, 15, 17)
//
//    merge(l,r) foreach println

    val l = List(5,4,2,8,9,3,5,7,6,4,1,4,3,5,4,6,7,8,9,0)
    println(sort(l).mkString(" "))
  }

  def split(l: List[Int]): (List[Int], List[Int]) = l.splitAt(l.length / 2)

  def merge(left: List[Int], right: List[Int]): List[Int] = {

    if(left.length == 0) right
    else if(right.length == 0) left
    else{
      val fromLeft = left.head
      val fromRight = right.head
      if (fromLeft < fromRight) {
        fromLeft :: merge(left.tail, right)
      } else {
        fromRight :: merge(left, right.tail)
      }
    }
  }

  def sort(l: List[Int]): List[Int] = {

    if(l.length == 1) l
    else{
      val (left, right) = split(l)
      val leftSorted = sort(left)
      val rightSorted = sort(right)
      merge(leftSorted, rightSorted)
    }

  }

}
