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
public enum Den {

    PO(8, "pondeli"),
    UT(8, "utery"),
    ST(8, "streda"),
    CT(8, "ctvrtek"),
    PA(7, "patek"),
    SO(0, "sobota"),
    NE(0, "nedele");
    
    private int pocetPracHod;
    private String fullname;

    private Den(int pocetPracHod, String fullname) {
        this.pocetPracHod = pocetPracHod;
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return fullname;
    }

    public int getPocetPracHod() {
        return pocetPracHod;
    }
    
    public boolean jeVikend() {
        return this.equals(SO) || this.equals(NE);
    }
    
    public boolean jePracovniDen() {
        return !this.jeVikend();
    }

    public static void main(String[] args) {
        Den d = Den.PO;
        System.out.println(d);
        System.out.println(d.name());
        System.out.println(d.ordinal());
        System.out.println(d);
        System.out.println(d.jePracovniDen());
        System.out.println(d.jeVikend());

    }
}