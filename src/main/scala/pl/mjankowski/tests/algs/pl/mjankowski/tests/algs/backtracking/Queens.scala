package pl.mjankowski.tests.algs.pl.mjankowski.tests.algs.backtracking

import scala.collection.mutable.ListBuffer

/**
 * Created by mjankowski on 2016-04-30.
 */

object Queens {

  def main(args: Array[String]) {

    val queens = new Queens
    //    queens.addToChessBoard((0, 0))
    //    queens.addToChessBoard((1, 2))

    //    println(queens hasCollisions)

    queens findSolution
  }

}

class Queens {

  type Queen = (Int, Int)

  val chessBoard = ListBuffer[Queen]()

  def isVerticalCollision(queen: Queen): Boolean = chessBoard exists (q => q._2 == queen._2 && q._1 != queen._1)

  def isHorizontalCollision(queen: Queen): Boolean = chessBoard exists (q => q._1 == queen._1 && q._2 != queen._2)

  def isDiagonalCollision(queen: Queen): Boolean = {
    val diff = Math.abs(queen._1 - queen._2)
    chessBoard exists (q => ((Math.abs(q._1 - q._2) == diff)
      || (8 - Math.abs(q._1 - q._2) == diff)) && q != queen)
  }

  def hasCollisions: Boolean = {
    val verticalCollision = chessBoard exists isVerticalCollision
    val horizontalCollision = chessBoard exists isHorizontalCollision
    val diagonalCollision = chessBoard exists isDiagonalCollision
    verticalCollision || horizontalCollision || diagonalCollision
  }

  def isAllowed = !hasCollisions

  def isSolution = isAllowed && chessBoard.size == 8

  def addToChessBoard(queen: Queen) = chessBoard += queen

  def findSolution = {

    def backtrackDfs(row: Int): Unit = {
      if (isSolution) println(chessBoard)
      else {
        if (row <= 8 && isAllowed) {
          val candidates = (1 to 8) map (j => (row, j))
          for (c <- candidates) {
            addToChessBoard(c)
            backtrackDfs(row + 1)
            chessBoard.remove(chessBoard.length - 1)
          }
        }
      }
    }

    backtrackDfs(1)
  }


}
