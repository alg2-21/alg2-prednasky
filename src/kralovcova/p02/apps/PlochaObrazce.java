/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p02.apps;

import kralovcova.p021.geomsinterface.Geom2D;
import kralovcova.p021.geomsinterface.Kruh;
import kralovcova.p021.geomsinterface.Obdelnik;

/**
 *
 * @author Jirina
 */
public class PlochaObrazce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Geom2D[] po = new Geom2D[3];
       po[0] = new Kruh(1);
       po[1] = new Obdelnik(2, 3);
       po[2] = new Obdelnik(1, 1);
       System.out.println(vypoctiPlochuObrazce(po));
    }

    public static double vypoctiPlochuObrazce(Geom2D[] po) {
        double plocha = 0;
        for (Geom2D go : po) {
            plocha += go.getPlocha();
        }
        return plocha;
    }
}
