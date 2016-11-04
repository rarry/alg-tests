package pl.mjankowski.codility.lesson4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mac on 17.10.16
 */
public class FrogRiverOne {

    public static int solution(int X, int[] A) {

        int last = ((1 + X)*X)/2;

        int sum = 0;
        Set<Integer> s = new HashSet<Integer>();

        for(int i=0; i<A.length;i++){
            if(s.add(A[i])){
                sum += A[i];
                if(last == sum){
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        check(new int[]{1,3,1,4,2,3,5,4}, 5, 6);
        check(new int[]{1}, 1, 0);
    }

    private static void check(int[] A, int X, int expected) {

        int ret = solution(X, A);
        if (ret != expected) {
            throw new RuntimeException("expected " + expected + ", but got " + ret);
        }
    }
}
