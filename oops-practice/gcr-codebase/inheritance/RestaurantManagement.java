package inheritance;
//Superclass (RENAMED)
class RestaurantPerson {
 String name;
 int id;

 RestaurantPerson(String name, int id) {
     this.name = name;
     this.id = id;
 }
}

//Interface
interface Worker {
 void performDuties();
}

//Chef class
class Chef extends RestaurantPerson implements Worker {

 Chef(String name, int id) {
     super(name, id);
 }

 @Override
 public void performDuties() {
     System.out.println("Chef " + name + " is cooking food.");
 }
}

//Waiter class
class Waiter extends RestaurantPerson implements Worker {

 Waiter(String name, int id) {
     super(name, id);
 }

 @Override
 public void performDuties() {
     System.out.println("Waiter " + name + " is serving customers.");
 }
}

//Main class
public class RestaurantManagement {
 public static void main(String[] args) {
     Chef chef = new Chef("Rahul", 101);
     Waiter waiter = new Waiter("Amit", 201);

     chef.performDuties();
     waiter.performDuties();
 }
}

