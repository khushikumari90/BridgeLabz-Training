package list_interface;
import java.util.*;
public class FrequencyCount {
    public static void main(String[] args) {

        List<String> list = Arrays.asList(
                "apple", "banana", "apple", "orange"
        );

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : list) {
            if (frequencyMap.containsKey(item)) {
                frequencyMap.put(item, frequencyMap.get(item) + 1);
            } else {
                frequencyMap.put(item, 1);
            }
        }

        System.out.println(frequencyMap);
    }
}
