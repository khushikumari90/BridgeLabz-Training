package sensitive_data_tagging;
public class SecurityApp {
    public static void main(String[] args) {

        CustomerCredentials credentials =
                new CustomerCredentials("khushi", "pass@123");

        ProductInfo product = new ProductInfo();

        EncryptionService.encryptIfSensitive(credentials); // encrypted
        EncryptionService.encryptIfSensitive(product);     // skipped
    }
}
