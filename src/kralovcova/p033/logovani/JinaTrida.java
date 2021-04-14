/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p033.logovani;

import java.util.logging.Logger;

/**
 *
 * @author Jirina
 */
public class JinaTrida {
    private int a;

    public JinaTrida(int a) {
        this.a = a;
        Logger.getLogger("Jiny logger").info("Vytvoreny objekt s hodnotou " + a);
    }

    public int getA() {
        Logger.getLogger("Jiny logger").info("Nekdo potrebuje moji hodnotu " + a);
        return a;
    }

    public void setA(int a) {
        Logger.getLogger("Jiny logger").info("Nekdo potrebuje zmenit moji hodnotu ");
        Logger.getLogger("Jiny logger").info("Puvodni hodnota je " + a);
        this.a = a;
        Logger.getLogger("Jiny logger").info("Nova hodnota je " + a);
    }
    
    
}
