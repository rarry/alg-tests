package pl.mjankowski.tests.algs.ds;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 14.05.16
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */
public class Node {

    private Key key;
    private int value;
    private Node next;

    public Node(Key key, int value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
