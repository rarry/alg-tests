package pl.mjankowski.tests.algs.diweighted;

import java.util.ArrayDeque;
import java.util.Deque;
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
    private Deque<Integer> stack;
    private boolean[] marked;

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

    public Deque<Integer> topologicalSort() {
        stack = new ArrayDeque<Integer>();
        marked = createMarked();

        for (int i = 0; i < this.verticesCount; i++) {
            sortTopologially(i);
        }

        return stack;
    }

    private void sortTopologially(int start) {

        if (!marked[start]) {
            marked[start] = true;

            Set<DirectedEdge> adjacent = adj(start);
            for (DirectedEdge e : adjacent) {
                sortTopologially(e.to());
            }
            stack.push(start);
        }
    }

    private boolean[] createMarked() {
        boolean[] marked = new boolean[this.verticesCount];
        for (int i = 0; i < this.verticesCount; i++) {
            marked[i] = false;
        }
        return marked;
    }

    public double[] calcSPT(){

        double[] distTo = new double[this.verticesCount];
        for (int i = 0; i < this.verticesCount; i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        Deque<Integer> sorted = topologicalSort();

        Integer start = sorted.peek();
        distTo[start] = 0;

        while(!sorted.isEmpty()){

            Integer v = sorted.pop();
            Set<DirectedEdge> adjs = adj(v);
            for(DirectedEdge e: adjs){
                relax(v, e, distTo);
            }
        }

        return distTo;
    }

    private void relax(Integer v, DirectedEdge e,  double[] distTo) {

        double newDist = distTo[v] + e.weight();
        if(newDist < distTo[e.to()]){
            distTo[e.to()] = newDist;
        }
    }

}
