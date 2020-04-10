package questionThread;

import java.util.ArrayList;
import java.util.List;

public class SeparateListSingleOrDouble implements Runnable {
    private List<Integer> tempArrayList;
    private List<Integer> singleArrayList = new ArrayList<>();
    private List<Integer> doubleArrayList = new ArrayList<>();


    private Object LOCK = new Object();

    private boolean running = true;

    public SeparateListSingleOrDouble(List<Integer> tempArrayList) {
        this.tempArrayList = tempArrayList;
        this.running = true;
    }

    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        while (this.running) {
            System.out.println(tempArrayList.size());
            String threadName = Thread.currentThread().getName();
            System.out.println("My summation " + threadName + " is started!");

            for (Integer item : tempArrayList) {
                if (item % 2 == 0) {
                    addListNewElement(doubleArrayList, item);
                } else {
                    addListNewElement(singleArrayList, item);
                }
            }

        }
    }

    synchronized void addListNewElement(List<Integer> addElementsList, Integer element) {
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
