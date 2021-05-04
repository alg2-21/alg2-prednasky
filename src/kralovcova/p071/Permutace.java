package kralovcova.p071;

public class Permutace {

    public static void ntice(int[] a, int n) {
        if (n <= 0) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < a.length; i++) {
                boolean je = false;
                for (int j = a.length - 1; j >= n; j--) {
                    if (a[j] == i) {
                        je = true;
                    }
                }
                if (!je) {
                    a[n - 1] = i;
                    ntice(a, n - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        ntice(new int[5], 5);
    }
}
