/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */
package kralovcova.p041.adresare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class ProstredkyTridyFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        File file;
        String jms;

        jms = System.getProperty("user.dir");
        //System.out.println(jms);
        file = new File(jms);
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalFile());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println();
        System.out.flush();

        jms = System.getProperty("user.home");
        //System.out.println(jms);
        file = new File(jms);
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalFile());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println();
        System.out.flush();

        jms = "e:\\data\\HU_Kurzy\\..\\a.txt";
        //System.out.println(jms);
        file = new File(jms);
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalFile());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println();

        jms = ".\\pas.dat";
        //System.out.println(jms);
        file = new File(jms);
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalFile());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println();

        ///*
        jms = "src";
        //System.out.println(jms);
        file = new File(jms);
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println();
        //*/

        ///*
        jms = "a.txt";
        //System.out.println(jms);
        file = new File(jms);
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println("Prejmenovani ");
        file.renameTo(new File("b.txt"));
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println();
        //*/

        ///*
        //jms = "E:\\nic\\neco\\necojineho";
        jms = "adr";
        System.out.println(jms);
        file = new File(jms);
        file.mkdir();
        //file.createNewFile();
        //*/

        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej soubor vcetne cesty ");
        jms = sc.nextLine();

        System.out.println(jms);
        file = new File(jms);
        file.createNewFile();
         */
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");

        jms = System.getProperty("user.dir");
        Path p = Paths.get(System.getProperty("user.dir"));
        System.out.println(p.getFileName());
        System.out.println(p.getFileSystem());
        System.out.println(p);
        System.out.println(p.normalize());
        System.out.println(p.getParent());
        System.out.println(p.getRoot());
        System.out.println(p.isAbsolute());
        System.out.println(Files.exists(p));
        for (Path q : p) {
            System.out.println(q);
        }

        Files.copy(p, p, REPLACE_EXISTING);

    }

}
