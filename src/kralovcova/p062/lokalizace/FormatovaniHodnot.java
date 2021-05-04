/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */

package kralovcova.p062.lokalizace;

import java.util.Locale;

/**
 *
 * @author Jirina
 */
public class FormatovaniHodnot {

    /**
     * @param args the command line arguments
     */
    public static Locale ceskaLokalizace = new Locale("cs", "CZ");
    public static Locale anglickaLokalizace = new Locale("en", "GB");
    public static Locale nemeckaLokalizace = new Locale("de", "DE");
    public static Locale francouzskaLokalizace = new Locale("fr", "FR");
    public static Locale americkaLokalizace = new Locale("en", "US");
    public static Locale anglickaKanada = new Locale("en", "CA");
    public static Locale francouzskaKanada = new Locale("fr", "CA");
    public static Locale[] lo = {ceskaLokalizace, anglickaLokalizace,
        nemeckaLokalizace, francouzskaLokalizace,
        americkaLokalizace, anglickaKanada, francouzskaKanada};
    public static String[] jm = {"CZ", "GB", "DE", "FR", "US", "EnCA", "FrCA"};

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        double cislo = 453.14578;
        int i;
        System.out.println("Aktualni mesic ");
        i = 0;
        for (Locale l : lo) {
            System.out.format(l, "%2s %2s - %TB%n", l.getCountry(), l.getLanguage(), now);
        }
        System.out.format(Locale.TRADITIONAL_CHINESE, "%5s - %TB%n", "China", now);
        System.out.format(Locale.JAPAN, "%5s - %TB%n", "Japan", now);

        System.out.println("");
        System.out.println("Aktualni den tydne ");
        i = 0;
        for (Locale l : lo) {
            System.out.format(l, "%2s %2s - %TA%n", l.getCountry(), l.getLanguage(), now);
        }
        System.out.format(Locale.TRADITIONAL_CHINESE, "%5s - %TA%n", "China", now);
        System.out.format(Locale.JAPAN, "%5s - %TA%n", "Japan", now);

        System.out.println("");
        System.out.println("Formatovani realnych cisel ");
        i = 0;
        for (Locale l : lo) {
            System.out.format(l, "%2s %2s - %f%n", l.getCountry(), l.getLanguage(), cislo);
        }
        System.out.format(Locale.TRADITIONAL_CHINESE, "%5s - %f%n", "China", cislo);
        System.out.format(Locale.JAPAN, "%5s - %f%n", "Japan", cislo);

        // turecky dekuji
        // turectina rozlisuje İ,i - klasické i s tečkou I,ı - i bez tečky
        System.out.println("");
        System.out.println("Turecky 'Thank you' ");
        System.out.println("Teşekkür ederim");
        System.out.println("Teşekkür ederim".toUpperCase());
        System.out.println("Teşekkür ederim".toUpperCase(new Locale("tr")));
    }
}
