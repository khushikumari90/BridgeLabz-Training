package student_result_grouping;
import java.util.*;
import java.util.stream.Collectors;

public class StudentGroupingApp {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
            new Student("Khushi", "A"),
            new Student("Amit", "B"),
            new Student("Neha", "A"),
            new Student("Rahul", "C"),
            new Student("Sneha", "B")
        );

        // Group students by grade and collect names
        Map<String, List<String>> studentsByGrade =
                students.stream()
                        .collect(Collectors.groupingBy(
                            s -> s.grade,
                            Collectors.mapping(s -> s.name, Collectors.toList())
                        ));

        studentsByGrade.forEach((grade, names) ->
                System.out.println("Grade " + grade + ": " + names));
    }
}
