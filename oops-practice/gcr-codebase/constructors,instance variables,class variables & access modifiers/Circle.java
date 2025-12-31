//Write a Circle class with a radius attribute. Use constructor chaining to initialize radius with default and user-provided values.
package constructor;
public class Circle {
    double radius;

    // Default constructor
    Circle() {
        this(1.0); // calls parameterized constructor
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to display details
    void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
    }

    public static void main(String[] args) {
        // Using default constructor
        Circle c1 = new Circle();
        c1.display();

        System.out.println();

        // Using parameterized constructor
        Circle c2 = new Circle(5.5);
        c2.display();
    }
}

