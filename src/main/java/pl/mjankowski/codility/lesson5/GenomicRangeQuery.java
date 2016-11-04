package pl.mjankowski.codility.lesson5;

import java.util.Arrays;

/**
 * @author mac on 21.10.16
 */
public class GenomicRangeQuery {

    public static int[] prefixSums(int[] A, int n){

        int[] P = new int[A.length+1];

        P[0] = 0;
        for(int i=1; i<=A.length; i++){
            if(A[i-1] == n) {
                P[i] = P[i - 1] + A[i - 1];
            }else{
                P[i] = P[i - 1];
            }
        }
        return P;
    }

    public int[] solution(String S, int[] P, int[] Q){

        char[] chars = S.toCharArray();
        int[] numbers = new int[chars.length];

        for(int i=0; i<chars.length; i++){
            switch(chars[i]){
                case 'A': numbers[i] = 1;
                    break;
                case 'C': numbers[i] = 2;
                    break;
                case 'G': numbers[i] = 3;
                    break;
                case 'T': numbers[i] = 4;
                    break;
            }
        }

        int[] prefinxSum_1 = prefixSums(numbers, 1);
        int[] prefinxSum_2 = prefixSums(numbers, 2);
        int[] prefinxSum_3 = prefixSums(numbers, 3);
        int[] prefinxSum_4 = prefixSums(numbers, 4);

        int[] impact = new int[P.length];

        for(int i=0; i<P.length; i++){
            if(prefinxSum_1[Q[i]+1] - prefinxSum_1[P[i]] > 0){
                impact[i] = 1;
                continue;
            }

            if(prefinxSum_2[Q[i]+1] - prefinxSum_2[P[i]] > 0){
                impact[i] = 2;
                continue;
            }

            if(prefinxSum_3[Q[i]+1] - prefinxSum_3[P[i]] > 0){
                impact[i] = 3;
                continue;
            }

            if(prefinxSum_4[Q[i]+1] - prefinxSum_4[P[i]] > 0){
                impact[i] = 4;
                continue;
            }
        }

        return impact;
    }

    public static void main(String[] args) {
        check("CAGCCTA", new int[]{2,5,0}, new int[]{4,5,6}, new int[]{2,4,1});
        check("C", new int[]{0,0,0}, new int[]{0,0,0}, new int[]{2,2,2});
        check("CG", new int[]{0,0,1}, new int[]{0,1,1}, new int[]{2,2,3});
        check("CG", new int[]{0}, new int[]{0}, new int[]{2});
    }

    private static void check(String S, int[] P, int[] Q, int[] expected) {

        GenomicRangeQuery obj = new GenomicRangeQuery();

        int[] ret = obj.solution(S,P,Q);
        if (!Arrays.equals(ret, expected)) {
            throw new RuntimeException("expected " + Arrays.toString(expected) + ", but got " + Arrays.toString(ret));
        }
    }
}
