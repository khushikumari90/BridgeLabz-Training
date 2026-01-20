//TrafficManager-Roundabout Vehicle Flow Story
package scenario_based;
public class TrafficManager {

    // ---------- Vehicle Node (Circular Linked List) ----------
    static class VehicleNode {
        String vehicleNumber;
        VehicleNode next;

        VehicleNode(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
            this.next = null;
        }
    }

    // ---------- Roundabout (Circular Linked List) ----------
    static class Roundabout {
        private VehicleNode head = null;

        void addVehicle(String vehicleNumber) {
            VehicleNode newNode = new VehicleNode(vehicleNumber);

            if (head == null) {
                head = newNode;
                newNode.next = head;
            } else {
                VehicleNode temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next = head;
            }
            System.out.println(vehicleNumber + " entered the roundabout.");
        }

        void removeVehicle() {
            if (head == null) {
                System.out.println("Roundabout is empty.");
                return;
            }

            if (head.next == head) {
                System.out.println(head.vehicleNumber + " exited the roundabout.");
                head = null;
            } else {
                VehicleNode temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                System.out.println(head.vehicleNumber + " exited the roundabout.");
                temp.next = head.next;
                head = head.next;
            }
        }

        void display() {
            if (head == null) {
                System.out.println("Roundabout is empty.");
                return;
            }

            VehicleNode temp = head;
            System.out.print("Roundabout Vehicles: ");
            do {
                System.out.print(temp.vehicleNumber + " -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("(back to start)");
        }
    }

    // ---------- Queue (Waiting Vehicles) ----------
    static class VehicleQueue {
        private String[] queue;
        private int front = 0, rear = -1, size = 0;
        private int capacity;

        VehicleQueue(int capacity) {
            this.capacity = capacity;
            queue = new String[capacity];
        }

        void enqueue(String vehicle) {
            if (size == capacity) {
                System.out.println("Queue Overflow! " + vehicle + " cannot enter.");
                return;
            }
            rear = (rear + 1) % capacity;
            queue[rear] = vehicle;
            size++;
            System.out.println(vehicle + " is waiting.");
        }

        String dequeue() {
            if (size == 0) {
                System.out.println("Queue Underflow! No vehicles waiting.");
                return null;
            }
            String vehicle = queue[front];
            front = (front + 1) % capacity;
            size--;
            return vehicle;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    // ---------- Main Method ----------
    public static void main(String[] args) {

        Roundabout roundabout = new Roundabout();
        VehicleQueue queue = new VehicleQueue(3);

        queue.enqueue("CAR-101");
        queue.enqueue("CAR-102");
        queue.enqueue("CAR-103");
        queue.enqueue("CAR-104"); // Overflow

        while (!queue.isEmpty()) {
            String vehicle = queue.dequeue();
            if (vehicle != null) {
                roundabout.addVehicle(vehicle);
            }
        }

        roundabout.display();

        roundabout.removeVehicle();
        roundabout.display();

        roundabout.addVehicle("CAR-105");
        roundabout.display();
    }
}
