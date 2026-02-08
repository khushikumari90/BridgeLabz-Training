package thread_state_monitoring_system;
public class ThreadStateMonitoringSystem {

    public static void main(String[] args) {

        TaskRunner task1 = new TaskRunner("Task-1");
        TaskRunner task2 = new TaskRunner("Task-2");

        Thread[] tasks = { task1, task2 };

        // NEW state observed here
        StateMonitor monitor = new StateMonitor(tasks);

        monitor.start();

        task1.start();
        task2.start();
    }
}
