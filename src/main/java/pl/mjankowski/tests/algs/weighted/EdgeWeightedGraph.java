package pl.mjankowski.tests.algs.weighted;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 06.05.16
 * Time: 00:08
 * To change this template use File | Settings | File Templates.
 */
public class EdgeWeightedGraph {

    private final int n;
    private Set<Edge>[] adj;
    private boolean[] marked;

    public EdgeWeightedGraph(int n) {
        this.n = n;

        adj = new Set[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<Edge>();
        }
    }

    int verticesCount() {
        return n;
    }

    int edgesCount(int v) {
        return getAllEdges().size();
    }

    Set<Edge> getAdj(int v) {
        return adj[v];
    }

    Set<Edge> getAllEdges() {
        Set<Edge> edges = new HashSet<Edge>();
        for (int i = 0; i < this.n; i++) {
            edges.addAll(adj[i]);
        }
        return edges;
    }

    void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);

        adj[v].add(edge);
        adj[w].add(edge);
    }

}
