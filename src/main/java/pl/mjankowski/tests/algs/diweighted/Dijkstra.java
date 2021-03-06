package pl.mjankowski.tests.algs.diweighted;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 13.05.16
 * Time: 10:27
 * To change this template use File | Settings | File Templates.
 */
public class Dijkstra {

    private double[] distTo;
    private int[] edgeTo;
    private boolean[] visited;

    public Dijkstra(EdgeWeightedDigraph graph, int start) {
        int verticesCount = graph.getVerticesCount();
        distTo = new double[verticesCount];
        edgeTo = new int[verticesCount];
        visited = new boolean[verticesCount];

        for (int i = 0; i < verticesCount; i++) {
            distTo[i] = Double.MAX_VALUE;
            edgeTo[i] = -1;
            visited[i] = false;
        }

        distTo[start] = 0.0;
        int s = start;
        while (s >= 0) {
            for (DirectedEdge e : graph.adj(s)) {
                relax(e);
            }
            s = findNext();
        }
    }

    private void relax(DirectedEdge e) {

        double newDist = distTo[e.from()] + e.weight();
        if (newDist < distTo[e.to()]) {
            distTo[e.to()] = newDist;
            edgeTo[e.to()] = e.from();
        }
    }

    private int findNext() {
        int minIndex = -1;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < distTo.length; i++) {
            if (distTo[i] < min && !visited[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }





    public double[] getDistTo() {
        return distTo;
    }

    public int[] getEdgeTo() {
        return edgeTo;
    }
}
