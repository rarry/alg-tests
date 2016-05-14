package pl.mjankowski.tests.algs;

import org.junit.Test;
import pl.mjankowski.tests.algs.diweighted.Dijkstra;
import pl.mjankowski.tests.algs.diweighted.DirectedEdge;
import pl.mjankowski.tests.algs.diweighted.EdgeWeightedDigraph;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 13.05.16
 * Time: 11:11
 * To change this template use File | Settings | File Templates.
 */
public class TestDijkstra {

    @Test
    public void test() {

        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(8);
        graph.addEdge(new DirectedEdge(0, 1, 5.0));
        graph.addEdge(new DirectedEdge(0, 4, 9.0));
        graph.addEdge(new DirectedEdge(0, 7, 8.0));
        graph.addEdge(new DirectedEdge(1, 2, 12.0));
        graph.addEdge(new DirectedEdge(1, 3, 15.0));
        graph.addEdge(new DirectedEdge(1, 7, 4.0));
        graph.addEdge(new DirectedEdge(2, 3, 3.0));
        graph.addEdge(new DirectedEdge(2, 6, 11.0));
        graph.addEdge(new DirectedEdge(3, 6, 9.0));
        graph.addEdge(new DirectedEdge(4, 5, 4.0));
        graph.addEdge(new DirectedEdge(4, 6, 20.0));
        graph.addEdge(new DirectedEdge(4, 7, 5.0));
        graph.addEdge(new DirectedEdge(5, 2, 1.0));
        graph.addEdge(new DirectedEdge(5, 6, 13.0));
        graph.addEdge(new DirectedEdge(7, 2, 7.0));
        graph.addEdge(new DirectedEdge(7, 5, 6.0));

        Dijkstra d = new Dijkstra(graph, 0);

        System.out.println(Arrays.toString(d.getDistTo()));
        System.out.println(Arrays.toString(d.getEdgeTo()));

    }
}
