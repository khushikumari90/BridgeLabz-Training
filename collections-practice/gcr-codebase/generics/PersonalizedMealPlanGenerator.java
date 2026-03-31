package generics;
/* ---------- Meal Plan Interface ---------- */
interface MealPlan {
    String getMealType();
    int getCalories();
}

/* ---------- Meal Implementations ---------- */
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }

    public int getCalories() {
        return 1800;
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }

    public int getCalories() {
        return 1700;
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }

    public int getCalories() {
        return 2000;
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High Protein";
    }

    public int getCalories() {
        return 2200;
    }
}

/* ---------- Generic Meal Class ---------- */
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

/* ---------- Utility Class with Generic Method ---------- */
class MealPlanUtil {

    // Generic method with bounded type parameter
    public static <T extends MealPlan> Meal<T> generateMealPlan(T meal) {
        validateMeal(meal);
        return new Meal<>(meal);
    }

    private static <T extends MealPlan> void validateMeal(T meal) {
        if (meal.getCalories() < 1500 || meal.getCalories() > 2500) {
            throw new IllegalArgumentException("Invalid calorie range for meal plan");
        }
    }
}

/* ---------- Main Class ---------- */
public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal =
                MealPlanUtil.generateMealPlan(new VegetarianMeal());

        Meal<VeganMeal> veganMeal =
                MealPlanUtil.generateMealPlan(new VeganMeal());

        Meal<KetoMeal> ketoMeal =
                MealPlanUtil.generateMealPlan(new KetoMeal());

        Meal<HighProteinMeal> proteinMeal =
                MealPlanUtil.generateMealPlan(new HighProteinMeal());

        System.out.println("---- Personalized Meal Plans ----");
        displayMeal(vegMeal);
        displayMeal(veganMeal);
        displayMeal(ketoMeal);
        displayMeal(proteinMeal);
    }

    // Generic display method
    public static <T extends MealPlan> void displayMeal(Meal<T> meal) {
        System.out.println(
            "Meal Type: " + meal.getMealPlan().getMealType() +
            " | Calories: " + meal.getMealPlan().getCalories()
        );
    }
}
