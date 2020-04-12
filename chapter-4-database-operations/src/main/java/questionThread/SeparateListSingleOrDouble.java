package questionThread;


import java.util.ArrayList;
import java.util.List;

public class SeparateListSingleOrDouble implements Runnable {
    private List<Integer> tempArrayList;
    private List<Integer> singleArrayList = new ArrayList<>();
    private List<Integer> doubleArrayList = new ArrayList<>();
    private Object LOCK = new Object();
    private int counter = 0;

    private boolean running = true;

    public SeparateListSingleOrDouble(List<Integer> tempArrayList) {
        this.tempArrayList = tempArrayList;
        this.running = true;
    }

    public void terminate() {
        this.running = false;
    }

    @Override
    public void run() {
        while (this.running) {
            String threadName = Thread.currentThread().getName();
            System.out.println("My summation " + threadName + " is started!");


            for (int i = 0; i < tempArrayList.size(); i++) {
                System.out.println("Sayı alındı");
                if (tempArrayList.get(i) % 2 == 0) {
                    addListNewElement(doubleArrayList, tempArrayList.get(i));
                    System.out.println(tempArrayList.get(i) + " -> sayısı çift");
                } else {
                    addListNewElement(singleArrayList, tempArrayList.get(i));
                    System.out.println(tempArrayList.get(i) + " -> sayısı tek");
                }
                System.out.println("Sayı gönderildi -> " + tempArrayList.get(i));
                sleep(50);
                counter++;
            }
            if (counter == 70) {
                System.out.println("DURMASI GEREKIYORR !!");
                terminate();
                break;
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

    public List<Integer> getSingleArrayList() {
        return singleArrayList;
    }

    public void setSingleArrayList(List<Integer> singleArrayList) {
        this.singleArrayList = singleArrayList;
    }

    public List<Integer> getDoubleArrayList() {
        return doubleArrayList;
    }

    public void setDoubleArrayList(List<Integer> doubleArrayList) {
        this.doubleArrayList = doubleArrayList;
    }


}
