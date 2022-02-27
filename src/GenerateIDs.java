import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class GenerateIDs {
    public static void main(String[] args) {
        Thread randomIDs = new Thread(new RandomIDs());
        Thread sortIDs = new Thread(new SortIDs());

        sortIDs.start();
        randomIDs.start();
    }
}

class RandomIDs implements Runnable {
    Random id = new Random();
    @Override
    public void run() {
        while(true) {
            IDs.addID(id.nextInt(101));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SortIDs implements Runnable {

    @Override
    public void run() {
        while(true) {
            IDs.sortIDs();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class IDs {
    static ArrayList<Integer> ids = new ArrayList<Integer>();

    synchronized static void addID(int id) {
        ids.add(id);
    }

    synchronized static void sortIDs() {
        Collections.sort(ids, Collections.reverseOrder());
        System.out.println(ids);
    }
}