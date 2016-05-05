package pl.mjankowski.tests.algs.graph;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 05.05.16
 * Time: 01:03
 * To change this template use File | Settings | File Templates.
 */
public class GraphList implements IGraph {

    private Set<Integer>[] adj;

    public GraphList(int vCount) {
        adj = new HashSet[vCount];
        for (int i = 0; i < vCount; i++) {
            adj[i] = new HashSet<Integer>();
        }
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    @Override
    public Set<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public int verticesCount() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int edgesCount() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
