package pl.mjankowski.codility.lesson2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mac on 14.10.16
 */
public class OddOccurrencesInArray {

    public static int solution(int[] A) {

        Set<Integer> odd = new HashSet<Integer>();

        for (int i = 0; i < A.length; i++) {
            if(odd.contains(A[i])){
                odd.remove(A[i]);
            }else{
                odd.add(A[i]);
            }
        }

        return odd.toArray(new Integer[0])[0];
    }

    public static void main(String[] args){
        check(new int[]{9, 3, 9, 3, 9, 7, 9}, 7);
    }

    private static void check(int[] A, int expected){

        int oddNumber = solution(A);
        if(oddNumber != expected){
            throw new RuntimeException("expected "+expected+", but got "+oddNumber);
        }
    }
}
