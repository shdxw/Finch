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
        int turn_light = 75; //параметр для поворота
        int move_light = 75; //параметр для езды

        while (true) {
            try {
                listOfLights = exchanger.exchange(null);
                System.out.println(listOfLights);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int left_light = listOfLights.get(0);
            int right_light = listOfLights.get(1);

            if (Math.abs(left_light - right_light) >= turn_light ) {

                if (left_light > right_light) {

                    myFinch.setWheelVelocities(-255, 255, 100);

                } else {
                    myFinch.setWheelVelocities(255, -255, 100);

                }
            } else if (left_light >= move_light || right_light >= move_light) {

                myFinch.setWheelVelocities(255, 255, 100);

            }


        }
    }
}
