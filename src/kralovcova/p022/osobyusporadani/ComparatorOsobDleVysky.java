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
public class ComparatorOsobDleVysky implements Comparator<Osoba> {

    @Override
    public int compare(Osoba o1, Osoba o2) {
        return o1.getVyska() - o2.getVyska();
    }
    
}
