package pl.mjankowski.tests.algs.diweighted;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 13.05.16
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */
public class EdgeWeightedDigraph {

    private final int verticesCount;
    private final Set<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int verticesCount) {
        this.verticesCount = verticesCount;
        this.adj = new HashSet[verticesCount];
        for (int i=0; i< verticesCount;i++){
            this.adj[i] = new HashSet<DirectedEdge>();
        }
    }

    public void addEdge(DirectedEdge edge){
        this.adj[edge.from()].add(edge);
    }


    public Set<DirectedEdge> adj(int v){
        return adj[v];
    }

    public int getVerticesCount() {
        return verticesCount;
    }
}
