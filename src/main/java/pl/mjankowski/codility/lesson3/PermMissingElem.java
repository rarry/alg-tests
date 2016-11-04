package pl.mjankowski.codility.lesson3;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author mac on 15.10.16
 */
public class PermMissingElem {

    public static int insert(int[] A, int elem){

        if(elem <= A.length && A[elem-1] != elem) {
            int tmp = A[elem - 1];
            A[elem - 1] = elem;
            return tmp;
        }else{
            return elem;
        }
    }

    public static int solution(int[] A) {

        for (int i = 1; i <= A.length; i++) {
            int elem = i;
            int newElem = A[i-1];
            while(newElem != elem){
                elem = newElem;
                newElem = insert(A,elem);
            }
        }
        for (int i = 1; i <= A.length; i++) {
            if (i != A[i - 1]) {
                return i;
            }
        }

        return A.length + 1;
    }

    public static int solution2(int[] A) {
        int aSum = Arrays.stream(A).sum();
        long range  = LongStream.range(1,100000).sum();
        return (int)(range - aSum);
    }

    public static void main(String[] args) {

        check(new int[]{2, 3, 1, 5}, 4);
        check(new int[]{2, 3, 1, 5, 4,7,9,17,8, 10,16,11,15,12,14,13}, 6);
    }

    private static void check(int[] A, int expected) {

        int ret = solution(A);
        if (ret != expected) {
            throw new RuntimeException("expected " + expected + ", but got " + ret);
        }
    }
}
