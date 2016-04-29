package pl.mjankowski.tests.algs

/**
 * Created by mjankowski on 2016-04-29.
 */
trait Utils {
  def swap(t: Array[Int], i: Int, j: Int): Unit = {
    val tmp = t(i)
    t(i) = t(j)
    t(j) = tmp
  }
}
