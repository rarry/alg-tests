package pl.mjankowski.codility.lesson5;

/**
 * @author mac on 21.10.16
 */
public class CountDiv {

    public int solution(int A, int B, int K) {

        int aDivK = (int)Math.ceil((double)(A)/(double)K);
        int firstBiggerThanA = aDivK * K;

        if(firstBiggerThanA > B){
            return 0;
        }

        int ret = (B-firstBiggerThanA) / K + 1;

        return ret;
    }

    public static void main(String[] args) {


        check(0, 10, 2, 6);
        check(0, 0, 6, 1);
        check(0, 1, 7, 1);
        check(2000000000, 2000000000, 6, 0);
        check(2000000000, 2000000000, 2000000000, 1);
        check(1, 5, 6, 0);
        check(101, 110, 20, 0);
        check(100, 200, 101, 1);
        check(100, 200, 10, 11);
        check(101, 200, 10, 10);
        check(100, 199, 10, 10);
    }

    private static void check(int A, int B, int K, int expected) {

        CountDiv obj = new CountDiv();

        int ret = obj.solution(A,B, K);
        System.out.println("ret = "+ret);
        if (ret != expected) {
            throw new RuntimeException("expected " + expected + ", but got " + ret);
        }
    }
}
