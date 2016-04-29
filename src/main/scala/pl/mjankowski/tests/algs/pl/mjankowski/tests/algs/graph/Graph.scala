package pl.mjankowski.tests.algs.pl.mjankowski.tests.algs.graph

import scala.collection.mutable

/**
 * Created by mjankowski on 2016-04-29.
 */
class Graph(val size: Int) {

  type Vertex = Int
  val graph = mutable.Map[Vertex, mutable.ListBuffer[Vertex]]()
  val marked = mutable.Map[Vertex, Boolean]()
  val pathTo = new Array[Vertex](size)

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

  def addEdge(from: Vertex, to: Vertex) = graph.get(from) match{
    case None => graph.put(from, mutable.ListBuffer(to))
    case Some(l) => l += to
  }

  def clearLastTraversal
}
