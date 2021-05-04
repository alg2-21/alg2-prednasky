package kralovcova.p071;

public class Sort {

    // levy, pravy - rozsah indexu trideneho pole
    // a[levy] - zvoleny pivotni prvek
    // m - vysledna pozice pivotniho prvku
    public static void quickSort(int[] a, int levy, int pravy) {
        if (levy < pravy) {
            int pom;
            int m = levy;
            for (int i = levy + 1; i <= pravy; i++) {
                if (a[i] < a[levy]) {
                    m++;
                    pom = a[i];
                    a[i] = a[m];
                    a[m] = pom;
                }
            }
            pom = a[levy];
            a[levy] = a[m];
            a[m] = pom;
            quickSort(a, levy, m - 1);
            quickSort(a, m + 1, pravy);
        }
    }

    public static void quickSort2(int[] a, int d, int h) {
        int i = d;
        int j = h;
        int x = a[(d + h) / 2];
        int pom;

        while (i < j) { //do {
            while ((i < h) && (a[i] < x)) {
                i++;
            }
            while ((j > d) && (a[j] > x)) {
                j--;
            }
            if (i <= j) {
                pom = a[i];
                a[i] = a[j];
                a[j] = pom;
                i++;
                j--;
            }
        } //;

        if (j > d) {
            quickSort2(a, d, j);
        }
        if (i < h) {
            quickSort2(a, i, h);
        }
    }

    public static void merge(int[] a, int d, int p, int h) {
        int i1 = d;
        int i2 = p + 1;
        int[] b = new int[h - d + 1];

        for (int i = 0; i < b.length; i++) {
            if ((i2 > h) || ((i1 <= p) && ((a[i1] <= a[i2])))) {
                b[i] = a[i1++];
            } else {
                b[i] = a[i2++];
            }
        }
        for (int i = 0; i < b.length; i++) {
            a[d + i] = b[i];
        }
    }

    public static void mergeSort(int[] a, int d, int h) {
        if (d < h) {
            int pul = (d + h) / 2;
            mergeSort(a, d, pul);
            mergeSort(a, pul + 1, h);
            merge(a, d, pul, h);
        }
    }

    public static void vypisPole(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.format("%2d ", a[i]);
        }
        System.out.format("%n");
    }

    public static boolean jeSetridene(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[31];

        System.out.println("QickSort");
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < a.length; j++) {
                a[j] = (int) (Math.random() * 100);
            }
            quickSort(a, 0, a.length - 1);
            System.out.print(jeSetridene(a) + " ");
            vypisPole(a);
        }

        System.out.println();
        System.out.println("MergeSort");
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < a.length; j++) {
                a[j] = (int) (Math.random() * 100);
            }
            mergeSort(a, 0, a.length - 1);
            System.out.print(jeSetridene(a) + " ");
            vypisPole(a);
        }

        System.out.println();
        int pErr = 0;
        System.out.println("QuickSort2");
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < a.length; j++) {
                a[j] = (int) (Math.random() * 100);
            }
            quickSort2(a, 0, a.length - 1);
            if (jeSetridene(a)) {
                System.out.print("OK" + " ");
            } else {
                System.out.print("CHYBA!" + " ");
                pErr++;
            }
            vypisPole(a);
        }
        System.out.println("Pocet chybných výsledku " + pErr);
    }
}