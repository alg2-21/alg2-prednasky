/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */

package kralovcova.p062.lokalizace;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author Jirina
 */
public class PorovnavaniTextovychRetezcu {
    private static Collator col = Collator.getInstance(new Locale("cs", "CZ"));

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] slova = {"žlutý","chaluha", "červená", "Chalupa", "zet", "era", "éra", "ed", "éd", "ěd", "Zet", "cop", "chytrý", "cervena", "Zeď", "zeď", "Zed", "ěra"}; // !!!!!!!!!!!!

        System.out.println("Puvodni poradi ");
        System.out.println(Arrays.toString(slova));
        Arrays.sort(slova);
        System.out.println("Po alfanumerickem usporadani ");
        System.out.println(Arrays.toString(slova));

        Arrays.sort(slova, new Comparator<String>() {
            
            public int compare(String o1, String o2) {
                return col.compare(o1, o2);
            }
        });
        System.out.println("Po usporadani dle ceske normy");
        System.out.println(Arrays.toString(slova));
    }
}
