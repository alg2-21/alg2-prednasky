/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p13.prohledavani;

import java.util.List;

/**
 *
 * @author Jirina
 */
public interface Stav<S extends Stav> {

    public List<S> getNasl();

    public boolean jeStejny(S stav);
}
