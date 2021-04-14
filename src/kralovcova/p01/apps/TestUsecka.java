/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p01.apps;

import kralovcova.p01.body.Bod;
import kralovcova.p01.body.Bod2;
import kralovcova.p01.geoms.Usecka;
import kralovcova.p01.geoms.Usecka2;

/**
 *
 * @author Jirina
 */
public class TestUsecka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bod a = new Bod(1, 1), b = new Bod(1, 6);
        Usecka u1 = new Usecka(a, b); // 5
        System.out.println(u1.getDelka());
        
        Bod2 p = new Bod2(0, 1), q = new Bod2(0, 4);
        Usecka2 u2 = new Usecka2(p, q); // delka 3
        System.out.println(u2.getDelka());
        q.setY(8);
        System.out.println(u2.getDelka());
    }
    
}
