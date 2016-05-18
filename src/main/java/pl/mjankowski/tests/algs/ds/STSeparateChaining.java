package pl.mjankowski.tests.algs.ds;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 14.05.16
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */
public class STSeparateChaining {

    private int M = 97;
    private Node[] table;

    public STSeparateChaining() {
        this.table = new Node[M];
    }

    int hashCode(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Integer get(Key key) {

        int hash = hashCode(key);
        Node head = table[hash];

        for (Node n = head; n != null; n = n.getNext()) {
            if (n.getKey().equals(key)) {
                return n.getValue();
            }
        }
        return null;
    }

    public void add(Key key, int value) {
        int hash = hashCode(key);
        Node head = table[hash];

        for (Node n = head; n != null; n = n.getNext()) {
            if (n.getKey().equals(key)) {
                n.setValue(value);
                return;
            }
        }

        Node newNode = new Node(key, value);
        newNode.setNext(head);
        table[hash] = newNode;
    }

}
