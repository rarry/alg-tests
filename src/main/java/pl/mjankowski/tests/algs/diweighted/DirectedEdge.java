package pl.mjankowski.tests.algs.diweighted;

/**
 * <<<<<<< HEAD
 * Created by mjankowski on 2016-05-11.
 */

public class DirectedEdge implements Comparable<DirectedEdge> {

    private final int v, w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(DirectedEdge o) {
        return Integer.compare(v, w);
    }
}
