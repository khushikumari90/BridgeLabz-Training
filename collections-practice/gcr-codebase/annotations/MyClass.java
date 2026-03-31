package annotations;
//Parent class
class Animal {
 void makeSound() {
     System.out.println("Animal makes a sound");
 }
}

//Child class
class Dog extends Animal {

 @Override
 void makeSound() {
     System.out.println("Dog barks");
 }
}

//Main class
public class MyClass {
 public static void main(String[] args) {
     Dog dog = new Dog();   // Instantiating Dog
     dog.makeSound();      // Calling overridden method
 }
}
