package kralovcova.p071.rekurze;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;


/**
 *
 * @author Jirina
 */
public class VypisStromuAdresaru2 {

    private static void doVypis(File file, int level) {
        for (int j = 1; j <= level; j++) {
            System.out.print('-');
        }
        System.out.println(file.getName());
        File[] ff = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File f = new File(dir, name); 
                return f.isDirectory() && !f.isHidden();
            }
        });
        if (ff == null) return;
        for (File f : ff) {
            doVypis(f, level + 1);
        }
    }

    public static void vypisStromAdr(String adrJm) {
        File file = new File(adrJm);
        if (file.isDirectory()) {
            doVypis(file, 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = System.getProperty("user.dir");
        String aktualniAdr = System.getProperty("user.dir");
        System.out.println("Aktualni adresar je: " + aktualniAdr);
        System.out.println("Vypis hierarchie podadresaru ");
        vypisStromAdr(aktualniAdr);
        
        System.out.println("");
        System.out.println("Zadej adresar, pro vypis: ");
        String jinyAdr = sc.nextLine();
        System.out.println("Zadana cesta: " + jinyAdr);
        System.out.println("Vypis hierarchie podadresaru ");
        vypisStromAdr(jinyAdr);
    }
}
