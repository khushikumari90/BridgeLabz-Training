package file_backup_scheduler;
import java.util.PriorityQueue;

public class FileBackupScheduler {

    private PriorityQueue<BackupTask> backupQueue = new PriorityQueue<>();

    // Schedule a backup
    public void scheduleBackup(String path, int priority)
            throws InvalidBackupPathException {

        if (path == null || path.trim().isEmpty()) {
            throw new InvalidBackupPathException("Backup path cannot be empty!");
        }

        backupQueue.add(new BackupTask(path, priority));
        System.out.println(" Backup scheduled for: " + path);
    }

    // Execute backups in priority order
    public void executeBackups() {
        System.out.println("\n Executing Backup Tasks:");

        while (!backupQueue.isEmpty()) {
            BackupTask task = backupQueue.poll();
            System.out.println(" Backing up: " + task);
        }
    }

    // Main Method
    public static void main(String[] args) {

        FileBackupScheduler scheduler = new FileBackupScheduler();

        try {
            scheduler.scheduleBackup("/system/config", 3);   // critical
            scheduler.scheduleBackup("/user/documents", 1);
            scheduler.scheduleBackup("/logs", 2);

            // Invalid path
            scheduler.scheduleBackup("", 5);

        } catch (InvalidBackupPathException e) {
            System.out.println("❗ " + e.getMessage());
        }

        scheduler.executeBackups();
    }
}

