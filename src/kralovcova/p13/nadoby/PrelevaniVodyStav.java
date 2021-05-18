/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p13.nadoby;

import java.util.ArrayList;
import java.util.List;
import kralovcova.p13.prohledavani.Stav;

/**
 *
 * @author Jirina
 */
public class PrelevaniVodyStav implements Stav<PrelevaniVodyStav> {
    
    private final int nadoba3;
    private final int nadoba4;

    public PrelevaniVodyStav() {
        nadoba3 = 0;
        nadoba4 = 0;
    }
    public PrelevaniVodyStav(int n3, int n4) {
        nadoba3 = n3;
        nadoba4 = n4;
    }
    
    @Override
    public List<PrelevaniVodyStav> getNasl() {
        ArrayList<PrelevaniVodyStav> vysledek = new ArrayList<>();
        // doplneni nadob
        vysledek.add( new PrelevaniVodyStav(3, nadoba4));
        vysledek.add( new PrelevaniVodyStav(nadoba3, 4));
        // vyprazdneni nadob
        vysledek.add( new PrelevaniVodyStav(0, nadoba4));
        vysledek.add( new PrelevaniVodyStav(nadoba3, 0));
        // preliti vody z nadoby3 do nadoby4
        int preliteMnozstvi = Math.min(nadoba3, 4 - nadoba4);
        vysledek.add( new PrelevaniVodyStav(nadoba3 - preliteMnozstvi, nadoba4 + preliteMnozstvi));
        // preliti vody z nadoby4 do nadoby3
        preliteMnozstvi = Math.min(nadoba4, 3 - nadoba3);
        vysledek.add( new PrelevaniVodyStav(nadoba3 + preliteMnozstvi, nadoba4 - preliteMnozstvi));
        return vysledek;
    }

    @Override
    public boolean jeStejny(PrelevaniVodyStav stav) {
        if (stav.nadoba3 != nadoba3) return false;
        if (stav.nadoba4 != nadoba4) return false;
        return true;
    }

    @Override
    public String toString() {
        return "(" + nadoba3 + ", " + nadoba4 + ')';
    }
    
    
}
