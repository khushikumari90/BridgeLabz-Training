package sensitive_data_tagging;
import java.io.Serializable;

class CustomerCredentials implements SensitiveData, Serializable {

    private String username;
    private String password;

    CustomerCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
