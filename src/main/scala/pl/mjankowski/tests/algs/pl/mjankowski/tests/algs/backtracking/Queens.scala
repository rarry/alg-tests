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

//    println(queens.getIter)

//    queens.printDifferences
  }

}

class Queens {

  type Queen = (Int, Int)

  var iter = 0

  val chessBoard = ListBuffer[Queen]()

  def isVerticalCollision(queen: Queen): Boolean = chessBoard exists (q => q._2 == queen._2 && q._1 != queen._1)

  def isHorizontalCollision(queen: Queen): Boolean = chessBoard exists (q => q._1 == queen._1 && q._2 != queen._2)

  def isDiagonalCollision(queen: Queen): Boolean = {
    val diff = queen._1 - queen._2
    val sum = queen._1 + queen._2
    chessBoard exists (q => ((q._1 - q._2 == diff)
      || ((q._1 + q._2) == sum)) && q != queen)
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

      iter = iter + 1
      if (isSolution) println(chessBoard)
      else {
        if (row <= 8 && isAllowed) {
//          printChessBoad(chessBoard, "Allowed")
          val candidates = (1 to 8) map (j => (row, j))
          for (c <- candidates) {
            addToChessBoard(c)
            backtrackDfs(row + 1)
            chessBoard.remove(chessBoard.length - 1)
          }
        }else {
//          printChessBoad(chessBoard, "Not allowed")
        }
      }
    }

    backtrackDfs(1)
  }

  def getIter = iter

  def printChessBoad(cb: ListBuffer[Queen], m: String) = {

    println("\n\n\n"+m)
    for(i <- (1 to 8)){
      for(j <- (1 to 8)){
        if(cb contains((i,j))) print("x ")
        else print("o ")
      }
      println
    }
  }

  def printDifferences = {
    for(i <- (1 to 8)){
      for(j <- (1 to 8)){
        print(s"($i,$j)\t")
      }
      println("\n")
    }
  }

}
