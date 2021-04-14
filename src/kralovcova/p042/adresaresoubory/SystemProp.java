
/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p042.adresaresoubory;

import java.util.Properties;
import java.util.Scanner;
/**
 *
 * @author Jirina
 */
public class SystemProp {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.list(System.out);
    }

}
