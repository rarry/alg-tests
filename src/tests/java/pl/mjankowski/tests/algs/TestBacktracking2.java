package pl.mjankowski.tests.algs;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 17.05.16
 * Time: 08:42
 * To change this template use File | Settings | File Templates.
 */
public class TestBacktracking2 {

    @Test
    public void test(){


        char[] abc = "abcdefgh".toCharArray();
        Permutations2 p = new Permutations2(abc);

        p.backtrack(new ArrayList<Integer>(), 0);
    }
}
