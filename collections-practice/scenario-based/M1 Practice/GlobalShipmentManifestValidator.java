package m1_questions;

import java.util.*;

public class GlobalShipmentManifestValidator {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();

		String arr[] = new String[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLine();
		}

		for (int i = 0; i < n; i++) {

			String split[] = arr[i].split("\\|");

			String shipCode = split[0];
			String date = split[1];
			String mode = split[2];
			String weightStr = split[3];
			String status = split[4];

			String d[] = date.split("-");

			int year = Integer.parseInt(d[0]);
			int month = Integer.parseInt(d[1]);
			int day = Integer.parseInt(d[2]);

			System.out.println(validateShipmentRecord(shipCode, year, month, day, mode, weightStr, status));

		}
	}

	public static String validateShipmentRecord(String shipCode, int year, int month, int day, String mode,
			String weightStr, String status) {

		// Shipment code
		if (!shipCode.matches("^SHIP-(?!.*(\\d)\\1{3})[1-9][0-9]{5}$"))
			return "NON-COMPLIANT RECORD";

		// Year
		if (year < 2000 || year > 2099)
			return "NON-COMPLIANT RECORD";

		// Month
		if (month < 1 || month > 12)
			return "NON-COMPLIANT RECORD";

		// Leap year check
		int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
			days[1] = 29;

		if (day < 1 || day > days[month - 1])
			return "NON-COMPLIANT RECORD";

		// Mode check
		if (!(mode.equals("AIR") || mode.equals("SEA") || mode.equals("ROAD") || mode.equals("RAIL")
				|| mode.equals("EXPRESS") || mode.equals("FREIGHT")))
			return "NON-COMPLIANT RECORD";

		// Weight
		if (!weightStr.matches("^(0|[1-9]\\d{0,5})(\\.\\d{1,2})?$"))
			return "NON-COMPLIANT RECORD";

		double weight = Double.parseDouble(weightStr);

		if (weight < 0 || weight > 999999.99)
			return "NON-COMPLIANT RECORD";

		// Delivery Status
		if (!(status.equals("DELIVERED") || status.equals("CANCELLED") || status.equals("IN_TRANSIT")))
			return "NON-COMPLIANT RECORD";

		return "COMPLIANT RECORD";
	}
}