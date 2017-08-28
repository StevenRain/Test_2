package MutilThread;


import java.awt.*;
import java.util.Optional;

public class ThreadInterrupt {

    static class MouseThread implements Runnable {
        private int x;
        private int y;
        private static Object object = new Object();

        public MouseThread(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void run() {
            while (true) {
                if(Thread.currentThread().isInterrupted()) {
                    break;
                }
                synchronized (object) {
                    try{
                        Optional<Robot> robot = Optional.of(new Robot());
                        robot.ifPresent(r -> r.mouseMove(x, y));
                        System.out.println(String.format("current coordinate is X=%d, Y=%d", x, y));
                        wait(2000);
                    }catch (Exception e) {
                        System.out.println("Exception");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable r1 = new MouseThread(1, 1);
        Runnable r2 = new MouseThread(1, 20);
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
