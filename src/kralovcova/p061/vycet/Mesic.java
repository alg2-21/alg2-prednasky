/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p061.vycet;

/**
 *
 * @author Jirina
 */
public enum Mesic {
    
    LEDEN, 
    UNOR, 
    BREZEN, 
    DUBEN, 
    KVETEN, 
    CERVEN, 
    CERVENEC, 
    SRPEN, 
    ZARI, 
    RIJEN, 
    LISTOPAD, 
    PROSINEC;
    
    private static int[] pocetDnu = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public int getPocetDnu() {
        return pocetDnu[this.ordinal()]; 
    }
    
    public int getPocetDnuVPrestupnemRoce() {
        if (this == UNOR) return pocetDnu[this.ordinal()] + 1; 
        return pocetDnu[this.ordinal()]; 
    }
    
    public int getPocetDnuVZadanemRoce(int rok) {
        if (jePrestupnyRok(rok) && this == UNOR) {
            return pocetDnu[this.ordinal()] + 1;
        }
        return pocetDnu[this.ordinal()]; 
    }

    private static boolean jePrestupnyRok(int rok) {
        return (rok % 4 == 0) && (!(rok % 100 == 0) || (rok % 400 == 0));
    }
    
    public static void main(String[] args) {
        System.out.println(UNOR.getPocetDnu());
        System.out.println(UNOR.getPocetDnuVPrestupnemRoce());
        System.out.println(CERVEN.getPocetDnuVPrestupnemRoce());
        System.out.println(UNOR.getPocetDnuVZadanemRoce(2000));
        System.out.println(UNOR.getPocetDnuVZadanemRoce(2004));
        System.out.println(UNOR.getPocetDnuVZadanemRoce(2010));
        System.out.println(UNOR.getPocetDnuVZadanemRoce(2100));
    }
    
}
