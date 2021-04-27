/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p058.zaznamyvsouboru;

/**
 *
 * @author Jirina
 */
public class Zaznam implements Comparable<Zaznam>{
    public static int DELKA_ZAZNAMU = Short.BYTES + Float.BYTES; 
    private final short id;
    private float value;

    public Zaznam(short id, float value) {
        this.id = id;
        this.value = value;
    }

    public short getId() {
        return id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return String.format("%5d  %8.2f", id, value);
    }

    @Override
    public int compareTo(Zaznam o) {
        return id - o.id;
    }
    
}
