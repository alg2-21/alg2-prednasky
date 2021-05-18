/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p13.hra8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kralovcova.p13.prohledavani.Stav;

public class Hra8Stav implements Stav<Hra8Stav> {

    private int[][] pole;
    private int rozmer;
    private int ra, sl;

    public Hra8Stav(int n){
        rozmer = n;
        int r,s;
        pole = new int[rozmer][rozmer];
        for (int i = 1; i < rozmer*rozmer; i++) {
           r = (i-1) / rozmer;
           s = (i-1) % rozmer;
           pole[r][s] = i;
        }
        ra = rozmer-1;
        sl = rozmer-1;
    }

    public Hra8Stav(int[][] a) {
        rozmer = a.length;
        pole = new int[rozmer][rozmer];
        for (int i = 0; i < rozmer; i++) {
            for (int j = 0; j < rozmer; j++) {
                pole[i][j] = a[i][j];
                if (a[i][j] == 0) {
                    ra = i;
                    sl = j;
                }
            }
        }
    }

    @Override
    public List<Hra8Stav> getNasl() {
        ArrayList<Hra8Stav> nasl = new ArrayList<>();
        Hra8Stav d;
        if (sl > 0) {
            d = new Hra8Stav(pole);
            d.pole[ra][sl] = d.pole[ra][sl-1];
            d.pole[ra][sl-1] = 0;
            d.sl--;
            nasl.add(d);
        }
        if (sl < rozmer-1) {
            d = new Hra8Stav(pole);
            d.pole[ra][sl] = d.pole[ra][sl+1];
            d.pole[ra][sl+1] = 0;
            d.sl++;
            nasl.add(d);
        }
        if (ra > 0) {
            d = new Hra8Stav(pole);
            d.pole[ra][sl] = d.pole[ra-1][sl];
            d.pole[ra-1][sl] = 0;
            d.ra--;
            nasl.add(d);
        }
        if (ra < rozmer-1) {
            d = new Hra8Stav(pole);
            d.pole[ra][sl] = d.pole[ra+1][sl];
            d.pole[ra+1][sl] = 0;
            d.ra++;
            nasl.add(d);
        }
        return nasl;
    }

    @Override
    public boolean jeStejny(Hra8Stav jinyStav) {
        return Arrays.deepEquals(this.pole, jinyStav.pole);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hra8Stav other = (Hra8Stav) obj;
        if (!Arrays.deepEquals(this.pole, other.pole)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Arrays.deepHashCode(this.pole);
        return hash;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(pole);
    }

}
