package pl.mjankowski.tests.algs.pl.mjankowski.tests.algs.graph

/**
 * Created by mjankowski on 2016-04-29.
 */
object GraphClient {


  def main(args: Array[String]) {
    val g = new Graph(10)

    g.addEdge(0, 1)

    g.addEdge(1, 2)
    g.addEdge(1, 5)

    g.addEdge(2, 1)
    g.addEdge(2, 3)
    g.addEdge(2, 4)
    g.addEdge(2, 5)

    g.addEdge(3, 2)
    g.addEdge(3, 4)

    g.addEdge(4, 2)
    g.addEdge(4, 3)
    g.addEdge(4, 5)
    g.addEdge(5, 1)
    g.addEdge(5, 2)
    g.addEdge(5, 4)

    g.bfs(g, 0)(x => print(x + " "))

    println
    g.getDistances foreach (x => print(x + " "))

    g.getPaths foreach { case (k, v) => println(k + "->" + v) }
  }

}
