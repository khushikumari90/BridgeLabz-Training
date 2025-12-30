//Write a program to generate a six-digit OTP number using Math.random() method. Validate the numbers are unique by generating the OTP number 10 times and ensuring all the 10 OTPs are not the same
package methods;
public class OTP {

	public static void main(String[] args) {
		int[] otpArray = new int[10];

        // Generate OTPs 10 times
        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
        }

        // Display generated OTPs
        System.out.println("Generated OTPs:");
        for (int otp : otpArray) {
            System.out.println(otp);
        }

        // Validate uniqueness
        if (areOTPsUnique(otpArray)) {
            System.out.println("\nAll generated OTPs are UNIQUE ✅");
        } else {
            System.out.println("\nDuplicate OTP found ❌");
        }
	}

    // Method to generate a 6-digit OTP using Math.random()
    public static int generateOTP() {
        // Generates numbers from 100000 to 999999
        return (int) (Math.random() * 900000) + 100000;
    }

    // Method to check whether all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {

        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false; // duplicate found
                }
            }
        }
        return true; // all OTPs are unique
    }



}
