package pl.mjankowski.tests.algs.weighted;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 17.05.16
 * Time: 08:24
 * To change this template use File | Settings | File Templates.
 */
public abstract class Backtracking2 {


    public void backtrack(List<Integer> solution, int iter) {

        if (isSolution(solution)) {
            processSolution(solution);
        } else {

            List<Integer> candidates = generateCandidates(solution);
            for (Integer i : candidates) {
                solution.add(i);
                backtrack(solution, iter + 1);
                solution.remove(solution.size() - 1);
            }

        }
    }

    protected abstract void processSolution(List<Integer> solution);

    protected abstract List<Integer> generateCandidates(List<Integer> solution);

    protected abstract boolean isSolution(List<Integer> solution);

}
