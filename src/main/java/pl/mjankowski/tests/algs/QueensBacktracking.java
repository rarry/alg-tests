package pl.mjankowski.tests.algs;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 03.05.16
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public class QueensBacktracking extends Backtracking<Queen> {

    protected boolean isAllowed(List<Queen> solution, int iteration) {
        boolean notAllowed = solution.stream().anyMatch(q -> solution.stream().anyMatch(isCollision(q)));
        return iteration <= 8 && !notAllowed;
    }

    @Override
    protected void printDebugSolution(List<Queen> solution, boolean allowed) {
        if (allowed) {
            System.out.println("\n\nAllowed") ;
        }else{
            System.out.println("\n\nNot allowed") ;
        }
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (solution.contains(new Queen(i, j))) {
                    System.out.print("X\t");
                } else {
                    System.out.print("o\t");
                }
            }
            System.out.println();
        }

    }

    private Predicate<Queen> isCollision(Queen queen) {
        Predicate<Queen> p3 = q -> q.equals(queen);
        return p3.negate().and(isDiagonalCollision(queen).or(isHorizontalCollision(queen)).or(isVerticalCollision(queen)));
    }

    private Predicate<Queen> isDiagonalCollision(Queen queen) {
        Predicate<Queen> p1 = q -> q.getI() - q.getJ() == queen.getI() - queen.getJ();
        Predicate<Queen> p2 = q -> q.getI() + q.getJ() == queen.getI() + queen.getJ();
        return p1.or(p2);
    }


    private Predicate<Queen> isHorizontalCollision(Queen queen) {
        return q -> q.getI() == queen.getI();
    }

    private Predicate<Queen> isVerticalCollision(Queen queen) {
        return q -> q.getJ() == queen.getJ();
    }

    @Override
    protected boolean isSolution(List<Queen> solution) {
        return solution.size() == 8 && isAllowed(solution, 8);
    }

    @Override
    protected void processSolution(List<Queen> solution) {
        System.out.println("\n\n");
//        solution.forEach(q -> System.out.print(q+"\t"));
        printDebugSolution(solution, true);
    }

    @Override
    protected List<Queen> generateCandidates(List<Queen> solution, int iteration) {
        IntStream range = IntStream.rangeClosed(1, 8);
        Stream<Queen> a = range.mapToObj(j -> new Queen(iteration, j));
        List<Queen> list = a.collect(Collectors.toList());
        return list;
    }
}
