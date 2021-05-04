/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p071.rekurze;

public class FaktorialCisla {

    public static long fak(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static long faktorial(int n) {
        if (n > 1) {
            return n * faktorial(n - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.format("%2d % 10d%n", i, faktorial(i));
        }


    }
}
