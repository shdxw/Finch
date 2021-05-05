package Code;

import com.birdbraintechnologies.Finch;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {
    Exchanger<List<Integer>> exchanger;

    public Main() {
        this.exchanger = new Exchanger<>();
        Finch myFinch = new Finch();
        new Thread(new LightThread(myFinch, exchanger)).start();
        new Thread(new MoveThread(myFinch, exchanger)).start();

    }

    public static void main(String[] args) throws InterruptedException {
        new Main();
        Thread.sleep(100000);
    }
}
