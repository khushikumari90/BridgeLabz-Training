package Stack_Queue_Hashmap_HashingFunction;
public class CircularTour {

    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    static int findStartingPoint(PetrolPump[] pumps) {
        int start = 0;
        int surplus = 0;
        int deficit = 0;

        for (int i = 0; i < pumps.length; i++) {
            surplus += pumps[i].petrol - pumps[i].distance;

            if (surplus < 0) {
                deficit += surplus;
                start = i + 1;
                surplus = 0;
            }
        }

        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };

        int result = findStartingPoint(pumps);
        System.out.println("Starting Pump Index: " + result);
    }
}

