/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p02.apps;

import kralovcova.p025.geomsdedicnost.Obdelnik;
import kralovcova.p025.geomsdedicnost.Ctverec;
import kralovcova.p025.geomsdedicnost.Geom;

/**
 *
 * @author Jirina
 */
public class PlochaObrazceDed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Geom[] po = new Geom[3];
       po[0] = new Ctverec(1);
       po[1] = new Obdelnik(2., 3.);
       po[2] = new Obdelnik(1, 1);
       System.out.println(vypoctiPlochuObrazce(po));
    }

    public static double vypoctiPlochuObrazce(Geom[] po) {
        double plocha = 0;
        for (Geom go : po) {
            plocha += go.getPlocha();
        }
        return plocha;
    }
   

}
