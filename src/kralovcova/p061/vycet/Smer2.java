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
public enum Smer2 {
// hodnoty prvnich dvou parametru jsou zavisle na souradnem systemu
    VYCHOD(1, 0, "VYCHOD"),
    SEVER(0, -1, "SEVER"),
    ZAPAD(-1, 0, "ZAPAD"),
    JIH(0, 1, "JIH");

    private final int dx;
    private final int dy;
    private final String name;
    private static final Smer2[] SMERY = new Smer2[]{VYCHOD, SEVER, ZAPAD, JIH};
    private static final int pocetSmeru = SMERY.length;

    private Smer2(int dx, int dy, String name) {
        this.dx = dx;
        this.dy = dy;
        this.name = name;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public String getName() {
        return name;
    }

    public Smer2 otocVlevo() {
        return SMERY[(ordinal() + 1) % pocetSmeru];
    }

    public Smer2 otocVpravo() {
        return SMERY[(ordinal() + (pocetSmeru - 1)) % pocetSmeru];
    }

    public Smer2 otocVzad() {
        return SMERY[(ordinal() + 2) % pocetSmeru];
    }

    public static Smer2 getSmer(String popis) {
        if (popis.equalsIgnoreCase(VYCHOD.name)) {
            return VYCHOD;
        } else if (popis.equalsIgnoreCase(ZAPAD.name)) {
            return ZAPAD;
        } else if (popis.equalsIgnoreCase(SEVER.name)) {
            return SEVER;
        } else if (popis.equalsIgnoreCase(JIH.name)) {
            return JIH;
        } else {
            throw new RuntimeException("Chybne zastupne jmeno smeru");
        }
    }

    public static void main(String[] args) {
        Smer2[] sms = SMERY;

        for (Smer2 sm : sms) {
            System.out.println("Aktualni smer " + sm);
            System.out.println("Po otoceni vlevo smer  " + sm.otocVlevo());
            System.out.println("Po otoceni vzad smer   " + sm.otocVzad());
            System.out.println("Po otoceni vpravo smer " + sm.otocVpravo());
            System.out.println();

        }
    }
}