/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p057.objekty;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class ZapisObjektu {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String adr = ".";//"data";
        String soub = "st.obj";
        File filepath = new File(adr, soub); 
        
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filepath))) {
            oos.writeObject(new Osoba("Jan", "Palec"));
            oos.writeObject(new Osoba("Dan", "Malec"));
            oos.writeObject(new Osoba("Jiri", "Fik"));
        }
        

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filepath))) {
            boolean konec = false;
            while (!konec) {
                try {
                    Object obj = ois.readObject();
                    System.out.println(obj);
                    if (obj instanceof Osoba) {
                        Osoba os = (Osoba) obj;
                        // 
                    }
                } catch (EOFException ex) {
                    konec = true;
                }
            }
        }
    }

}
