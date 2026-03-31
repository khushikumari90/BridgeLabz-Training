package sensitive_data_tagging;
class EncryptionService {

    public static void encryptIfSensitive(Object obj) {

        if (obj instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data before storage...");
            // encryption logic here
        } else {
            System.out.println("No encryption needed");
        }
    }
}
