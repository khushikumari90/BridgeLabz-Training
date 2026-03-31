package m1_questions;
import java.util.*;

public class CorporateEmailAccessControl {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(validateEmail(arr[i]));
        }

        sc.close();
    }

    public static String validateEmail(String email) {

        if (email.contains(" ")) return "Access Denied";

        String regex = "^[a-z]{3,}\\.[a-z]{3,}[0-9]{4,}@(sales|marketing|IT|product)\\.company\\.com$";

        if (email.matches(regex)) {
            return "Access Granted";
        } else {
            return "Access Denied";
        }
    }
}