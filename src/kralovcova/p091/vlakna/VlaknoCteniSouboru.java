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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jirina
 */
public class VlaknoCteniSouboru {

    private static class CteckaSouboruCelychCisel implements Runnable {

        private static volatile int citac = 0;
        String jmenoSouboru;
        long pocetCisel;
        int maximalniHodnota;
        long[] poctyVyskytu;
        long dobaZpracovani;

        public CteckaSouboruCelychCisel(String jmenoSouboru) {
            this.jmenoSouboru = jmenoSouboru;
        }

        @Override
        public void run() {
            System.out.println("Zahajuji zpracovani souboru " + jmenoSouboru);
            long startTime = System.currentTimeMillis();
            try (Scanner ctecka = new Scanner(new FileInputStream(jmenoSouboru))) {
                
                maximalniHodnota = ctecka.nextInt();
                pocetCisel = ctecka.nextInt();
                poctyVyskytu = new long[maximalniHodnota];
                for (int i = 0; i < pocetCisel; i++) {
                    int cislo = ctecka.nextInt();
                    poctyVyskytu[cislo]++;
                    if ((i + 1) % 100 == 0) {
                        Thread.yield();
                    }
                    if ((i + 1) % 100000 == 0) {
                        synchronized (this) {
                            if (++citac >= 20) {
                                citac = 0;
                                System.out.println(" " + jmenoSouboru.charAt(0));                                
                            } else {
                                System.out.print(jmenoSouboru.charAt(0));
                            }
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Soubor neexistuje " + jmenoSouboru);
                Logger.getLogger(VlaknoCteniSouboru.class.getName()).log(Level.SEVERE, null, ex);
            }
            dobaZpracovani = System.currentTimeMillis() - startTime;
            //System.out.println("");
            //System.out.println("Koncim zpracovani souboru " + jmenoSouboru + " " + dobaZpracovani);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Thread ta = new Thread(new CteckaSouboruCelychCisel("a.txt"));
        Thread tb = new Thread(new CteckaSouboruCelychCisel("b.txt"));
        Thread tc = new Thread(new CteckaSouboruCelychCisel("c.txt"));

        ta.start();
        tb.start();
        tc.start();
        //while (ta.isAlive() || tb.isAlive() || tc.isAlive()) {
            //
        //}
        ta.join();
        tb.join();
        tc.join();
        System.out.println("");
        System.out.println("Tot vse");
        System.out.println("Program konci");
        
    }

}
