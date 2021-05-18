/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p12.vlakna;

/**
 *
 * @author Jirina
 */
public class Casovac implements Runnable {

    public static interface EventHandler {
        public void handleTimerEvent();
    }

    private int interval;
    private EventHandler eventHandler;
    private Thread vlaknoCasovace;
    private long lastTime;

    public Casovac(int interval, EventHandler eventHandler) {
        this.interval = interval;
        this.eventHandler = eventHandler;
    }

    public void start() {
        lastTime = System.currentTimeMillis();
        vlaknoCasovace = new Thread(this);
        vlaknoCasovace.setDaemon(true);
        vlaknoCasovace.start();
    }

    public void stop() {
        vlaknoCasovace.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            long aktTime = System.currentTimeMillis();
            if ((aktTime - lastTime) >= interval) {
                eventHandler.handleTimerEvent();
                lastTime = aktTime;
            }
            try {
                Thread.sleep(interval / 5);
            } catch (InterruptedException ex) {
                System.out.println("Preruseni casovace, koncim");
                break;
            }
        }
    }
}

