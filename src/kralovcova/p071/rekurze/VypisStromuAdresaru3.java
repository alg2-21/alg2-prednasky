/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */

package kralovcova.p071.rekurze;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 *
 * @author Jirina
 */
public class VypisStromuAdresaru3 {

    private static String getAdrsTreeAsString(File adr, int level) throws IOException {
        StringBuilder s = new StringBuilder("");

        for (int i = 0; i < level; i++) {
            s.append("-");
        }
        s.append(adr.getName()).append("\n");

        File[] ff = adr.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        if (ff != null && ff.length > 0) {
            for (File f : ff) {
                s.append(getAdrsTreeAsString(f, level + 1));
            }
        }
        return s.toString();
    }

    public static String getAdrsTreeAsString(String adr) throws IOException {
        File f = new File(adr);
        if (!f.isDirectory()) {
            throw new IllegalArgumentException("Chybne zadany adresar " + f.getAbsolutePath());
        }
        return f.getCanonicalFile().getAbsolutePath() + 
                String.format("%n") + 
                getAdrsTreeAsString(f, 0);
    }

    private static void printAdrsTree(File adr, int level) throws IOException {

        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(adr.getName());

        File[] ff = adr.listFiles((File pathname) -> pathname.isDirectory());
        if (ff == null || ff.length == 0) {
            return;
        }
        for (File f : ff) {
            printAdrsTree(f, level + 1);
        }
    }

    public static void printAdrsTree(String adr) throws IOException {
        File f = new File(adr);
        if (!f.isDirectory()) {
            throw new IllegalArgumentException("Chybne zadany adresar " + f.getAbsolutePath());
        }
        System.out.println(f.getCanonicalFile().getAbsolutePath());
        printAdrsTree(f, 0);
    }

    public static void main(String[] args) throws IOException {
        try {
            System.out.println("");
            System.out.println("");
            System.out.println("Existujici adresar - primy vypis");
            printAdrsTree("src");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("");
            System.out.println("");
            System.out.println("Existujici adresar - vypis vysledneho textoveho retezce");
            System.out.println(getAdrsTreeAsString("."));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("");
            System.out.println("");
            System.out.println("Existujici adresar - vypis vysledneho textoveho retezce");
            System.out.println(getAdrsTreeAsString(".."));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
         try {
            System.out.println("");
            System.out.println("");
            System.out.println("Neexistujici adresar");
            printAdrsTree("aaa");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
