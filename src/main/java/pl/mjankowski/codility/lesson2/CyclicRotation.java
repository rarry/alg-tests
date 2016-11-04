package pl.mjankowski.codility.lesson2;

import java.util.Arrays;

/**
 * @author mac on 14.10.16
 */
public class CyclicRotation {

    public static int[] solution(int[] A, int K) {
        int N = A.length;
        int[] rotated = new int[N];

        for (int i = 0; i < N; i++) {
            rotated[(i+K) % N] = A[i];
        }
        return rotated;
    }

    public static void main(String[] args){
        check(new int[]{3, 8, 9, 7, 6}, 1, new int[]{6, 3, 8, 9, 7});
        check(new int[]{3, 8, 9, 7, 6}, 3, new int[]{9, 7, 6, 3, 8});
    }

    private static void check(int[] A, int K, int[] expected){

        int[] rotated = solution(A,K);
        for (int i = 0; i < A.length; i++) {
            if(rotated[i] != expected[i]){
                throw new RuntimeException("Expected "+ Arrays.toString(expected)+", but was "+Arrays.toString(rotated));
            }
        }
    }
}
