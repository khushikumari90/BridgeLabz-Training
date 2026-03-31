package m1_questions;
import java.util.*;

public class DynamicTemplateProcessor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<String> output = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            String line = sc.nextLine();

            while(line.contains("${")) {

                int start = line.indexOf("${");
                int end = line.indexOf("}", start);

                String placeholder = line.substring(start + 2, end);
                String[] parts = placeholder.split(":");

                String type = parts[0];
                String value = parts[1];
                String result = "INVALID";

                try {

                    if(type.equals("UPPER")) {
                        result = value.toUpperCase();
                    }

                    else if(type.equals("LOWER")) {
                        result = value.toLowerCase();
                    }

                    else if(type.equals("DATE")) {

                        String[] d = value.split("-");

                        if(Integer.parseInt(d[0]) > 31 || Integer.parseInt(d[1]) > 12)
                            result = "INVALID";
                        else
                            result = d[2] + "/" + d[1] + "/" + d[0];
                    }

                    else if(type.equals("REPEAT")) {

                        String[] r = value.split(",");
                        String word = r[0];
                        int count = Integer.parseInt(r[1]);

                        String temp = "";

                        for(int j = 0; j < count; j++)
                            temp += word;

                        result = temp;
                    }

                } catch(Exception e) {
                    result = "INVALID";
                }

                line = line.substring(0, start) + result + line.substring(end + 1);
            }

            output.add(line);
        }

        for(String s : output)
            System.out.println(s);

        sc.close();
    }
}