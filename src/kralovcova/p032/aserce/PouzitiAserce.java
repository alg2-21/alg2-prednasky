/*
 * This code is part of ALP subject
 */
package kralovcova.p032.aserce;

/**
 *
 * @author Jirina
 */
public class PouzitiAserce {

    public static void main(String[] args) {
        //try {
            System.out.println("Vypocet2 param 6 > " + vypocet2(6));
            System.out.println("Vypocet2 param -6 > " + vypocet2(-6));
        //} catch (AssertionError e) {
            // i vyjimku AssertionError lze odchytit
            // povolit kontrolu aserci pouze ve fazi vyvoje/ladeni programoveho kodu
            // odchyceni a osetreni AssertionError nemusi byt korektnim 
            // nesplnena nektera z podminek testovanych asercemi
            // potlaceni ukonceni programu pri poruseni podminky
            // informaci o nastalem problemu zobrazit, nebo lepe zaroven ulozit do logu apod.
            //System.out.println("Porusena nektera z podminek funkcniho kodu");
            //System.out.println(e.getMessage());
            //e.printStackTrace();
        //}
    }

    public static int vypocet1(int cislo) {
        assert cislo > 0;
        return 2 * cislo;
    }

    public static int vypocet2(int cislo) {
        assert cislo > 0 : "Chyba v kodu, neplatna hodnota parametru metody vypocet2(), info o tride apod. " + cislo ;
        return 2 * cislo;
    }
}
