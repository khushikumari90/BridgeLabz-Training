package functional_interface;
public class BackgroundJobExecution {

    public static void main(String[] args) {

        // Runnable task using lambda
        Runnable backgroundTask = () -> {
            System.out.println("Background job started...");
            try {
                Thread.sleep(2000); // simulate long task
            } catch (InterruptedException e) {
                System.out.println("Task interrupted");
            }
            System.out.println("Background job finished.");
        };

        // Run task asynchronously
        Thread workerThread = new Thread(backgroundTask);
        workerThread.start();

        System.out.println("Main thread continues execution...");
    }
}
