package pl.mjankowski.tests.algs.pl.mjankowski.tests.algs.graph

import scala.collection.mutable

/**
 * Created by mjankowski on 2016-04-29.
 */
class Graph(val size: Int) {

  type Vertex = Int
  val graph = mutable.Map[Vertex, mutable.ListBuffer[Vertex]]()
  val marked = mutable.Map[Vertex, Boolean]()
  val distanceTo = mutable.Map[Vertex, Int]()
  val pathTo = new Array[Vertex](size)
  val bfsQueue = mutable.Queue[Vertex]()

  for (i <- (0 until size)) {
    marked.put(i, false)
  }

  for (i <- (0 until size)) {
    pathTo(i) = -1
  }

  def dfs(g: Graph, w: Vertex)(execute: Vertex => Unit): Unit = {

    marked(w) = true
    execute(w)
    for (v <- graph(w)) {
      if (!marked(v)) {
        dfs(g, v)(execute)
        pathTo(v) = w
      }
    }
  }

  def bfs(g: Graph, w: Vertex)(execute: Vertex => Unit): Unit = {

    bfsQueue.enqueue(w)
    distanceTo(w) = 0
    marked(w) = true
    execute(w)
    while (!bfsQueue.isEmpty) {
      val v = bfsQueue.dequeue()

      val neighbours = graph(v)
      //      println(v)
      for (u <- neighbours) {
        if (!marked(u)) {
          pathTo(u) = v
          bfsQueue.enqueue(u)
          marked(u) = true
          distanceTo(u) = distanceTo(v) + 1
          execute(u)
        }
      }
    }
  }

  def addEdge(from: Vertex, to: Vertex) = graph.get(from) match {
    case None => graph.put(from, mutable.ListBuffer(to))
    case Some(l) => l += to
  }

  def getDistances = distanceTo.toSeq.sortBy(_._2)

  def getPaths: mutable.Map[Vertex, List[Vertex]] = {

    val paths = mutable.Map[Vertex, List[Vertex]]()
    for (v <- (0 until size)) {

      var path = List[Vertex](v)
      var prev = pathTo(v)
      while (prev >= 0) {
        path = prev :: path
        prev = pathTo(prev)
      }
      paths.put(v, path)
    }
    paths
  }

}
