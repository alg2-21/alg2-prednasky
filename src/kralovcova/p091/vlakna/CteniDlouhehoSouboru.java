/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p091.vlakna;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jirina
 */
public class CteniDlouhehoSouboru {

    private static volatile int pocetNactenych;
    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Zadej nazev souboru");
        String jmSoub = sc.nextLine();

        Casovac timer = new Casovac(5000, new Casovac.EventHandler() {
            @Override
            public void handleTimerEvent() {
                System.out.format("%s %2$tH:%2$tM:%2$tS : Pocet aktualne nactenych hodnot %3$d %n",
                        Thread.currentThread().getName(),
                        Calendar.getInstance().getTime(),
                        pocetNactenych);
            }
        });
        timer.start();


        try (Scanner ctecka = new Scanner(new FileInputStream(jmSoub))) {
            System.out.println(Thread.currentThread().getName() + ": Zahajuji cteni souboru " + pocetNactenych);
            
            // prvni dve hodnoty jsou max. hodnota a pocret cisel ulozenych do souboru
            int maximalniHodnota = ctecka.nextInt();
            int pocetCisel = ctecka.nextInt();
            long[] poctyVyskytu = new long[maximalniHodnota];
            for (int poradi = 0; poradi < pocetCisel; poradi++) {
                int cislo = ctecka.nextInt();
                pocetNactenych = poradi;
                poctyVyskytu[cislo]++;
            }
//            while (ctecka.hasNext()) {
//                int dalsiCislo = ctecka.nextInt();
//                 dalsiCislo - zpracovani
//                pocetNactenych++;
//            }
            System.out.println(Thread.currentThread().getName() + ": Koncim cteni souboru " + pocetNactenych);
        } catch (FileNotFoundException ex) {
            System.out.println(Thread.currentThread().getName() + ": Chyba pri zpracovani souboru, koncim nacitani " + pocetNactenych);
            Logger.getLogger(VlaknoCteniSouboru.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
