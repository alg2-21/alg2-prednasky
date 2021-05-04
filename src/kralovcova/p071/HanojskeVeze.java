package kralovcova.p071;

public class HanojskeVeze {

    public static void hanoi(int vyska, char od, char kam, char pom) {
        if (vyska > 0) {
            hanoi(vyska - 1, od, pom, kam);
            System.out.format("prenes disk %d z veze %c na vez %c%n", vyska, od, kam);
            hanoi(vyska - 1, pom, kam, od);
        }
    }

    public static void hanoiVez(int vyska, Vez od, Vez kam, Vez pom) {
        if (vyska > 0) {
            int d = 0;
            hanoiVez(vyska - 1, od, pom, kam);
            d = od.odeberDisk();
            kam.pridejDisk(d);
            System.out.println(a + " " + b + " " + c);
            hanoiVez(vyska - 1, pom, kam, od);
        }
    }
    
    
    public static Vez a, b, c;

    public static void main(String[] args) {
        System.out.println("Prvni verze ");
        hanoi(3, 'A', 'B', 'C');
        System.out.println();

        System.out.println("");
        System.out.println("Druha verze ");
        a = new Vez("A", 4, 4);
        b = new Vez("B", 4);
        c = new Vez("C", 4);
        try {
            System.out.println(a + " " + b + " " + c);
            hanoiVez(4, a, b, c);

            //a.pridejDisk(1);
            //c.odeberDisk();
            //c.pridejDisk(1);
            //c.pridejDisk(2);
        } catch (UnsupportedOperationException e) {
            System.out.println("Chybna operace s nekterou z vezi");
            System.out.println(e.getMessage()); //e.printStackTrace();
        }
        
        System.out.println("");
        System.out.println("Věž výšky 5 disků ");
        a = new Vez("A", 5, 5);
        b = new Vez("B", 5);
        c = new Vez("C", 5);
        try {
            System.out.println(a + " " + b + " " + c);
            hanoiVez(5, a, b, c);
        } catch (UnsupportedOperationException e) {
            System.out.println("Chybna operace s nekterou z vezi");
            System.out.println(e.getMessage()); //e.printStackTrace();
        }

    }
}
