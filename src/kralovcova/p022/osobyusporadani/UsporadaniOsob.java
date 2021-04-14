/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p022.osobyusporadani;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jirina
 */
public class UsporadaniOsob {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Osoba[] osobyA = new Osoba[3]; 
        osobyA[0] = new Osoba(180, 61, 35);
        osobyA[1] = new Osoba(163, 76, 43);
        osobyA[2] = new Osoba(189, 97, 21);
        
        
        vypisOsoby(osobyA);
        
        Arrays.sort(osobyA);
        System.out.println("");
        vypisOsoby(osobyA);
        
        Arrays.sort(osobyA, Osoba.COMP_DLE_VYSKY);
        System.out.println("");
        vypisOsoby(osobyA);
        
        Arrays.sort(osobyA, Osoba.COMP_DLE_VAHY);
        System.out.println("");
        vypisOsoby(osobyA);
        
        List<Osoba> osobyL;
        
        osobyL = new ArrayList<>();
        osobyL = new LinkedList<>();
        
        osobyL.add(new Osoba(180, 61, 35));
        osobyL.add(new Osoba(163, 76, 43));
        Collections.sort(osobyL);
        Collections.sort(osobyL,  Osoba.COMP_DLE_VAHY);
        osobyL.sort(Osoba.COMP_DLE_VAHY);
        
        Comparable<Osoba> os = new Osoba(45, 48, 78);
        //
        if (os instanceof Osoba) {
            System.out.println(((Osoba)os).getVaha());
        }
        if (os instanceof Comparator){
            
        }
    }

    private static void vypisOsoby(Osoba[] osoby) {
        for (Osoba os : osoby)
            System.out.println(os);
    }

}
