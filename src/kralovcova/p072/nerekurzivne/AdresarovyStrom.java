/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p072.nerekurzivne;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *
 * @author Jirina
 */
public class AdresarovyStrom {
    
    /**
     * Nerekurzivni metoda - obalka pro privatni metodu
     * privatni metoda - rekurzivni nebo nerekurzivni implementace 
     * @param jmAdr 
     */
    static void vypisAdresare(String jmAdr) throws IOException {
        File fileAdr = new File(jmAdr);
        if (!fileAdr.isDirectory()) throw new IllegalArgumentException("Zadana cesta neni cestou k adresari " + 
                fileAdr.getPath());
        System.out.println("Rekurzivne");
        vypisAdresarovyStromRek(fileAdr.getCanonicalFile(), 0);
        
        System.out.println("");
        System.out.println("Nerekurzivne");
        VypisAdresarovyStromBezRek(fileAdr.getCanonicalFile(), 0);
    }

    private static void vypisAdresarovyStromRek(File file, int level) {
        for (int j = 1; j <= level; j++) {
            System.out.print('-');
        }
        System.out.println(file.getName());
        File[] ff = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File f = new File(dir, name); 
                return f.isDirectory() && !f.isHidden();
            }
        });
        if (ff == null) return;
        for (File f : ff) {
            vypisAdresarovyStromRek(f, level + 1);
        }
       
    }
    
    private static void VypisAdresarovyStromBezRek(File fileAdr, int baseLevel) {
        class DirWithLevel {
            File dir;
            int level;

            public DirWithLevel(File adr, int level) {
                this.dir = adr;
                this.level = level;
            } 
        }
        // fileAdr je adresar
        LinkedList<DirWithLevel> toDo = new LinkedList();
        toDo.add(new DirWithLevel(fileAdr, baseLevel)); // addFirst() // push()
        
        while (!toDo.isEmpty()) {
            DirWithLevel dirLevel = toDo.removeFirst(); // pop()
            for (int i = 0; i < dirLevel.level; i++){
                System.out.print("-");
            }
            System.out.println(dirLevel.dir.getName());
            File[] dirList = dirLevel.dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory();
                }
            });
            int level = dirLevel.level + 1;
            for (File dir : dirList) {
                toDo.addFirst(new DirWithLevel(dir, level)); // push()
            }
        }
    }
    
    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        vypisAdresare(".");
    }

    

}
