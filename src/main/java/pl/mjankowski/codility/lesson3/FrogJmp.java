package pl.mjankowski.codility.lesson3;

/**
 * @author mac on 15.10.16
 */
public class FrogJmp {

    public static int solution(int X, int Y, int D) {

        return (int)Math.ceil((double)(Y - X) / (double)D);
    }

//    public static int solution(int X, int Y, int D) {
//
//        int length = Y - X;
//        int jmp = length / D;
//        if (length % D > 0) {
//            jmp += 1;
//        }
//        return jmp;
//    }

    public static void main(String[] args) {
        check(10, 85, 30, 3);
        check(10, 10, 30, 0);
        check(1, 1000000000, 1000000000, 1);
        check(1,2,1,1);
    }

    private static void check(int X, int Y, int D, int expected) {

        int jmp = solution(X, Y, D);
        if (jmp != expected) {
            throw new RuntimeException("expected " + expected + ", but got " + jmp);
        }
    }
}
