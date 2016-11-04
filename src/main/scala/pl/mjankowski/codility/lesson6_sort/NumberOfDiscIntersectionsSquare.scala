package pl.mjankowski.codility.lesson6_sort

/**
  * https://codility.com/demo/results/trainingGZSA86-HWG/
  *
  * @author Maciej Jankowski <mjankowski@pl.imshealth.com> on 27.10.16
  */
class NumberOfDiscIntersectionsSquare {

  case class Interval(from: Int, to: Int) {
    def intersects(that: Interval): Boolean =
      that.from <= this.to && that.to >= this.from
  }

  def solution(a: Array[Int]): Int = {

    val intervals = a.zipWithIndex.map { case (e, i) => Interval(i - e, i + e) }
    val sorted = intervals.sortWith(_.from < _.from)


    var sum = 0
    var i = 0

    while (i < sorted.length) {
      val interval1 = sorted(i)

      var j = i + 1
      while (j < sorted.length) {
        val interval2 = sorted(j)
        if (interval1.intersects(interval2)) {
          sum += 1
        } else {

        }
        j += 1
      }
      i += 1
    }

    sum
  }

}
