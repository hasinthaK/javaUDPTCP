package khk.interview;

public class ThreadImplemented implements Runnable {
    String thraedname;

    public ThreadImplemented(String str) {
        thraedname = str;
    }

    public void run() {
        System.out.println(thraedname + " hello");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("quitting: " + thraedname);
    }
}