package pl.mjankowski.tests.algs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 04.05.16
 * Time: 23:24
 * To change this template use File | Settings | File Templates.
 */
public class TestPermutations {

    @Test
    public void test() {
        Permutations testClass = new Permutations();

        List<Integer> candidates = new ArrayList<Integer>();
        testClass.backtrack(candidates, 1);

    }
}
