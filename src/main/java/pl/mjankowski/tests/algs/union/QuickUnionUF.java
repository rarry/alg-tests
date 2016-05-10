package pl.mjankowski.tests.algs.union;

/**
 * Created by mjankowski on 2016-05-10.
 */
public class QuickUnionUF {

    private int[] id;
    private int[] sz;

    public QuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 0;
        }
    }

    public int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int i, int j) {
        return root(i) == root(j);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if(i == j) return;

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] = sz[j] + sz[i];
        } else {
            id[j] = i;
            sz[i] = sz[i] + sz[j];
        }
    }

}
