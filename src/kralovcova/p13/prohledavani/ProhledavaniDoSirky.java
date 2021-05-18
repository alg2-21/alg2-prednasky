/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p13.prohledavani;

/**
 *
 * @author Jirina
 * @param <S>
 */
public class ProhledavaniDoSirky<S extends Stav<S>> extends Prohledavani<S> {

    protected ProhledavaniDoSirky() {
        super();
    }

    @Override
    protected void vlozDoOpen(Nod<S> nod) {
        open.addLast(nod);
    }

    @Override
    protected Nod<S> vezmiZOpen() {
        return open.removeFirst();
    }

    
}
