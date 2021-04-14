/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p033.logovani;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

/**
 *
 * @author Jirina
 */
public class LogovaniProgramu {

    private static Scanner sc = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(PropojeniGrafu.class.getName());
    
    //private static Logger loggerJT = Logger.getLogger("Jiny logger");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        logger.setUseParentHandlers(false);
        logger.addHandler(new StreamHandler(System.out, new SimpleFormatter()));
        logger.addHandler(new FileHandler("log.log", true));
        logger.addHandler(new StreamHandler(new FileOutputStream("jinylog.log"), new SimpleFormatter()));
        
        //loggerJT.addHandler(new StreamHandler(new FileOutputStream("jinaTridaLog.log", true), new SimpleFormatter()));
        
        logger.info("Spusteni definice a sledovani propojeni grafu");
        
        try {
            System.out.println("Zadej pocet uzlu ");
            short n = sc.nextShort();
            System.out.println("Zadana hodnota" + n);
            PropojeniGrafu pg = new PropojeniGrafu(n);
            short p, q;
            System.out.println("Zadej hranu");
            while ((p = sc.nextShort()) > 0) {
                q = sc.nextShort();
                pg.pridejHranu(p, q);
                System.out.println("Zadej hranu");
            } while (p > 0);
        } catch (IllegalArgumentException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            //logger.info(ex.getMessage());
        }
        logger.info("Ukoncena cinnost s grafem");
        
        
//        loggerJT.info("Zahajeni cinnosti");
//        System.out.println("");
//        System.out.println("Manipulace s jinou tridou ");
//        JinaTrida jt = new JinaTrida(7);
//        System.out.println(jt.getA());
//        jt.setA(29);
//        System.out.println(jt.getA());
//        loggerJT.info("Ukonceni cinnosti");
    }

}
