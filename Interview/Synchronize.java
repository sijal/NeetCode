public class Synchronize implements Runnable {
    @Override
    public void run() {
        incrementMe();
        unSynchronizedShowMe();
    }

    synchronized void incrementMe() {
        for (int i = 0; i <= 7; i++) {
            System.out.println(Thread.currentThread().getName() + " is printing : " +
                    i);
        }
    }

    void unSynchronizedShowMe() {
        System.out.println("unSynchronized : " + Thread.currentThread().getName());
        synchronized (this) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 5; i++)
                System.out.println("printing from synchronized block :" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Synchronize obj = new Synchronize();
        Thread threadOne = new Thread(obj, "Child One");
        Thread threadtwo = new Thread(obj, "Child two");
        threadOne.start();
        threadtwo.start();
    }
}