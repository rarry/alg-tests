package pl.mjankowski.tests.algs.ds;

import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 14.05.16
 * Time: 08:50
 * To change this template use File | Settings | File Templates.
 */
public class Queue<E> {

    private E[] array;
    private int tail = 0;
    private int head = 0;
    private Class<E> c;

    public Queue(Class<E> c, int capacity) {
        this.c = c;
        array = (E[]) Array.newInstance(c, capacity);
    }

    private void resize() {
        E[] old = array;
        array = (E[]) Array.newInstance(this.c, array.length * 2);
        for (int i = 0; i < tail; i++) {
            array[i] = old[(head + i) % old.length];
        }
        head = 0;
        tail = old.length;
    }

    public void enqueue(E e) {

        if (tail % array.length >= head) {
            resize();
        }

        array[tail++] = e;
    }

    public E dequeue(E e) {
        tail--;
        if (tail < 0) {
            tail = array.length + tail;
        }
       return array[tail];
    }
}
