package pl.mjankowski.tests.algs.zad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 18.05.16
 * Time: 18:17
 * To change this template use File | Settings | File Templates.
 */
public class Palindrom {

    public final static int INSERT = 0;
    public final static int REMOVE = 1;
    public final static int EXCH = 2;
    public final static int NO_OP = 3;

    private int min = Integer.MAX_VALUE;
    private int idx;

    public Palindrom(String str) {
        List<Character> chars = new ArrayList<Character>();
        for (char c : str.toCharArray()) {
            chars.add(c);
        }
        createPalindrom(chars, 0, 0);
    }

    private void createPalindrom(List<Character> chars, int iter, int opCount) {

        if (iter > chars.size() / 2) {
            return;
        }

        if (isPalindrom(chars)) {
            if (opCount < min) {
                min = opCount;
            }
        } else {

            int[] candidates = generateCandidates();
            for (int c : candidates) {
                Character lastChar = applyOperation(chars, c, iter);
                createPalindrom(chars, iter + 1, c == NO_OP ? opCount : opCount + 1);
                undoOperation(chars, c, iter, lastChar);
            }
        }

    }

    public void undoOperation(List<Character> chars, int oper, int iter, Character lastChar) {
        idx = chars.size() - 1 - iter;
        switch (oper) {
            case INSERT:
                chars.remove(idx - 1);
                break;
            case REMOVE:
                chars.add(idx + 1, lastChar);
                break;
            case EXCH:
                chars.set(idx, lastChar);
                break;
            case NO_OP:
                break;
            default:
                throw new RuntimeException("Wrong oper");
        }
    }

    public Character applyOperation(List<Character> chars, int oper, int iter) {
        idx = chars.size() - 1 - iter;
        switch (oper) {
            case INSERT:
                chars.add(idx, chars.get(iter));
                return null;
            case REMOVE:
                return chars.remove(idx);
            case EXCH:
                Character tmp = chars.get(idx);
                chars.set(idx, chars.get(iter));
                return tmp;
            case NO_OP:
                return null;
            default:
                throw new RuntimeException("Wrong oper");
        }
    }

    private int[] generateCandidates() {
        return new int[]{0, 1, 2, 3};
    }

    public static boolean isPalindrom(List<Character> chars) {

        int n = chars.size();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (!chars.get(i).equals(chars.get(j))) {
                return false;
            }
        }

        return true;
    }

    public int getMin() {
        return min;
    }

    private static class Candidate {

    }
}
