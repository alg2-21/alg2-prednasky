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
 */
public class ProhledavaniDoHloubky<S extends Stav<S>> extends Prohledavani<S> {

    protected ProhledavaniDoHloubky() {
        super();
    }

    @Override
    protected void vlozDoOpen(Nod<S> nod) {
        open.addFirst(nod);
    }

    @Override
    protected Nod<S> vezmiZOpen() {
        return open.removeFirst();
    }

    


    
}
