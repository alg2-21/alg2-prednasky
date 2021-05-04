/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */

package kralovcova.p071.rekurze;

public class Vez {

    private int vyska;
    private int maxVyska;
    private int[] disky;
    private String titul;

    public Vez(String s, int mv) {
        this.titul = s;
        this.maxVyska = mv;
        this.disky = new int[mv];
        this.vyska = 0;
    }

    public Vez(String s, int mv, int v) {
        this.titul = s;
        this.maxVyska = mv;
        this.disky = new int[mv];
        this.vyska = v;
        for (int i = 0; i < v; i++) {
            disky[i] = v - i;
        }
    }

    public void pridejDisk(int cd)  {
        if (this.vyska >= this.maxVyska) {
            throw new UnsupportedOperationException("Pokus o pridani disku na plnou vez!");
            
        } else {
            if (this.vyska > 0) {
                if (cd >= this.disky[this.vyska - 1]) {
                    throw new UnsupportedOperationException("Pokus o polozeni vetsiho disku na mensi!");
                } else {
                    this.disky[this.vyska] = cd;
                    this.vyska++;
                }
            } else {
                this.disky[this.vyska] = cd;
                this.vyska++;
            }
        }
    }

    public int odeberDisk() {
        if (this.vyska <= 0) {
            throw new UnsupportedOperationException("Pokus o odebrani disku z prazdne veze!");
        } else {
            this.vyska--;
            return this.disky[this.vyska];
        }
    }

    @Override
    public String toString() {
        String s = this.titul + "(";
        for (int i = 0; i < this.maxVyska; i++) {
            if (i < this.vyska) {
                s = s + String.format("%2d", disky[i]);
            } else {
                s = s + String.format(" -");
            }
        }
        s = s + ")";
        return s;
    }
}
