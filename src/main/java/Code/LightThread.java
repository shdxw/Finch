package Code;

import com.birdbraintechnologies.Finch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.stream.Collectors;

public class LightThread implements Runnable{
    Finch myFinch;
    Exchanger<List<Integer>> exchanger;

    public LightThread(Finch myFinch, Exchanger<List<Integer>> exchanger) {
        this.myFinch = myFinch;
        this.exchanger = exchanger;
    }

    @Override
    //в потоке считываем датчики и стопорим поток до прочтения данных в другом потоке
    public void run() {
        while (true) {
            try {
                exchanger.exchange(Arrays.stream(myFinch.getLightSensors()).boxed().collect(Collectors.toList()));
                System.out.println(exchanger.toString());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
