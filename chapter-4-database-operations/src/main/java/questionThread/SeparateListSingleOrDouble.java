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
                synchronized (LOCK) {
                    if (tempArrayList.get(i) % 2 == 0) {
                        addListNewElement(doubleArrayList, tempArrayList.get(i));
                    } else {
                        addListNewElement(singleArrayList, tempArrayList.get(i));
                    }
                }
                synchronized (LOCK) {
                    this.counter++;
                    if (counter == 10000) {
                        terminate();
                        break;
                    }
                }
            }
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
