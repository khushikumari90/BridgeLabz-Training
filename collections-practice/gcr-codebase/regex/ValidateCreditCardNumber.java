package regex;
import java.util.Scanner;

public class ValidateCreditCardNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter card number: ");
        String card = sc.nextLine();

        String regex = "^(4|5)\\d{15}$";

        if (card.matches(regex)) {
            System.out.println("Valid Visa or MasterCard");
        } else {
            System.out.println("Invalid card number");
        }

        sc.close();
    }
}
