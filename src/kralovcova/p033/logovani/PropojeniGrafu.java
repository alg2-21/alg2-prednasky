/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p033.logovani;

import java.util.logging.Logger;

public class PropojeniGrafu {
    
    
    private short[] propojeniUzlu;

    public PropojeniGrafu(short pocet) {
        if (pocet <=0) {
            throw new IllegalArgumentException("Chybny pocet uzlu grafu " + 0);
        }
        propojeniUzlu = new short[pocet + 1];
    }
    
    public void pridejHranu(short p, short q) {
        if (p <= 0 || p > propojeniUzlu.length)
            throw new IllegalArgumentException("Cislo uzlu grafu mimo povoleny rozsah " + p);
        if (q <= 0 || q > propojeniUzlu.length)
            throw new IllegalArgumentException("Cislo uzlu grafu mimo povoleny rozsah " + q);
        Logger.getLogger(PropojeniGrafu.class.getName()).info("Pridana hrana " + p + " " + q);;
    }
    
    
    
}
