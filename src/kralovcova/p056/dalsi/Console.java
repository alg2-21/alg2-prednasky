/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p056.dalsi;

import java.util.Scanner;
/**
 *
 * @author Jirina
 */
public class Console {

    // zkuste spusteni programu ve vyvojovem prostredi a z prikazove radky

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (System.console() != null) {
            System.out.println("Pouziti systemove konzole");
            
            // pokud je k dispozici objekt console, lze ho pouzit pro vstupy  
            // od uzivatele a vypisy
            // objekt console ma pak spravne nastavene kodovani
            
            Scanner sc = new Scanner(System.console().reader());
            String radek;
            while((radek = sc.nextLine()).length() > 0) {
                System.console().format("%s%n", radek);
            }
        } else {
            System.out.println("Objekt console neni k dispozici");
        }
    }

}
