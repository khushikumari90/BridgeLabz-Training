package streams;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamExample {

    public static void main(String[] args) {

        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));

            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Writer Thread
class Writer implements Runnable {

    private PipedOutputStream pos;

    Writer(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread";

            for (char ch : message.toCharArray()) {
                pos.write(ch);
                Thread.sleep(100); // Simulates processing delay
            }

            pos.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Reader Thread
class Reader implements Runnable {

    private PipedInputStream pis;

    Reader(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }

            pis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
