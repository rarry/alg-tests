package pl.mjankowski.tests.algs;

/**
 * Created by mjankowski on 2016-05-10.
 */
public class Heap {

    private int size;
    private int[] heap;

    public Heap(int size) {
        this.size = size;
        this.heap = new int[this.size];
    }

    public int parent(int k) {
        return k / 2;
    }

    public int left(int k) {
        return k * 2;
    }

    public int right(int k) {
        return k * 2 + 1;
    }

    public void swimUp(int k) {

        while (k > 1 && heap[k] > heap[k / 2]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private int indexOfLargest(int k) {

        int maxIndex;
        if (2 * k > this.size) {
            return k;
        }

        if (2 * k + 1 > this.size) {
            maxIndex = k * 2;
        } else {
            int left = heap[k * 2];
            int right = heap[k * 2 + 1];

            if (left > right) {
                maxIndex = k * 2;
            } else {
                maxIndex = k * 2 + 1;
            }
        }

        int parent = heap[k];
        if (parent > heap[maxIndex]) {
            maxIndex = parent;
        }
        return maxIndex;
    }

    public void sinkDown(int k) {

        int idxLargest = indexOfLargest(k);
        while (idxLargest != k) {
            swap(k, idxLargest);
            idxLargest = indexOfLargest(idxLargest);
        }
    }

    public void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public void insert(int elem){
        this.size += 1;
        heap[size-1] = elem;
        swimUp(size -1);
    }
}
