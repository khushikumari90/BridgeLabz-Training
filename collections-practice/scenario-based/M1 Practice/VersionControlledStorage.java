package m1_questions;
import java.util.*;

class Version {
    String version;
    int size;
    int order;

    Version(String version, int size, int order) {
        this.version = version;
        this.size = size;
        this.order = order;
    }
}

public class VersionControlledStorage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<Version>> storage = new HashMap<>();
        List<String> output = new ArrayList<>();
        int uploadOrder = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String operation = parts[0];

            if (operation.equals("UPLOAD")) {

                String file = parts[1];
                String version = parts[2];
                int size = Integer.parseInt(parts[3]);

                storage.putIfAbsent(file, new ArrayList<>());
                List<Version> versions = storage.get(file);

                boolean exists = false;

                for (Version v : versions) {
                    if (v.version.equals(version)) {
                        exists = true;
                        break;
                    }
                }

                if (!exists) {
                    versions.add(new Version(version, size, uploadOrder++));
                }

            } 
            else if (operation.equals("FETCH")) {

                String file = parts[1];

                if (!storage.containsKey(file)) {
                    output.add("File Not Found");
                    continue;
                }

                List<Version> versions = storage.get(file);

                versions.sort((a, b) -> {
                    if (a.size != b.size)
                        return a.size - b.size;
                    return a.version.compareTo(b.version);
                });

                for (Version v : versions) {
                    output.add(file + " " + v.version + " " + v.size);
                }

            } 
            else if (operation.equals("LATEST")) {

                String file = parts[1];

                if (!storage.containsKey(file)) {
                    output.add("File Not Found");
                    continue;
                }

                List<Version> versions = storage.get(file);

                Version latest = versions.get(0);
                for (Version v : versions) {
                    if (v.order > latest.order) {
                        latest = v;
                    }
                }

                output.add(file + " " + latest.version + " " + latest.size);
            } 
            else if (operation.equals("TOTAL_STORAGE")) {

                String file = parts[1];

                if (!storage.containsKey(file)) {
                    output.add("File Not Found");
                    continue;
                }

                int total = 0;

                for (Version v : storage.get(file)) {
                    total += v.size;
                }

                output.add(file + " " + total);
            }
        }

        // print output at the end
        for (String s : output) {
            System.out.println(s);
        }

        sc.close();
    }
}