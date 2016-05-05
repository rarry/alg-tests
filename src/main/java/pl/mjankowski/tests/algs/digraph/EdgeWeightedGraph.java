package pl.mjankowski.tests.algs.digraph;

import java.util.Deque;
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

    int verticesCount(){
        return n;
    }

    int edgesCount(int v){


    }

    Set<Edge> getAdj(int v);

    Set<Edge> getAllEdged();

    void addEdge(Edge edge){

        int v = edge.either();
        int w = edge.other(v);

        adj[v].add(edge) ;
        adj[v].add(edge) ;


    }

}
