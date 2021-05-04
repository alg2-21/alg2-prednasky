/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */

package kralovcova.p062.lokalizace;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class VicejazycnyProgram {

    private static final Scanner sc = new Scanner(System.in);
    private static ResourceBundle resPopisky= ResourceBundle.getBundle("kralovcova.p062.props.vjpres");
    private static ResourceBundle resPopiskyCZ = ResourceBundle.getBundle("kralovcova.p062.props.vjpres", 
            new Locale("cs", "CZ"));
    private static ResourceBundle resPopiskyEN = ResourceBundle.getBundle("kralovcova.p062.props.vjpres", 
            new Locale("en", "US"));
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // hlavni ridici smycka programu
        boolean konecProgramu = false;
        while (!konecProgramu) {
            // vypsat menu
            vypisHlavniMenuProgramu();
            // nacist volbu uzivatel
            int volbaUzivatele = nacistVolbu();
            // provest akci pozadovanou uzivatelem
            switch (volbaUzivatele) {
                case 0:
                    konecProgramu = true;
                    break;
                case 1:
                    obslouzitVolbuNovy();
                    break;
                case 2:
                    obslouzitVolbuOtevrit();
                    break;
                case 3:
                    obslouzitVolbuUlozit();
                    break;
                case 4:
                    obslouzitVolbuUlozitJako();
                    break;
                case 5:
                    resPopisky = resPopiskyCZ;
                    break;
                case 6:
                    resPopisky = resPopiskyEN;
                    break;
                default:
                    System.out.println(resPopisky.getString("info_chybna_volba"));
            }
        }
    }

    private static void vypisHlavniMenuProgramu() {
        System.out.println("");
        System.out.println(resPopisky.getString("app_title"));
        System.out.println(resPopisky.getString("mi_novy"));
        System.out.println(resPopisky.getString("mi_otevrit"));
        System.out.println(resPopisky.getString("mi_ulozit"));
        System.out.println(resPopisky.getString("mi_ulozit_jako"));
        System.out.println(resPopisky.getString("mi_cesky"));
        System.out.println(resPopisky.getString("mi_anglicky"));
        System.out.println(resPopisky.getString("mi_konec"));
    }

    private static int nacistVolbu() {
        int volba = -1;
        System.out.print(resPopisky.getString("menu_prompt"));
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

    private static void obslouzitVolbuNovy() {
        System.out.println("");
        System.out.println(resPopisky.getString("op_novy_soub"));
    }

    private static void obslouzitVolbuOtevrit() {
        System.out.println("");
        System.out.println(resPopisky.getString("op_nacteni"));
    }

    private static void obslouzitVolbuUlozit() {
        System.out.println("");
        System.out.println(resPopisky.getString("op_zapis_soub"));
    }

    private static void obslouzitVolbuUlozitJako() {
        System.out.println("");
        System.out.println(resPopisky.getString("op_zapis_kopie"));
    }
}
