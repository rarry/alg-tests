package pl.mjankowski.tests.algs

/**
 * Created by mjankowski on 2016-04-28.
 */
object HeapSort {

  val HeapSize = 100

  def main(args: Array[String]) {
    val heap = new Heap(Array(8,4,6,2,1,7,7,4,3))

    println(heap)

    val sorted = heap.sorted
    println(sorted.mkString(","))
  }

}

class Heap(val a: Array[Int]) {

  import HeapSort._

  var size = 0
  val backingArray = new Array[Int](HeapSize)
 makeHeap(a)

  def insert(e: Int): Unit = {

    if (size >= HeapSize) {
      throw new RuntimeException("Heap is full")
    }

    backingArray(size) = e
    bubbleUp(size)
    size = size + 1
  }

  def min: Option[Int] =
    if (size > 0) {
      val min = backingArray(0)
      size = size - 1
      backingArray(0) = backingArray(size)
      bubbleDown(0)
      Some(min)
    } else {
      None
    }

  def sorted: List[Int] = min match {
    case None => Nil
    case Some(e) => e :: sorted
  }

  private def makeHeap(a: Array[Int]){
    size = a.length
    Array.copy(a, 0, backingArray, 0, size)
    for(i <- (0 until size).reverse) bubbleDown(i)
  }

  private def bubbleDown(index: Int): Unit = {

    var minIndex = index
    leftChild(index) map { leftChildIndex =>
      if (backingArray(leftChildIndex) < backingArray(minIndex)) {
        minIndex = leftChildIndex
      }
    }

    rightChild(index) map { rightChildIndex =>
      if (backingArray(rightChildIndex) < backingArray(minIndex)) {
        minIndex = rightChildIndex
      }
    }

    if (minIndex != index) {
      swap(minIndex, index)
      bubbleDown(minIndex)
    }
  }

//  def isKthElemGreaterOrEqualTo(x: Int, k: Int): Boolean = {
//
//    1,2,6,3,4,7,7,4,8
//  }

  private def parent(i: Int): Option[Int] = if (i < 1) None else Some(i / 2)

  private def child(index: Int)(calcIndex: Int => Int): Option[Int] = {
    val childIndex = calcIndex(index)
    if (childIndex >= size) None else Some(childIndex)
  }

  private def leftChild(index: Int) = child(index)(i => i * 2 + 1)

  private def rightChild(index: Int) = child(index)(i => i * 2 + 2)

  private def bubbleUp(index: Int): Unit = parent(index) map { parentIndex =>
    if (backingArray(parentIndex) > backingArray(index)) {
      swap(parentIndex, index)
      bubbleUp(parentIndex)
    }
  }


  private def swap(i: Int, j: Int): Unit = {
    val tmp = backingArray(i)
    backingArray(i) = backingArray(j)
    backingArray(j) = tmp
  }

  override def toString(): String = {
    backingArray.take(size).mkString(",")
  }

}
