package kralovcova.p031.vyjimky;

public class Obdelnik1 {

    double a, b;

    public Obdelnik1(double a, double b) {
        if (a < 0) {
            throw new IllegalArgumentException("Zaporna strana obdelnika " + a);
        }
        if (b < 0) {
            throw new IllegalArgumentException("Zaporna strana obdelnika " + b);
        }
        this.a = a;
        this.b = b;
        
    }

    // ...


}
