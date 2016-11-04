package pl.mjankowski.codility.lesson4;

/**
 * @author mac on 16.10.16
 */
public class PermCheck {

    public static int solution(int[] A) {
        int[] copy = new int[A.length];

        for(int i=0; i<copy.length; i++){
            copy[i] = -1;
        }

        for(int i=0; i<A.length; i++){
            int elem = A[i];
            if(elem < 1 || elem > A.length){
                return 0;
            }
            copy[elem-1] = elem;
        }

        for(int i=0; i<copy.length; i++){
            if(i+1 != copy[i]){
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {

        check(new int[]{2, 3, 1, 5}, 0);
        check(new int[]{2, 3, 1, 5, 4,7,9,17,8, 10,16,11,15,12,14,13}, 0);
        check(new int[]{4,1,3,2}, 1);
        check(new int[]{4,1,3}, 0);
    }

    private static void check(int[] A, int expected) {

        int ret = solution(A);
        if (ret != expected) {
            throw new RuntimeException("expected " + expected + ", but got " + ret);
        }
    }
}
