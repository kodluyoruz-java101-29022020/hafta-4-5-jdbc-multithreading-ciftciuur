package questionThread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SeparateListSingleOrDouble separateListSingleOrDouble = new SeparateListSingleOrDouble(fillArrayList().subList(10, 20));
        SeparateListSingleOrDouble separateListSingleOrDouble2 = new SeparateListSingleOrDouble(fillArrayList().subList(20, 30));
        SeparateListSingleOrDouble separateListSingleOrDouble3 = new SeparateListSingleOrDouble(fillArrayList().subList(40, 50));
        SeparateListSingleOrDouble separateListSingleOrDouble4 = new SeparateListSingleOrDouble(fillArrayList().subList(60, 70));

        Thread thread = new Thread(separateListSingleOrDouble);
        thread.start();
        Thread thread2 = new Thread(separateListSingleOrDouble2);
        thread2.start();
        Thread thread3 = new Thread(separateListSingleOrDouble3);
        thread3.start();
        Thread thread4 = new Thread(separateListSingleOrDouble4);
        thread4.start();



        /*
        int first = 0, second = 2500;
        for (int i = 0; i < 4; i++) {
            SeparateListSingleOrDouble separateListSingleOrDouble = new SeparateListSingleOrDouble(fillArrayList().subList(first, second));
            Thread thread = new Thread(separateListSingleOrDouble);
            thread.start();
            first += 2500;
            second += 2500;
        }*/

    }

    public static List<Integer> fillArrayList() {
        List<Integer> tempArray = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            tempArray.add(i + 1);
        }
        return tempArray;
    }
}
