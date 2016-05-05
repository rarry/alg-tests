package pl.mjankowski.tests.algs.digraph;

import java.util.Deque;
import java.util.Set;

/**
 * Created by mjankowski on 2016-05-05.
 */
public interface DiGraph {

    int verticesCount();

    int edgesCount(int v);

    Set<Integer> getAdj(int v);

    Deque<Integer> topologicalSort();

    void addEdge(int v, int w);

    DiGraph reversed();
}
