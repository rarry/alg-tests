package pl.mjankowski.tests.algs.ds;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 15.05.16
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
public class RedBlackTree {

    private TreeNode root;

    private int search(Integer key, TreeNode n) {
        int cmp = key.compareTo(n.getKey());
        if (cmp < 0) {
            return search(key, n.getLeft());
        } else if (cmp > 0) {
            return search(key, n.getRight());
        } else {
            return n.getValue();
        }
    }

    public int get(Integer key) {
        return search(key, root);
    }

    public boolean isRed(TreeNode n) {
        if (n == null || !n.isRed()) {
            return false;
        } else {
            return true;
        }
    }


    public TreeNode rotateLeft(TreeNode h) {

        TreeNode x = h.getRight();
        h.setRight(x.getLeft());
        x.setLeft(h);
        x.setRed(h.isRed());
        h.setRed(true);
        return x;
    }

    public TreeNode flipColors(TreeNode h) {

        h.setRed(true);
        h.getRight().setRed(false);
        h.getLeft().setRed(false);
        return h;
    }

    public TreeNode rotateRight(TreeNode h) {

        TreeNode x = h.getLeft();
        h.setLeft(x.getRight());
        x.setRight(h);
        x.setRed(h.isRed());
        h.setRed(true);
        return x;
    }


}
