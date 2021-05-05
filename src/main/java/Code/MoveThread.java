package Code;

import com.birdbraintechnologies.Finch;

import java.util.List;
import java.util.concurrent.Exchanger;

public class MoveThread implements Runnable {
    private Finch myFinch;
    private Exchanger<List<Integer>> exchanger;
    private List<Integer> listOfLights;

    public MoveThread(Finch myFinch, Exchanger<List<Integer>> exchanger) {
        this.myFinch = myFinch;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            try {
                listOfLights = exchanger.exchange(null); //get(0) левый, get(1) правый сенсоры
                System.out.println(listOfLights);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int left_light = listOfLights.get(0);
            int right_light = listOfLights.get(1);

            //эту хуйню убрать и сделать функции поворота и движения в зависимости от данных с датчиков
            //но в целом принцип типо такого (значения датчиков около 10 вечером с тусклым светом, днем где-то 40 будет)
            if (left_light > 100 || right_light > 100) {

                if (left_light > right_light) {

                    myFinch.setWheelVelocities(0, 100);

                } else {
                    myFinch.setWheelVelocities(100, 0);

                }
            }

        }
    }
}
