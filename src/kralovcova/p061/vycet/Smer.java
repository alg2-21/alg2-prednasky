/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */

package kralovcova.p061.vycet;

/**
 *
 * @author Jirina
 */
public enum Smer {

    SEVER(0, 1), ZAPAD(-1, 0), JIH(0, -1), VYCHOD(1, 0);
    
    private int dx;
    private int dy;
    
    private Smer(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
    
    public int[] getDPos() {
        return new int[]{dx, dy};
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}
