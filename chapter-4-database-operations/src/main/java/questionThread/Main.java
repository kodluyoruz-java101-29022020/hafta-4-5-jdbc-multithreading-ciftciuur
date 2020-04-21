package questionThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            SeparateListSingleOrDouble separateListSingleOrDouble = new SeparateListSingleOrDouble();
            threadPoolExecutor.execute(separateListSingleOrDouble);
        }
        threadPoolExecutor.shutdown();
    }
}
