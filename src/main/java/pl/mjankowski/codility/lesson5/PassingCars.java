package pl.mjankowski.codility.lesson5;

/**
 * @author mac on 21.10.16
 */
public class PassingCars {

    public int solution(int[] A) {

        int zeroes = 0;
        int passingCars = 0;

        for(int i=0; i<A.length; i++){
            if(A[i] == 0){
                zeroes++;
            }else{ // A[i] == 1
                passingCars += zeroes;
                if(passingCars > 1000000000){
                    return -1;
                }
            }
        }
        return passingCars;
    }

    public static void main(String[] args) {

        check(new int[]{0, 1, 0, 1, 1}, 5);
        check(new int[]{0}, 0);
        check(new int[]{1}, 0);
        check(new int[]{0,1}, 1);
        check(new int[]{1, 0}, 0);
    }

    private static void check(int[] A, int expected) {

        PassingCars obje = new PassingCars();

        int ret = obje.solution(A);
        if (ret != expected) {
            throw new RuntimeException("expected " + expected + ", but got " + ret);
        }
    }
}
