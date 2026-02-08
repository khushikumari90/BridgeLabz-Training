package thread_state_monitoring_system;
import java.time.LocalTime;
import java.util.*;

class StateMonitor extends Thread {

    private Thread[] threads;
    private Map<String, Set<Thread.State>> stateHistory = new HashMap<>();

    public StateMonitor(Thread[] threads) {
        this.threads = threads;
    }

    @Override
    public void run() {
        boolean allTerminated = false;

        while (!allTerminated) {
            allTerminated = true;

            for (Thread t : threads) {
                Thread.State state = t.getState();
                String time = LocalTime.now().toString();

                stateHistory
                        .computeIfAbsent(t.getName(), k -> new HashSet<>())
                        .add(state);

                System.out.println(
                        "[Monitor] " + t.getName() +
                        " is in " + state +
                        " state at " + time
                );

                if (state != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted");
            }

            System.out.println("--------------------------------");
        }

        printSummary();
    }

    private void printSummary() {
        System.out.println("\nSummary:");
        for (String threadName : stateHistory.keySet()) {
            System.out.println(
                threadName + " went through " +
                stateHistory.get(threadName).size() +
                " states"
            );
        }
    }
}
