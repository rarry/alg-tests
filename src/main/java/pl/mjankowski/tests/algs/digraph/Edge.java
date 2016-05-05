package pl.mjankowski.tests.algs.digraph;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 06.05.16
 * Time: 00:04
 * To change this template use File | Settings | File Templates.
 */
public class Edge implements Comparable<Edge> {

    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int v) {
        if (this.v == v) {
            return w;
        } else {
            return v;
        }
    }


    @Override
    public int compareTo(Edge o) {
        return Integer.compare(v, w);
    }
}
