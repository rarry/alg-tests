package pl.mjankowski.tests.algs.weighted;


import pl.mjankowski.tests.algs.union.QuickUnionUF;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by mjankowski on 2016-05-10.
 */
public class MST {

    private Set<Edge> edgesInMst;

    public MST(EdgeWeightedGraph graph) {
        this.edgesInMst = computeMstKruskal(graph);
    }

    private Set<Edge> computeMstKruskal(EdgeWeightedGraph graph) {

        QuickUnionUF uf = new QuickUnionUF(graph.verticesCount());

        Set<Edge> mst = new HashSet<Edge>();
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for (Edge edge : graph.getAllEdges()) {
            pq.add(edge);
        }

        while (!pq.isEmpty() && mst.size() < graph.verticesCount() - 1) {
            Edge smallestEdge = pq.poll();
            int v = smallestEdge.either();
            int w = smallestEdge.other(v);
            if (!uf.connected(v, w)) {
                mst.add(smallestEdge);
                uf.union(v, w);
            }
        }

        return mst;
    }

    public Set<Edge> edges() {
        return edgesInMst;
    }

    public double weight() {
        return edgesInMst.stream().mapToDouble(e -> e.getWeight()).sum();
    }


}
