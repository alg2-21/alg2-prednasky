/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */package kralovcova.p058.zaznamyvsouboru;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Jirina
 */
public class ZaznamyApp {

    private static File souborZaznamu = null;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Collection a;
        Set s;
        int volba;
        boolean konecProgramu = false;

        do {
            vypisMenu();
            volba = nacteniVolby();
            // pri osetreni volby je nutne zohlednit "kontextovost volby'
            // neosetrovat volby 2 a dalsi v pripade, ze souborZaznamu == null
            switch (volba) {
                case 0:
                    konecProgramu = true;
                    break;
                case 1:
                    zadaniJmenaSouboru();
                    break;
                case 2:
                    pridaniZaznamu();
                    break;
                case 3:
                    vypisVsechZaznamu();
                    break;
                case 4:
                    odstraneniZaznamu();
                    break;
                case 5:
                    zmenaDatZaznamu();
                    break;
                default:
                    System.out.println("Chybne zadana volba");
            }
        } while (!konecProgramu);
    }

    /**
     * Kontextove menu
     */
    private static void vypisMenu() {
        System.out.println("");
        System.out.println("1. Zadani souboru");
        if (souborZaznamu != null) {
            System.out.println("2. Pridani zaznamu");
            // pokud soubor existuje
            System.out.println("3. Vypis zaznamu");
            System.out.println("4. Odstraneni zaznamu ");
            System.out.println("5. Zmena dat zaznamu");
        }
        System.out.println("0. Konec programu");

    }

    private static int nacteniVolby() {
        int volba = -1;
        System.out.print("Zadej zvolenou polozku menu: ");
        try {
            volba = sc.nextInt();
        } catch (InputMismatchException e) {
            // neplatna volba
            volba = -1;
        } finally {
            sc.nextLine();
        }
        return volba;
    }

    private static void zadaniJmenaSouboru() throws IOException {
        System.out.println("");
        System.out.print("Zadej jmeno souboru: ");
        String jm = sc.nextLine();
        // testovani existence cesty k souboru apod., pokud cesta existuje
        File cestaKSouboru = new File(jm).getCanonicalFile();
        try {
            if (cestaKSouboru.isFile()) {
                souborZaznamu = cestaKSouboru;
                System.out.println("Existujici soubor");
            } else if (cestaKSouboru.getParentFile().isDirectory()) {
                cestaKSouboru.createNewFile();
                souborZaznamu = cestaKSouboru;
                System.out.println("Novy soubor");
            }
        } finally {
            if (souborZaznamu == null) {
                System.out.println("Soubor neexistuje, nebylo mozne jej vytvorit");
                System.out.println("Cesta neexistuje, nebo neni mozne zapisovat do adresare apod.");
            }
        }
    }

    private static void pridaniZaznamu() throws IOException {
        System.out.println("");
        System.out.println("Pridani jednoho zaznamu do souboru");
        System.out.print("Zadej id a value: ");
        Zaznam data = new Zaznam(sc.nextShort(), sc.nextFloat());
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(souborZaznamu, true)))) {
            //try (RandomAccessFile dos = new RandomAccessFile(souborZaznamu, "rw")) {
            dos.writeShort(data.getId());
            dos.writeFloat(data.getValue());
        }
    }

    private static void vypisVsechZaznamu() throws IOException {
        System.out.println("");
        System.out.println("V souboru jsou tato data");
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(new FileInputStream(souborZaznamu)))) {
            //try (RandomAccessFile dis = new RandomAccessFile(souborZaznamu, "r")) {
            boolean konecSouboru = false;
            int poradi = 1;
            while (!konecSouboru) {
                try {
                    Zaznam data = new Zaznam(dis.readShort(), dis.readFloat());
                    System.out.format("%3d.  %s%n", poradi++, data);
                } catch (EOFException ex) {
                    konecSouboru = true;
                }
            }
        }
    }

    private static void odstraneniZaznamu() throws IOException {
        System.out.println("");
        System.out.println("Odstraneni zaznamu");
        System.out.print("Zadej poradi zaznamu");
        int poradi = sc.nextInt();
        // otevrit pro cteni i zapis
        try (RandomAccessFile raf = new RandomAccessFile(souborZaznamu, "rw")) {
            // premistit pred posledni zaznam
            raf.seek(raf.length() - Zaznam.DELKA_ZAZNAMU);
            // nactu posledni zaznam
            Zaznam posledniZaznam = new Zaznam(raf.readShort(), raf.readFloat());
            // premistim se pred odstranovany zaznam
            raf.seek((poradi - 1) * Zaznam.DELKA_ZAZNAMU);
            // zapisu to, co mam nacteno
            raf.writeShort(posledniZaznam.getId());
            raf.writeFloat(posledniZaznam.getValue());
            // zkratim soubor o jeden zaznam
            raf.setLength(raf.length() - Zaznam.DELKA_ZAZNAMU);
        }
    }

    private static void zmenaDatZaznamu() throws IOException {
        System.out.println("");
        System.out.println("Zmena hodnoty prirazene ke konkretnimu id");
        System.out.print("Zadej id zaznamu: ");
        short id = sc.nextShort();
        try (RandomAccessFile raf = new RandomAccessFile(souborZaznamu, "rw")) {
            Zaznam data = null;
            boolean konecSouboru = false;
            while (!konecSouboru) {
                try {
                    Zaznam pomData = new Zaznam(raf.readShort(), raf.readFloat());
                    if (pomData.getId() == id) {
                        data = pomData;
                        break;
                    }
                } catch (EOFException ex) {
                    konecSouboru = true;
                }
            }
            if (data == null) {
                System.out.println("Zaznam se zadanym id nebyl v souboru nalezen ");
                return;
            }
            System.out.println("Nalezeny zaznam: ");
            System.out.format("%s%n", data);
            System.out.print("Zadej novou hodnotu value: ");
            float value = sc.nextFloat();
            data.setValue(value);
            raf.seek(raf.getFilePointer() - Zaznam.DELKA_ZAZNAMU);
            raf.writeShort(data.getId());
            raf.writeFloat(data.getValue());
        } 

    }

}
