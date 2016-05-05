package pl.mjankowski.tests.algs.graph;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 05.05.16
 * Time: 00:31
 * To change this template use File | Settings | File Templates.
 */
public interface IGraph {

    void addEdge(int v, int w);

    Set<Integer> adj(int v);

    int verticesCount();

    int edgesCount();

    default int degree(int v) {
        return adj(v).size();
    }

    default int maxDegree(int v) {
        int max = 0;
        for(int i=0; i<verticesCount(); i++){
            int d = degree(i);
            if(d > max){
                max = d;
            }
        }
        return max;
    }


}
