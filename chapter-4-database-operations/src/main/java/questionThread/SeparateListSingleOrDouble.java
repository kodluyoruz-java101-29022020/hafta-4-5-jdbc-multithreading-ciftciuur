package questionThread;


import java.util.ArrayList;
import java.util.List;

public class SeparateListSingleOrDouble implements Runnable {
    private List<Integer> tempArrayList;
    static List<Integer> singleArrayList = new ArrayList<>();
    static List<Integer> doubleArrayList = new ArrayList<>();

    public SeparateListSingleOrDouble(List<Integer> tempArrayList) {
        this.tempArrayList = tempArrayList;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        System.out.println("My summation " + threadName + " is started!");

        synchronized (this) {
            for (int i = 0; i < tempArrayList.size(); i++) {
                if (tempArrayList.get(i) % 2 == 0) {
                    addListNewElement(doubleArrayList, tempArrayList.get(i));
                    System.out.println(tempArrayList.get(i) + " -> sayısı çift");
                } else {
                    addListNewElement(singleArrayList, tempArrayList.get(i));
                    System.out.println(tempArrayList.get(i) + " -> sayısı tek");
                }
                sleep(50);
            }
        }
    }

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void addListNewElement(List<Integer> addElementsList, Integer element) {
        addElementsList.add(element);
    }


}
