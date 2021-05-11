/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p091.vlakna;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CasNaPozadi {
    
    /*
    * Trida vlaken odvozena od tridy Thread
    * Kazda instance uchovava svoje cislo a casovy interval na který se uspí
    */
    private static class VypisCasu extends Thread {
        
        private int interval;
        private long lastTime;

        public VypisCasu(int cislo, int interval) {
            super("Vlakno " + cislo);
            this.interval = interval;
            lastTime = System.currentTimeMillis();
        }
        
        @Override
        public void run() {
            //super.run(); 
            
            for (int i = 0; i < 10; i++) {
                System.out.format("%s %d : cinnost %d ms %n", this.getName(), i, System.currentTimeMillis()-lastTime);
                try {
                    sleep(interval);
                } catch (InterruptedException ex) {
                    System.out.println("Probuzeni vlakna " + getName());
                }
            }
        }
        
    }

    /* 
    * Vytvareni vlaken odvozenych primo od tridy Thread
    */
    public static void main(String[] args) {
        VypisCasu vl1 = new VypisCasu(1, 200);
        VypisCasu vl2 = new VypisCasu(2, 400);
        
        vl2.setDaemon(true);
        
        vl1.start();
        vl2.start();
    }
    
}
