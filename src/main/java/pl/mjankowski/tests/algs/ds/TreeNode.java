package pl.mjankowski.tests.algs.ds;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 15.05.16
 * Time: 19:32
 * To change this template use File | Settings | File Templates.
 */
public class TreeNode {

    private Integer key;
    private int value;
    private TreeNode left;
    private TreeNode right;
    private boolean red;

    public TreeNode(Integer key, int value, TreeNode left, TreeNode right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }
}
