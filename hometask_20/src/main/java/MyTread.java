public class MyTread extends Thread {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Hello from: " + thread.getName());
    }
}
