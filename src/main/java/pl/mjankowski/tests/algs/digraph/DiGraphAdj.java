package pl.mjankowski.tests.algs.digraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mjankowski on 2016-05-05.
 */
public class DiGraphAdj implements DiGraph {

    private final int n;
    private Set<Integer>[] adj;
    private Deque<Integer> stack;
    private boolean[] marked;

    public DiGraphAdj(int n) {
        this.n = n;

        adj = new Set[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<Integer>();
        }
    }

    @Override
    public int verticesCount() {
        return n;
    }

    @Override
    public int edgesCount(int v) {
        return getAdj(v).size();
    }

    @Override
    public Set<Integer> getAdj(int v) {
        return adj[v];
    }

    @Override
    public Deque<Integer> topologicalSort() {
        stack = new ArrayDeque<Integer>();
        marked = createMarked();

        for (int i = 0; i < this.n; i++) {
            sortTopologially(i);
        }

        return stack;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    @Override
    public DiGraph reversed() {
        DiGraph gr = new DiGraphAdj(this.n);
        for (int i = 0; i < adj.length; i++) {
            for(Integer j: adj[i]){
                gr.addEdge(j, i);
            }
        }
        return gr;
    }

    private void sortTopologially(int start) {

        if (!marked[start]) {
            marked[start] = true;

            Set<Integer> adjacent = getAdj(start);
            for (Integer v : adjacent) {
                sortTopologially(v);
            }
            stack.push(start);
        }
    }

    private boolean[] createMarked() {
        boolean[] marked = new boolean[this.n];
        for (int i = 0; i < this.n; i++) {
            marked[i] = false;
        }
        return marked;
    }


    public int[] strongComponent() {
        int[] scc = new int[this.n];;
        marked = createMarked();
        DiGraph rev = reversed();
        Deque<Integer> s = rev.topologicalSort();

        int component = 0;
        while(!s.isEmpty()){
            Integer nextVertex = s.pop();
            if(!marked[nextVertex]){
                findNextComponent(nextVertex, component, scc);
                component = component + 1;
            }
        }
        return scc;
    }

    private void findNextComponent(int v, int component, int[] scc){

        if(!marked[v]){
            scc[v] = component;
            marked[v] = true;
            for(int w : adj[v]){
                findNextComponent(w, component, scc);
            }
        }
    }

    private void greedyMst(){

    }

}
