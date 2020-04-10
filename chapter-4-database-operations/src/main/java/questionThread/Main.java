package questionThread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SeparateListSingleOrDouble first = new SeparateListSingleOrDouble(fillArrayList().subList(0, 2500));

        Thread firstArray = new Thread(first);
        firstArray.start();
        System.out.println(first.getDoubleArrayList().size());
        System.out.println(first.getSingleArrayList().size());
    }

    public static List<Integer> fillArrayList() {
        List<Integer> tempArray = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            tempArray.add(i + 1);
        }
        return tempArray;
    }
}
