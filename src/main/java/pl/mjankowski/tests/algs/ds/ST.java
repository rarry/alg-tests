package pl.mjankowski.tests.algs.ds;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 14.05.16
 * Time: 09:18
 * To change this template use File | Settings | File Templates.
 */
public interface ST<T> {

    public void put(Key key, T value);

    public T get(Key key);

    public boolean isEmpty();
}
