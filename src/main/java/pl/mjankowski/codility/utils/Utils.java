package pl.mjankowski.codility.utils;

/**
 * @author mac on 21.10.16
 */
public class Utils {

    public static int[] prefixSums(int[] A){

        int[] P = new int[A.length+1];

        P[0] = 0;
        for(int i=1; i<=A.length; i++){
            P[i] = P[i-1] + A[i-1];
        }
        return P;
    }

    public static int sliceSum(int[] P, int from, int to){
        return P[to+1] - P[from];
    }

}
