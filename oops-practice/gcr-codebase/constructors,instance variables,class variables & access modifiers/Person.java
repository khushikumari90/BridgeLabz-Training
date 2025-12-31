//Create a Person class with a copy constructor that clones another person's attributes.
package constructor;
public class Person {
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Method to display details
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Original object
        Person p1 = new Person("Rahul", 25);

        // Cloned object using copy constructor
        Person p2 = new Person(p1);

        System.out.println("Original Person:");
        p1.display();

        System.out.println("\nCloned Person:");
        p2.display();
    }
}

