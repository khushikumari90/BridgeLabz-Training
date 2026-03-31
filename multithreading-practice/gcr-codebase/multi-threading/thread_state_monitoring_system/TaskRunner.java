package thread_state_monitoring_system;
class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            // Simulate computation (RUNNABLE)
            for (int i = 0; i < 1_000_000; i++) {
                Math.sqrt(i);
            }

            // Sleep (TIMED_WAITING)
            Thread.sleep(2000);

            // More computation (RUNNABLE)
            for (int i = 0; i < 1_000_000; i++) {
                Math.sqrt(i);
            }

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted");
        }
    }
}
