package m1_questions;
import java.util.*;

class Student {
    String name, dept;
    int q1, q2, q3;

    Student(String name, String dept, int q1, int q2, int q3) {
        this.name = name;
        this.dept = dept;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    int total() {
        return q1 + q2 + q3;
    }
}

public class QuizPerformanceRanking {

    static List<Student> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] input = new String[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            List<String> res = process(input[i]);
            for (String s : res) {
                System.out.println(s);
            }
        }

        sc.close();
    }

    public static List<String> process(String str) {
        List<String> output = new ArrayList<>();
        String[] parts = str.split(" ");

        if (parts[0].equals("Record")) {
            String name = parts[1];
            String dept = parts[2];
            int q1 = Integer.parseInt(parts[3]);
            int q2 = Integer.parseInt(parts[4]);
            int q3 = Integer.parseInt(parts[5]);

            list.add(new Student(name, dept, q1, q2, q3));
            output.add("Record Added: " + name);
        } else {
            if (list.size() == 0) {
                output.add("No Records Available");
                return output;
            }

            if (parts[1].equals("Engineering") || parts[1].equals("Electronics")) {
                output.addAll(topDepartment(parts[1]));
            } else {
                output.addAll(topQuiz(parts[1]));
            }
        }

        return output;
    }

    public static List<String> topDepartment(String dept) {
        List<String> res = new ArrayList<>();
        int max = -1;
        boolean found = false;

        for (Student s : list) {
            if (s.dept.equals(dept)) {
                found = true;
                max = Math.max(max, s.total());
            }
        }

        if (!found) {
            res.add("Department Not Found");
            return res;
        }

        for (Student s : list) {
            if (s.dept.equals(dept) && s.total() == max) {
                res.add(s.name + " " + s.total());
            }
        }

        return res;
    }

    public static List<String> topQuiz(String quiz) {
        List<String> res = new ArrayList<>();
        int max = -1;

        if (quiz.equals("Q1")) {
            for (Student s : list) max = Math.max(max, s.q1);
            for (Student s : list) if (s.q1 == max) res.add(s.name + " " + s.q1);
        } else if (quiz.equals("Q2")) {
            for (Student s : list) max = Math.max(max, s.q2);
            for (Student s : list) if (s.q2 == max) res.add(s.name + " " + s.q2);
        } else if (quiz.equals("Q3")) {
            for (Student s : list) max = Math.max(max, s.q3);
            for (Student s : list) if (s.q3 == max) res.add(s.name + " " + s.q3);
        }

        return res;
    }
}