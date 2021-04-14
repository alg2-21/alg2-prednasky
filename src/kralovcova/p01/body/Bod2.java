/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as free as you need to learn Java.
 *
 */
package kralovcova.p01.body;

/**
 * Trida Bod pro vytvareni objektu 
 * Objekt uchovava souradnice konkretniho bodu roviny
 * Jedna se o tridu menitelnych objektu
 * 
 * @author Jirina
 */
public class Bod2 {

    private double x;
    private double y;
    private double vzd;

    public Bod2(double x, double y) {
        this.x = x;
        this.y = y;
        prepocitej();
    }
    
    public Bod2(Bod2 b) {
        this.x = b.x;
        this.y = b.y;
        this.vzd = b.vzd;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
        prepocitej();
    }

    public void setY(double y) {
        this.y = y;
        prepocitej();
    }

    public double getVzd() {
        return vzd;
    }
    
    public double getVzd(Bod2 b) {
        return Math.hypot(x - b.x, y - b.y);
    }

    private void prepocitej() {
        vzd = Math.hypot(x, y);
    }
    
}
