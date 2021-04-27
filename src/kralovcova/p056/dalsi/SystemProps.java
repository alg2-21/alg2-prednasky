/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p056.dalsi;

import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class SystemProps {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.list(System.out);
        
        System.out.println("");
        System.out.println("");
        System.out.println("file.encoding = " + System.getProperty("file.encoding"));
        System.out.println("sun.jnu.encoding = " + System.getProperty("sun.jnu.encoding"));   
        System.out.println("sun.stdout.encoding = " + System.getProperty("sun.stdout.encoding"));
        System.out.println("sun.stderr.encoding = " + System.getProperty("sun.stderr.encoding"));
        System.out.println("sun.desktop = " + System.getProperty("sun.desktop"));
    }

}
