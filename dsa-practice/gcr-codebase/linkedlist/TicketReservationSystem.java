package linkedlist;
//Online Ticket Reservation System using Circular Linked List

class Ticket {
 int ticketId;
 String customerName;
 String movieName;
 String seatNumber;
 String bookingTime;
 Ticket next;

 public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
     this.ticketId = ticketId;
     this.customerName = customerName;
     this.movieName = movieName;
     this.seatNumber = seatNumber;
     this.bookingTime = bookingTime;
     this.next = null;
 }
}

class CircularTicketList {
 private Ticket head = null;
 private Ticket tail = null;

 // Add new ticket at end
 public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
     Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
     if (head == null) {
         head = newTicket;
         tail = newTicket;
         newTicket.next = head; // circular link
     } else {
         tail.next = newTicket;
         newTicket.next = head;
         tail = newTicket;
     }
     System.out.println("Ticket booked successfully for " + customerName);
 }

 // Remove ticket by ID
 public void removeTicket(int ticketId) {
     if (head == null) {
         System.out.println("No tickets to remove.");
         return;
     }

     Ticket temp = head, prev = tail;
     do {
         if (temp.ticketId == ticketId) {
             if (temp == head) {
                 if (head == tail) { // only one ticket
                     head = tail = null;
                 } else {
                     head = head.next;
                     tail.next = head;
                 }
             } else if (temp == tail) {
                 tail = prev;
                 tail.next = head;
             } else {
                 prev.next = temp.next;
             }
             System.out.println("Ticket ID " + ticketId + " removed successfully.");
             return;
         }
         prev = temp;
         temp = temp.next;
     } while (temp != head);

     System.out.println("Ticket ID " + ticketId + " not found.");
 }

 // Display all tickets
 public void displayTickets() {
     if (head == null) {
         System.out.println("No tickets booked.");
         return;
     }
     System.out.println("Current Tickets:");
     Ticket temp = head;
     do {
         System.out.println("TicketID=" + temp.ticketId + ", Customer=" + temp.customerName +
                 ", Movie=" + temp.movieName + ", Seat=" + temp.seatNumber +
                 ", Time=" + temp.bookingTime);
         temp = temp.next;
     } while (temp != head);
 }

 // Search by Customer Name
 public void searchByCustomer(String customerName) {
     if (head == null) {
         System.out.println("No tickets booked.");
         return;
     }
     Ticket temp = head;
     boolean found = false;
     do {
         if (temp.customerName.equalsIgnoreCase(customerName)) {
             System.out.println("Found Ticket: ID=" + temp.ticketId + ", Movie=" + temp.movieName +
                     ", Seat=" + temp.seatNumber + ", Time=" + temp.bookingTime);
             found = true;
         }
         temp = temp.next;
     } while (temp != head);
     if (!found) System.out.println("No ticket found for customer: " + customerName);
 }

 // Search by Movie Name
 public void searchByMovie(String movieName) {
     if (head == null) {
         System.out.println("No tickets booked.");
         return;
     }
     Ticket temp = head;
     boolean found = false;
     do {
         if (temp.movieName.equalsIgnoreCase(movieName)) {
             System.out.println("Found Ticket: ID=" + temp.ticketId + ", Customer=" + temp.customerName +
                     ", Seat=" + temp.seatNumber + ", Time=" + temp.bookingTime);
             found = true;
         }
         temp = temp.next;
     } while (temp != head);
     if (!found) System.out.println("No ticket found for movie: " + movieName);
 }

 // Count total tickets
 public void countTickets() {
     if (head == null) {
         System.out.println("Total Tickets: 0");
         return;
     }
     int count = 0;
     Ticket temp = head;
     do {
         count++;
         temp = temp.next;
     } while (temp != head);
     System.out.println("Total Tickets: " + count);
 }
}

public class TicketReservationSystem {
 public static void main(String[] args) {
     CircularTicketList system = new CircularTicketList();

     // Add tickets
     system.addTicket(101, "Alice", "Inception", "A1", "2026-01-08 18:00");
     system.addTicket(102, "Bob", "Interstellar", "B2", "2026-01-08 19:00");
     system.addTicket(103, "Charlie", "Inception", "C3", "2026-01-08 20:00");

     // Display tickets
     system.displayTickets();

     // Search tickets
     system.searchByCustomer("Alice");
     system.searchByMovie("Inception");

     // Count tickets
     system.countTickets();

     // Remove a ticket
     system.removeTicket(102);

     // Display after removal
     system.displayTickets();
     system.countTickets();
 }
}