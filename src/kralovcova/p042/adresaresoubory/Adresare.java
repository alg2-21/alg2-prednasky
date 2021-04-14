/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p042.adresaresoubory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class Adresare {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        File file = new File(System.getProperty("user.dir"));
        System.out.println(file.getName());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException ex) {
            System.out.println("Cestu k souboru nelze normalizovat");
        }
        
        //file.list();
        System.out.println("Vypis aktualniho adresare");
        File[] fs = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        }); 
        for (File f : fs){
            System.out.println("   <DIR>   " + f.getName());
        }
        fs = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        }); 
        for (File f : fs){
            System.out.println("           " + f.getName() + "  " + f.length() + " byte" );
        }
        
//        System.out.println("");
//        file = new File("abcd");
//        System.out.println(file.getName());
//        System.out.println(file.exists());
//        System.out.println(file.isDirectory());
//        System.out.println(file.getParent());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getCanonicalPath());
//        if (!file.exists()) {
//            System.out.println("Vytvarim adresar");
//            file.mkdir();
//        } else {
//            System.out.println("adresar na disku existuje");
//        }
        
        
//        System.out.println("");
//        file = new File("jhkjl/fgrt");
//        System.out.println(file.getName());
//        System.out.println(file.exists());
//        System.out.println(file.isDirectory());
//        System.out.println(file.getParent());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getCanonicalPath());
//        if (!file.exists()) {
//            System.out.println("Vytvarim adresar");
//            file.mkdirs();
//        } else {
//            System.out.println("adresar na disku existuje");
//        }
    }

    
}
