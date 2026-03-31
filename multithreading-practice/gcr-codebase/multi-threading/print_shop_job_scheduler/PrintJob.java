package print_shop_job_scheduler;
class PrintJob implements Runnable {

    private String jobName;
    private int pages;
    private int priority;

    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    @Override
    public void run() {
        String priorityLabel;

        if (priority >= 7) {
            priorityLabel = "High Priority";
        } else if (priority >= 5) {
            priorityLabel = "Medium Priority";
        } else {
            priorityLabel = "Low Priority";
        }

        for (int i = 1; i <= pages; i++) {
            System.out.println("[" + priorityLabel + "] Printing "
                    + jobName + " - Page " + i + " of " + pages);

            try {
                Thread.sleep(100); // 100ms per page
            } catch (InterruptedException e) {
                System.out.println(jobName + " interrupted");
            }
        }

        System.out.println(jobName + " completed\n");
    }
}
