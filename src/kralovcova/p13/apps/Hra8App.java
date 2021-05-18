package kralovcova.p13.apps;


import java.util.Arrays;
import java.util.List;
import kralovcova.p13.hra8.Hra8Stav;
import kralovcova.p13.prohledavani.Prohledavani;
import kralovcova.p13.prohledavani.ProhledavaniDoSirky;
import kralovcova.p13.prohledavani.Stav;

public class Hra8App {

    public static void main(String[] args) {
        int[][] pocPole = {{1, 2, 3}, {0,8,5}, {4,7,6}};
        int[][] konPole = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

        Hra8Stav pocStav = new Hra8Stav(pocPole);
        Hra8Stav konStav = new Hra8Stav(konPole);
        List<Hra8Stav> na = pocStav.getNasl();

        System.out.println(pocStav);
        for (Hra8Stav s : na) {
            System.out.println("  " + s);
        }

        Prohledavani<Hra8Stav> uloha;
        uloha = Prohledavani.getInstance( 
                Prohledavani.Metoda.DO_SIRKY);
        List<Hra8Stav> cesta = uloha.dejReseni(pocStav, konStav);
        
        System.out.println("Nalezene reseni");
        for (Hra8Stav s : cesta) {
            System.out.println("  " + s);
        }
        
        
    }
}
