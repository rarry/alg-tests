package pl.mjankowski.codility.lesson1;

/**
 * @author mac on 14.10.16
 */
public class Gap {

    public  static int solution(int N) {

        int longestGap = 0;
        int currentGap = 0;
        boolean skip = true;

        while(N != 0) {
            int bit = N % 2;
            if (bit == 1) {
                // start counting
                skip = false;
                if (currentGap > longestGap) {
                    longestGap = currentGap;
                }
                currentGap = 0;
            } else if(!skip){
                currentGap++;
            }
            N = N/2;
        }
        return longestGap;
    }

    public static void main(String[] args){
        check(1041, 5);
        check(15, 0);
        check(561892, 3);
        check(74901729, 4);

    }

    private static void check(int N, int expected){
        int ret = solution(N);
        if(ret != expected) {
            throw new RuntimeException("For number "+N+", expected "+expected+", but got "+ret);
        }
    }

}
