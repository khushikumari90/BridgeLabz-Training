package event_attendee_welcome_message;
import java.util.*;

public class EventWelcomeApp {
    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
            "Khushi",
            "Amit",
            "Neha",
            "Rahul"
        );

        // Print welcome message for each attendee
        attendees.forEach(name ->
            System.out.println("Welcome to the event, " + name + "!")
        );
    }
}
