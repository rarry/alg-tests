package pl.mjankowski.codility.lesson5;


/**
 * @author mac on 22.10.16
 */
public class MinAvgTwoSlice {

    public static int[] prefixSums(int[] A) {

        int[] P = new int[A.length + 1];

        P[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            P[i] = P[i - 1] + A[i];
        }
        return P;
    }

    double avg(int start, int end, int[] P) {
        if (start == 0) {
            return P[end];
        } else {
            return P[end] - P[start - 1];
        }
    }

    public int solution(int[] A) {

        int[] P = prefixSums(A);

        int smallestIdx = 0;

        int start = 0;
        int end = 1;

        double smallestAvg = (double) (A[start] + A[end]) / (double) (end - start + 1);


        while(end < A.length) {
            while (A[end] >= smallestAvg && end < A.length-1) {
                end++;
            }

            double avgRight = avg(start, end, P) / (double) (end - start + 1);

            if (avgRight < smallestAvg) {
                smallestAvg = avgRight;
            }

            while (start < end) {
                double avgLeft = avg(start, end, P) / (double) (end - start + 1);
                if (avgLeft < smallestAvg) {
                    smallestAvg = avgLeft;
                    smallestIdx = start;
                }
                start++;
            }
            if(start == end){
                start--;
            }
            end++;
        }

        return smallestIdx;
    }

    public static void main(String[] args) {

        check(new int[]{1,10000000,1}, 0);
        check(new int[]{4,2}, 0);
        check(new int[]{4,2,2,5,1,5,8}, 1);
        check(new int[]{4, 2, 2, 51, 75, 100, 1, 1, 8}, 6);
    }

    private static void check(int[] A, int expected) {

        MinAvgTwoSlice obj = new MinAvgTwoSlice();

        int ret = obj.solution(A);
        if (ret != expected) {
            throw new RuntimeException("expected " + expected + ", but got " + ret);
        }
    }


    public int solution2(int[] A) {

        int[] P = prefixSums(A);

        int smallestIdx = 0;

        int start = 0;
        int end = 1;
        int length = 2;

        double smallestAvg = (double) (A[start] + A[end]) / (double) length;


        while (end < A.length - 1) {
            double avgRight = avg(start, end + 1, P) / (double) (length + 1);

            if (avgRight < smallestAvg) {
                end++;
                length++;
                smallestAvg = avgRight;
                smallestIdx = start;
            }

            if (A[end + 1] < smallestAvg) {
                double avgLeft = avg(start + 1, end, P) / (double) (length - 1);
                while (start < end - 1) {
                    if (avgLeft < smallestAvg) {
                        length--;
                        smallestIdx = start + 1;
                    }
                    start++;
                }
                start = smallestIdx;
            }
            end++;
        }

        return smallestIdx;
    }
}
