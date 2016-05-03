package pl.mjankowski.tests.algs;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 03.05.16
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public class Queen {

    private int i;
    private int j;

    public Queen(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Queen queen = (Queen) o;

        if (i != queen.i) return false;
        if (j != queen.j) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        return result;
    }
}
