package pl.mjankowski.tests.algs.sort;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.05.16
 * Time: 00:13
 * To change this template use File | Settings | File Templates.
 */
public class MergeSortJava {

    private static void merge(int[] a, int[] aux, int from, int middle, int to) {
        for (int i = from; i < to; i++) {
            aux[i] = a[i];
        }
        int firstIndex = from;
        int secondIndex = middle;

        for (int i = from; i < to; i++) {

            if (firstIndex >= middle) {
                a[i] = aux[secondIndex++];
            } else if (secondIndex >= to) {
                a[i] = aux[firstIndex++];
            } else if (aux[firstIndex] < aux[secondIndex]) {
                a[i] = aux[firstIndex++];
            } else {
                a[i] = aux[secondIndex++];
            }
        }
    }

    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sortInternal(a, aux, 0, a.length);
    }

    private static void sortInternal(int[] a, int[] aux, int from, int to) {
        if (a.length > 0 && (to - from) > 1) {
            int middle = (from + to) / 2;
            sortInternal(a, aux, from, middle);
            sortInternal(a, aux, middle, to);
            merge(a, aux, from, middle, to);
        }
    }

    public static void bottomUp(int[] a) {

        int[] aux = new int[a.length];
        int step = 2;
        while (step <= a.length) {

            for (int i = 0; i < a.length; i += step) {
                merge(a, aux, i, i + step/2, Math.min(i + step, a.length));
            }

            step *= 2;
        }
    }
}
