/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p041.adresare;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 *
 * @author Jiřina Královcová
 */
public class VypisAdresare {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String jmAdr = System.getProperty("user.dir");

        System.out.println();
        System.out.println("Aktualni adresar ");
        System.out.println(jmAdr);

        // vypis 1 - list()
        System.out.println("Vypis obsahu adresare - metoda list() instance tridy File");
        File fAdr = new File(jmAdr);
        String[] fstrs = fAdr.list();
        for (String fstr : fstrs) {
            System.out.println(fstr);
        }

        System.out.println();
        System.out.println("Zadej jmeno adresare");
        jmAdr = sc.nextLine();
        fAdr = new File(jmAdr);
        if (!fAdr.isDirectory()) {
            System.out.println("Adresar zadaneho jmena neexistuje");
        } else {
            fAdr = fAdr.getCanonicalFile();
            System.out.println("Adresar ");
            System.out.println(fAdr.getName());
            System.out.println(fAdr.getPath());
            fAdr = new File(jmAdr);
            // vypis 2 - listFiles()
            System.out.println("Vypis obsahu adresare - metoda listFiles() instance tridy File");
            File[] ff = fAdr.listFiles();
            for (File f : ff) {
                System.out.format("%20s %s %n", f.getName(), f.isDirectory() ? " DIR" : " " + f.length() + " bytes");
            }

            // vypis 3 - listFiles() / filtrovany vypis
            System.out.println("");
            System.out.println("Vypis obsahu adresare - metoda listFiles() instance tridy File - filtrovany vypis");
            ff = fAdr.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory();
                }
            });
            for (File f : ff) {
                System.out.format("%14s %5s  %1s %n", "", "DIR", f.getName());
            }
            ff = fAdr.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isFile();
                }
            });
            for (File f : ff) {
                System.out.format("%14d bytes  %1s %n", f.length(), f.getName());
            }

            System.out.println("");
            System.out.println("Vypis obsahu adresare - pouziti metody list() tridy Files z baliku java.nio.file");
            Path pa = Paths.get(jmAdr);
            Stream<Path> list = Files.list(pa);
            Iterator<Path> it = list.iterator();
            while (it.hasNext()) {
                Path p = it.next();
                System.out.format("%19s  %1s %n",Files.isDirectory(p)?"DIR":Files.size(p) + " bytes", p.getFileName());
            }
            
            System.out.println("");
            System.out.println("Vypis obsahu adresare - pouziti metody walk(), max uroven 1, tridy Files z baliku java.nio.file");
            list = Files.walk(pa, 1);
            it = list.iterator(); 
            while (it.hasNext()) {
                Path p = it.next();
                System.out.format("%19s  %1s %n",Files.isDirectory(p)?"DIR":Files.size(p) + " bytes", p.getFileName());
            }
            
            System.out.println("");
            System.out.println("Vypis obsahu adresare - pouziti metody walkTree(), max uroven 2, tridy Files z baliku java.nio.file");
            Set<FileVisitOption> fvos = new TreeSet<>();
            //fvos.add(FileVisitOption.FOLLOW_LINKS);
            Path respath;
            respath = Files.walkFileTree(pa, fvos , 2, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("DIR  " + dir.getFileName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("    is here  " + file.getFileName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
            
        }

    }
}
