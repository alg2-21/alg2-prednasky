package kralovcova.p031.vyjimky;

public class ChybaNedostatekPameti2 {

    public static void main(String[] args) {
        int pocet = 10000;
        int velikost = 1000000;
        long[][] a;

        a = new long[pocet][];

        for (int i = 0; i < a.length; i++) {
            System.out.println(i);
            a[i] = new long[velikost];
        }
        System.out.println();
    }

}
