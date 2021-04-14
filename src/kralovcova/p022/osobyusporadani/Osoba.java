/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p022.osobyusporadani;

import java.util.Comparator;

/**
 *
 * @author Jirina
 */
public class Osoba implements Comparable<Osoba> {

    int vyska, vaha, vek;

    public final static Comparator COMP_DLE_VYSKY = new Comparator<Osoba>() {
        @Override
        public int compare(Osoba o1, Osoba o2) {
            return o1.vyska - o2.vyska;
        }

    };
    public final static Comparator<Osoba> COMP_DLE_VAHY = new Comparator<Osoba>() {
        @Override
        public int compare(Osoba o1, Osoba o2) {
            return o1.vaha - o2.vaha;
        }

    };

    public Osoba(int vyska, int vaha, int vek) {
        this.vyska = vyska;
        this.vaha = vaha;
        this.vek = vek;
    }

    public int getVyska() {
        return vyska;
    }

    public int getVaha() {
        return vaha;
    }

    public int getVek() {
        return vek;
    }

    public float getBMI() {
        return (float) vaha / (vyska * vyska);
    }

    @Override
    public String toString() {
        return "Osoba{" + "vyska=" + vyska + ", vaha=" + vaha + ", vek=" + vek + '}';
    }

    @Override
    public int compareTo(Osoba jinaOsoba) {
        return this.vek - jinaOsoba.vek;
    }


}
