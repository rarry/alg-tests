package pl.mjankowski.codility.lesson3;

/**
 * @author mac on 15.10.16
 */
public class TapeEquilibrium {

    public static int solution(int[] A) {

        int leftSum = 0;
        int rightSum = 0;
        int minDiff;

        leftSum = A[0];
        for (int i = 1; i < A.length; i++) {
            rightSum += A[i];
        }

        minDiff = Math.abs(leftSum - rightSum);

        for (int P = 2; P < A.length; P++) {
            leftSum += A[P-1];
            rightSum -= A[P-1];
            int diff = Math.abs(leftSum - rightSum);
            if(diff < minDiff){
                minDiff = diff;
            }
        }
        return minDiff;
    }

    public static void main(String[] args){
        check(new int[]{3,1,2,4,3}, 1);
        check(new int[]{0,2000}, 2000);
        check(new int[]{2000,0}, 2000);
        check(new int[]{1,2001}, 2000);
        check(new int[]{-1000,1000}, 2000);
        check(new int[]{-1,-2,-3,-4,-5}, 3);
    }

    private static void check(int[] A, int expected){

        int minDiff = solution(A);
        if(minDiff != expected){
            throw new RuntimeException("expected "+expected+", but got "+minDiff);
        }
    }

}
