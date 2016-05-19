package pl.mjankowski.tests.algs;

import pl.mjankowski.tests.algs.weighted.Backtracking2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 17.05.16
 * Time: 08:29
 * To change this template use File | Settings | File Templates.
 */
public class Permutations2 extends Backtracking2 {

    private final char[] strs;

    public Permutations2(char[] strs) {
        this.strs = strs;
    }

    @Override
    protected void processSolution(List<Integer> solution) {

        for(int i=0; i<8;i++){
           System.out.print(strs[solution.get(i)]);
        }
        System.out.println();
    }

    @Override
    protected List<Integer> generateCandidates(List<Integer> solution) {

        boolean[] a = new boolean[8];
        for (int i = 0; i < 8; i++) {
            a[i] = false;
        }

        for (int i : solution) {
            a[i] = true;
        }

        List<Integer> candidates = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            if (!a[i]) {
                candidates.add(i);
            }
        }

        return candidates;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected boolean isSolution(List<Integer> solution) {
        return solution.size() == 8;
    }
}
