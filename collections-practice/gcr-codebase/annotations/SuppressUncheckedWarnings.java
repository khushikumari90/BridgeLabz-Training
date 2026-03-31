package annotations;
import java.util.ArrayList;

class WarningExample {

    @SuppressWarnings("unchecked")
    void createList() {

        ArrayList list = new ArrayList(); // Raw type (no generics)

        list.add("Java");
        list.add("Python");
        list.add(100);   // Different type allowed

        for (Object obj : list) {
            System.out.println(obj);
        }





    }
}

public class SuppressUncheckedWarnings {
    public static void main(String[] args) {
        WarningExample obj = new WarningExample();
        obj.createList();
    }
}
