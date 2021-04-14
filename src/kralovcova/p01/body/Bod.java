/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as free as you need to learn Java.
 *
 */
package kralovcova.p01.body;

/**
 * Trida reprezentujici bod roviny
 * Objekt uchovava konkretni bod roviny dany kartezskymi souradnicemi x, y
 * Jedna se o tridu nemenitelnych/konstantnich objektu
 * 
 * @author Jirina
 */
public class Bod {
    //private final double x;
    //private final double y;
    private final double[] sour;
    private final double vzd;

    /**
     * Vytvori objekt tridy Bod
     * @param x
     * @param y 
     */
    public Bod(double x, double y) {
        //this.x = x;
        //this.y = y;
        this.sour = new double[]{x, y};
        this.vzd = Math.hypot(x, y);
    }
    
    /**
     * Poskytne x souradnici body
     * @return x souradnice bodu
     */
    public double getX() {
        return sour[0];//x;
    }

    /**
     * Poskytne y souradnici body
     * @return y souradnice bodu
     */
    public double getY() {
        return sour[1];//y;
    }
    
    /**
     * poskytne vzdalenost bodu od pocatku
     * @return vzdalenost bodu od pocatku jako hodnotu typu double
     */
    public double getVzd(){
        return vzd;
    }
     
}
