/*
 * This code is part of ALP subject
 */

package kralovcova.p071;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class ProchazeniAdresarovehoStromu {

    public static long spaceUsed(File path) {
        if (path.isFile()) {
            return path.length();
        } else if (path.isDirectory()) {
            File[] ff = path.listFiles();
            if (ff == null) return 0;
            long v = 0;
            for (File f : ff) {
                v = v + spaceUsed(f);
            }
            return v;
        }
        System.out.println("Blind branch");
        return 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Velikost adresare na disku");
        System.out.println("Jak velky prostor v bytech zabira dany soubor nebo adresar (vcetne podadresaru)?");
        System.out.println("Zadej cestu k soboru nebo adresari");
        String pathStr = sc.nextLine();
        File pathFile = (new File(pathStr)).getCanonicalFile();
        long velNaDisku = spaceUsed(pathFile);
        System.out.format("Zadany soubor/adresar: %s%n", pathFile.getName());
        System.out.format("Plna cesta k souboru/adresari: %s%n", pathFile.getAbsolutePath());
        System.out.format("Data v zadanem adresari zabiraji %,d byte%n", velNaDisku);
    }

}