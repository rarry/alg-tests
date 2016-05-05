package pl.mjankowski.tests.algs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 04.05.16
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
public class Permutations extends Backtracking<Integer> {

    public Permutations() {
    }

    @Override
    protected boolean isSolution(List<Integer> solution) {
        return solution.size() == 8;
    }

    @Override
    protected void processSolution(List<Integer> solution) {
        System.out.println();
        printDebugSolution(solution, true);
    }

    @Override
    protected List<Integer> generateCandidates(List<Integer> solution, int iteration) {

        boolean[] inPerm = new boolean[]{false, false, false, false, false, false, false, false};
        solution.forEach(i->inPerm[i] = true);

        List<Integer> c = new ArrayList<Integer>();
        for(int i = 0; i<8; i++){
            if(!inPerm[i]){
                c.add(i);
            }
        }

        return c;
    }

    @Override
    protected boolean isAllowed(List<Integer> solution, int iteration) {
        return iteration <= 8;
    }

    @Override
    protected void printDebugSolution(List<Integer> solution, boolean allowed) {
        solution.forEach(q -> System.out.print(q + "\t"));
    }
}
