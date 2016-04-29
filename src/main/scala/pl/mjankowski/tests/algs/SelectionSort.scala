package pl.mjankowski.tests.algs

/**
 * Created by mjankowski on 2016-04-28.
 */
object SelectionSort extends Utils{

  def main(args: Array[String]) {
    val a = Array(1, 4, 2, 8, 5, 3, 2, 1, 9, 2, 6, 7, 8, 9, 0, 1, 2, 3)
    sort(a)

    a foreach (x => print(x+" "))
  }

  def sort(t: Array[Int]): Unit = {

    var i = 0
    while(i < t.length) {
      var minIndex = i
      var j = i+1
      while(j < t.length) {
        if (t(j) < t(minIndex)) minIndex = j
        j = j + 1
      }
      swap(t, minIndex, i)
      i = i+1
    }
  }
}
