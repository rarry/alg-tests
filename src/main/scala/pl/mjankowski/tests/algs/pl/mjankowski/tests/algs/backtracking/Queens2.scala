package pl.mjankowski.tests.algs.pl.mjankowski.tests.algs.backtracking

import scala.collection.mutable.ListBuffer

/**
 * Created by mjankowski on 2016-05-01.
 */
object Queens2 {

}

class Queens2 extends Backtracking[(Int,Int)] {

  override def processSolution(sol: ListBuffer[(Int, Int)]): Unit = println(sol)

  override def constructCandidates(iter: Int): List[(Int, Int)] =
    (1 to 8) map (j => (iter,j)) toList

  override def isSolution(sol: ListBuffer[(Int, Int)], iter: Int): Boolean = ???
}
