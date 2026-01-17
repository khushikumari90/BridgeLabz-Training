package stack;

class MyClass {
    String name;
    int rollno;

    MyClass() {
        this.name = "Unknown";
        this.rollno = 0;
    }

    MyClass(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    public void show() {
        System.out.println("My name is " + name + " and roll no. is " + rollno);
    }
}

public class ConstructorOverloading {
    public static void main(String args[]) {
        MyClass obj1 = new MyClass();
        obj1.show();

        MyClass obj2 = new MyClass("Khushi", 1);
        obj2.show();
    }
}
