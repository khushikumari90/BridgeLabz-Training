package FutureLogistics;

public class Utility {

    public boolean validateTransportId(String transportId) {
        return transportId.matches("RTS[0-9]{3}[A-Z]");
    }

    public GoodsTransport parseDetails(String input) {
        String[] data = input.split(":");

        String transportId = data[0];

        if (!validateTransportId(transportId)) {
            System.out.println("Transport id " + transportId + " is invalid");
            System.out.println("Please provide a valid record");
            return null;
        }

        String date = data[1];
        int rating = Integer.parseInt(data[2]);
        String type = data[3];

        if (type.equalsIgnoreCase("BrickTransport")) {
            return new BrickTransport(
                    transportId, date, rating,
                    Float.parseFloat(data[4]),
                    Integer.parseInt(data[5]),
                    Float.parseFloat(data[6]));
        } else {
            return new TimberTransport(
                    transportId, date, rating,
                    Float.parseFloat(data[4]),
                    Float.parseFloat(data[5]),
                    data[6],
                    Float.parseFloat(data[7]));
        }
    }

    public String findObjectType(GoodsTransport gt) {
        if (gt instanceof TimberTransport)
            return "TimberTransport";
        else
            return "BrickTransport";
    }
}
