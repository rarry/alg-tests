package pl.mjankowski.codility.lesson4;

import java.util.*;

/**
 * @author mac on 18.10.16
 */
public class MaxCounters {

    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private int base = 0;
    private int max = 0;

    private void increaseMax(int x) {
        if (x > max) {
            max = x;
        }
    }

    private int getCounter(int X) {

        Integer v = map.get(X);
        if (v != null) {
            return v;
        } else {
            return base;
        }
    }

    private int[] getState(int N) {
        int[] counters = new int[N];
        for (int i = 1; i < N + 1; i++) {
            counters[i - 1] = getCounter(i);
        }
        return counters;
    }

    public int[] solution(int N, int[] A) {

        for (int K = 0; K < A.length; K++) {
            if (A[K] == N + 1) {
                map = new HashMap<Integer, Integer>();
                base = max;
            } else {
                Integer counter = getCounter(A[K]);
                increaseMax(counter + 1);
                map.put(A[K], counter + 1);
            }
        }

        int[] counters = getState(N);

        return counters;
    }


    public static void main(String[] args) {

        check(new int[]{3, 4, 4, 6, 1, 4, 4}, 5, new int[]{3, 2, 2, 4, 2});
        check(new int[]{3}, 5, new int[]{0, 0, 1, 0, 0});
    }

    private static void check(int[] A, int N, int[] expected) {

        MaxCounters mc = new MaxCounters();

        int[] ret = mc.solution(N, A);
        if (!Arrays.equals(ret, expected)) {
            throw new RuntimeException("expected " + Arrays.toString(expected) + ", but got " + Arrays.toString(ret));
        }
    }
}
