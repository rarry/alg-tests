package pl.mjankowski.tests.algs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 04.05.16
 * Time: 00:09
 * To change this template use File | Settings | File Templates.
 */
public class TestQueenBacktracking {

    @Test
    public void test() {
        QueensBacktracking testClass = new QueensBacktracking();

        List<Queen> queens = new ArrayList<Queen>();
        testClass.backtrack(queens, 1);

    }
}
