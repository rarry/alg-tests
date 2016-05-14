package pl.mjankowski.tests.algs.diweighted;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 13.05.16
 * Time: 10:21
 * To change this template use File | Settings | File Templates.
 */
public class DirectedEdge implements Comparable<DirectedEdge>{

    private final int v, w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    public double weight(){
        return weight;
    }

    @Override
    public int compareTo(DirectedEdge o) {
        return Integer.compare(v, w);
    }
}
