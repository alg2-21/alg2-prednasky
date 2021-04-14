package kralovcova.p031.vyjimky;

public class Obdelnik2 {

    private double a, b;

    private Obdelnik2(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public static Obdelnik2 getInstance(double a, double b) {
        if (a < 0) {
            throw new ChybnyRozmerException("Zaporna strana obdelnika " + a);
        }
        if (b < 0) {
            throw new ChybnyRozmerException("Zaporna strana obdelnika " + b);
        }
        return new Obdelnik2(a, b);
    }

    // ...
}
