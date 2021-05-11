/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p091.vlakna;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import kralovcova.p091.vlakna.Casovac.EventHandler;

/**
 *
 * @author Jirina
 */
public class TestCasovace {

    

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Zadej hodnotu ");
        Casovac cas = new Casovac(1000, new EventHandler() {
            @Override
            public void handleTimerEvent() {
                System.out.print("* ");
            }
        });
        
        Casovac cas2 = new Casovac(5000, new EventHandler() {
            @Override
            public void handleTimerEvent() {
                System.out.println("");
                System.out.println("Nejak dlouho to trva");
            }
        });
        
        Casovac cas3 = new Casovac(10000, new EventHandler() {
            @Override
            public void handleTimerEvent() {
                System.out.println("");
                System.out.println("Mne uz dochazi trpelivost");
            }
        });
        cas.start();
        cas2.start();
        cas3.start();
        int cislo = sc.nextInt();
        //cas.stop();
        //cas2.stop();
        //cas3.stop();
        System.out.println("Byla zadana hodnota " + cislo);
    }

}
