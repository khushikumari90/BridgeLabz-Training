package data_serialization_for_backup;
import java.io.*;

class BackupProcessor {

    public static void backupObject(Object obj) {

        if (obj instanceof BackupSerializable) {
            try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("backup.dat"))) {

                out.writeObject(obj);
                System.out.println("Backup completed successfully");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Backup not allowed: Class not marked for backup");
        }
    }
}
