package pl.mjankowski.tests.algs.pl.mjankowski.tests.algs.backtracking

import scala.collection.mutable.ListBuffer

/**
 * Created by mjankowski on 2016-05-01.
 */
abstract class Backtracking[T] {

  def processSolution(sol: ListBuffer[T]): Unit

  def isSolution(sol: ListBuffer[T], iter: Int): Boolean

  def constructCandidates(iter: Int): List[T]

  def backtrack(sol: ListBuffer[T], k: Int): Unit = {

    if (isSolution(sol, k)) {
      processSolution(sol)
    } else {
      val candidates = constructCandidates(k + 1)
      for (c <- candidates) {
        sol += c
        backtrack(sol, k + 1)
        sol.remove(sol.length - 1)
      }
    }
  }
}