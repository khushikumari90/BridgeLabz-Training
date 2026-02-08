package download_manager;
import java.util.Random;

class FileDownloaderRunnable implements Runnable {
    private String fileName;
    private Random random = new Random();

    public FileDownloaderRunnable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            for (int progress = 0; progress <= 100; progress += 25) {
                Thread.sleep(500 + random.nextInt(500));
                System.out.println("[" + Thread.currentThread().getName() +
                        "] Downloading " + fileName + ": " + progress + "%");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

