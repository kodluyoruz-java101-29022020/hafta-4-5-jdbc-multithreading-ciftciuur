package questionThread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        int first = 0, second = 2500;
        for (int i = 0; i < 4; i++) {
            SeparateListSingleOrDouble separateListSingleOrDouble = new SeparateListSingleOrDouble(fillArrayList().subList(first, second));
            Thread thread = new Thread(separateListSingleOrDouble);
            thread.start();
            first += 2500;
            second += 2500;
        }


    }

    public static List<Integer> fillArrayList() {
        List<Integer> tempArray = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            tempArray.add(i + 1);
        }
        return tempArray;
    }
}
