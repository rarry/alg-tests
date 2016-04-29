package pl.mjankowski.tests.algs.pl.mjankowski.tests.algs.sort

import pl.mjankowski.tests.algs.Utils

/**
 * Created by mjankowski on 2016-04-29.
 */
object QuickSort extends Utils {

  def main(args: Array[String]) {
    val l = List(5,4,2,8,9,3,5,7,6,4,1,4,3,5,4,6,7,8,9,0)
//    println(sort(l).mkString(" "))

    val a = l.toArray
    sortInPlace(a, 0, a.length)
    println(a.mkString(" "))
  }

  def sort(l: List[Int]):List[Int] = {

    if(l.length == 0) l
    else{
      val pivot = l.head
      val low = l.filter(x => x < pivot)
      val middle = l.filter(x => x == pivot)
      val high = l.filter(x => x > pivot)
      sort(low) ::: middle ::: sort(high)
    }
  }

  def sortInPlace(a: Array[Int], from: Int, to: Int) {

    if(a.length > 0 && from < to) {
      val pivot = a(from)
      var i = from + 1
      var j = to - 1

      while(i < j) {
        while (i < to && a(i) <= pivot) i = i + 1
        while (j > from && a(j) >= pivot) j = j - 1
        if (i < j) swap(a, i, j)
      }
      swap(a, from, j)
      sortInPlace(a, from, j)
      sortInPlace(a, j+1, a.length)
    }
  }
}
