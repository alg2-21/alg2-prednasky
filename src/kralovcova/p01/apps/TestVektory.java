/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p01.apps;

import kralovcova.p01.geoms.Vektor;
import kralovcova.p01.geoms.Vektory;

/**
 *
 * @author Jirina
 */
public class TestVektory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vektor v1, v2;
        v1 = new Vektor(7, 1, 2);
        v2 = new Vektor(0, 0, 1);
        System.out.println(v1.getZ());
        
        System.out.println(Vektory.skalarniSoucin(v1, v2));
    }

}
