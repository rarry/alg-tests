package pl.mjankowski.tests.algs;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 03.05.16
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
public abstract class Backtracking<T> {

    public void backtrack(List<T> solution, int iteration) {

        if (isSolution(solution)) {
            processSolution(solution);
        } else {

            if (isAllowed(solution, iteration)) {
//                printDebugSolution(solution, true);
                List<T> candidates = generateCandidates(solution, iteration);
                for (T c : candidates) {
                    solution.add(c);
                    backtrack(solution, iteration + 1);
                    solution.remove(solution.size() - 1);
                }
            }else{
//                printDebugSolution(solution, false);
            }
        }
    }

    protected abstract boolean isSolution(List<T> solution);

    protected abstract void processSolution(List<T> solution);

    protected abstract List<T> generateCandidates(List<T> current, int iteration);

    protected abstract boolean isAllowed(List<T> solution, int iteration);

    protected abstract void printDebugSolution(List<T> solution, boolean allowed);

}
