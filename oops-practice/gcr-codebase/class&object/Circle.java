package oop;

public class Circle {
    // Attribute
    double radius;

    // Method to calculate area
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display results
    void display() {
        System.out.printf("Area of circle: %.4f\n", calculateArea());
        System.out.printf("Circumference of circle: %.4f\n", calculateCircumference());
    }

    public static void main(String[] args) {
        Circle c = new Circle();

        // Given radius
        c.radius = 2.5;

        // Display area and circumference
        c.display();
    }
}
