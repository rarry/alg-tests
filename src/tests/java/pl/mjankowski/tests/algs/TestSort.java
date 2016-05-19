package pl.mjankowski.tests.algs;

import org.junit.Test;
import pl.mjankowski.tests.algs.sort.MergeSortJava;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.05.16
 * Time: 00:41
 * To change this template use File | Settings | File Templates.
 */
public class TestSort {

    @Test
    public void test() {

        int[] a = {4, 1, 7, 3, 5, 6, 7, 9, 0, 2, 3, 1, 8, 7, 6, 5};

        MergeSortJava.sort(a);

        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+"\t");
        }
    }

    @Test
    public void testBottomUp() {

        int[] a = {4, 1, 7, 3, 5, 6, 7, 9, 0, 2, 3, 1, 8, 7, 6, 5};

        MergeSortJava.bottomUp(a);

        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+"\t");
        }
    }
}
