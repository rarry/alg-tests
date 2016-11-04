package pl.mjankowski.codility.lesson4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mac on 16.10.16
 */
public class MissingInteger {

    public static int solution(int[] A) {
        Set<Integer> s = new HashSet<Integer>();

        for(int i=0; i<A.length; i++){
            if(A[i] > 0) {
                int ai = A[i];
                s.add(ai);
            }
        }


        for(int i=1; i<=A.length; i++){
            if(!s.contains(i)){
                return i;
            }
        }

        return A.length + 1;
    }

    public static void main(String[] args) {

        System.out.println(Math.pow(2,31)-1);

        check(new int[]{2, 3, 1, 5}, 4);
        check(new int[]{2, 3, 1, 5, 4,7,9,17,8, 10,16,11,15,12,14,13}, 6);
        check(new int[]{4,1,3,2}, 5);
        check(new int[]{4,1,3}, 2);
        check(new int[]{10}, 1);
    }

    private static void check(int[] A, int expected) {

        int ret = solution(A);
        if (ret != expected) {
            throw new RuntimeException("expected " + expected + ", but got " + ret);
        }
    }
}
