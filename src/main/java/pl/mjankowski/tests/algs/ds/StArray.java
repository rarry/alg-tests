package pl.mjankowski.tests.algs.ds;

import java.lang.reflect.Array;
/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 14.05.16
 * Time: 09:40
 * To change this template use File | Settings | File Templates.
 */
public class StArray<T> implements ST<T> {

    private Key[] keys;
    private T[] values;

    public StArray(Class<T> c, int capacity) {
        keys = new Key[capacity];
        values = (T[])Array.newInstance(c, capacity);
    }

    @Override
    public void put(Key key, T value) {

    }

    @Override
    public T get(Key key) {

        if(isEmpty()){
            return null;
        }

        int r = rank(key);
        if(r < keys.length && keys[r].compareTo(key) == 0){
            return values[r];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private int rank(Key key) {
        int lo = 0;
        int hi = keys.length;
        int mid = lo + (hi - lo) / 2;

        while (hi > lo) {
            int c = key.compareTo(keys[mid]);
            if (c < 0) {
                hi = mid;
            } else if (c > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
            mid = lo + (hi - lo) / 2;
        }
        return lo;
    }
}
