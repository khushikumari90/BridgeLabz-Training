package data_serialization_for_backup;
import java.io.Serializable;

class UserData implements BackupSerializable, Serializable {

    private int id;
    private String name;

    UserData(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
