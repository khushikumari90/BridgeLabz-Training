package lambda_expressions;
import java.util.*;

@FunctionalInterface
interface LightAction {
    void activate();
}

public class SmartHomeLightning {
    public static void main(String[] args) {

        Map<String, LightAction> triggers = new HashMap<>();

        triggers.put("MOTION",
                () -> System.out.println("Motion detected: Lights ON at full brightness"));

        triggers.put("TIME",
                () -> System.out.println("Evening time: Lights ON with dim warm light"));

        triggers.put("VOICE",
                () -> System.out.println("Voice command: Party mode lights ON"));

        triggers.get("MOTION").activate();
        triggers.get("TIME").activate();
        triggers.get("VOICE").activate();
    }
}
