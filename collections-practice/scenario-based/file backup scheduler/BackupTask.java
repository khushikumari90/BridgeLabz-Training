package file_backup_scheduler;

public class BackupTask implements Comparable<BackupTask> {

    private String folderPath;
    private int priority; // Higher value = higher priority

    public BackupTask(String folderPath, int priority) {
        this.folderPath = folderPath;
        this.priority = priority;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(BackupTask other) {
        // Higher priority tasks executed first
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "BackupTask [Path=" + folderPath + ", Priority=" + priority + "]";
    }
}
