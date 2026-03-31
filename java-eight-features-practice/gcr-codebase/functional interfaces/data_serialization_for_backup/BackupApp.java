package data_serialization_for_backup;
public class BackupApp {
    public static void main(String[] args) {

        UserData user = new UserData(1, "Khushi");
        TempCacheData temp = new TempCacheData();

        BackupProcessor.backupObject(user); // Allowed
        BackupProcessor.backupObject(temp); // Not allowed
    }
}
