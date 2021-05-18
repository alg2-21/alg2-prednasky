package kralovcova.p13.prohledavani;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jirina
 * @param <S>
 */
public abstract class Prohledavani<S extends Stav<S>> {

    protected LinkedList<Nod<S>> open;
    protected LinkedList<Nod<S>> close;

    protected static class Nod<S> {
        S stav;
        Nod<S> pred;

        public Nod(S stav) {
            this(stav, null);
        }

        public Nod(S stav, Nod<S> pred) {
            this.stav = stav;
            this.pred = pred;
        }
    }

    public static enum Metoda {
        DO_SIRKY, DO_HLOUBKY;
    }

    protected Prohledavani() {
        open = new LinkedList<>();
        close = new LinkedList<>();
    }

    public static Prohledavani getInstance() {
        return getInstance(Metoda.DO_SIRKY);
    }

    public static Prohledavani getInstance(Metoda metoda) {
        
        if (metoda == Metoda.DO_SIRKY) {
            return new ProhledavaniDoSirky();
        } else if (metoda == Metoda.DO_HLOUBKY) {
            return new ProhledavaniDoHloubky();
        }
        throw new IllegalArgumentException("Neznama metoda prohledavani " + metoda);
    }

    public List<S> dejReseni(S poc, S kon) {
        if (poc == null) {
            throw new NullPointerException("Pocatecni stav nezadan");
        }
        if (kon == null) {
            throw new NullPointerException("Koncovy stav nezadan");
        }
        open.clear();
        close.clear();
        Nod<S> reseni = hledejReseni(poc, kon);
        if (reseni == null) {
            return null;
        }
        LinkedList<S> vysledek = new LinkedList<>();
        while (reseni != null) {
            vysledek.addFirst(reseni.stav);
            reseni = reseni.pred;
        }
        return vysledek;
    }

    private Nod<S> hledejReseni(S poc, S kon) {
        vlozDoOpen(new Nod<>(poc));
        while (!open.isEmpty()) {
            Nod<S> akt = vezmiZOpen();
            close.add(akt);
            if (akt.stav.jeStejny(kon)) {
                return akt;
            }
            List<S> nasl = akt.stav.getNasl();
            for (S st : nasl) {
                if (st != null) {
                    if (!jeVSeznamu(st, open) && !jeVSeznamu(st, close)) {
                        vlozDoOpen(new Nod<>(st, akt));
                    }
                }
            }
        }
        return null;
    }

    protected abstract void vlozDoOpen(Nod<S> nod);

    protected abstract Nod<S> vezmiZOpen();

    protected boolean jeVSeznamu(S st, List<Nod<S>> seznam) {
        for (Nod<S> nod : seznam) {
            if (st.jeStejny(nod.stav)) {
                return true;
            }
        }
        return false;
    }

}
