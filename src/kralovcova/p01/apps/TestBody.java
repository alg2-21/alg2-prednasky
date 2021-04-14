/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as free as you need to learn Java.
 *
 */
package kralovcova.p01.apps;

import kralovcova.p01.body.Bod;
import kralovcova.p01.body.Bod3;

/**
 * 
 * @author Jirina
 */
public class TestBody {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bod b, b2;
        b = new Bod(8., 9.);
        System.out.println(b.getX());
        b2 = new Bod(12., -7.3);
        System.out.println(b.getX());
        System.out.println(b2.getX());
        Bod3 b3;
        b3 = Bod3.getInstance(7, 4);
    }
    
}
