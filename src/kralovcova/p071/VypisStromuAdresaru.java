package kralovcova.p071;

import java.io.File;
import java.util.Scanner;

public class VypisStromuAdresaru {

    public static void vypisAdr(File file, int level) {
        File[] ff = file.listFiles();
        for (int j = 1; j <= level; j++) {
            System.out.print('-');
        }
        if (ff == null || ff.length == 0) {
            return;
        }
        System.out.println(file.getName());
        for (File f : ff) {
            if (f != null && f.isDirectory() && !f.isHidden()) {
                vypisAdr(f, level + 1);
            }
        }
    }

    public static void vypisAdr(String adr) {
        File file = new File(adr);
        if (file.isDirectory()) {
            vypisAdr(file, 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String aktualniAdr = System.getProperty("user.dir");
        System.out.println("Aktualni adresar je: " + aktualniAdr);
        System.out.println("Vypis hierarchie podadresaru ");
        vypisAdr(aktualniAdr);
        System.out.println("");
        System.out.println("Zadej adresar, pro vypis: ");
        String adr = sc.nextLine();
        System.out.println("Zadana cesta: " + adr);
        vypisAdr(adr);

    }
}
