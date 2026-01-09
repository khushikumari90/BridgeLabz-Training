package linkedlist;
//Social Media Friend Connections using Singly Linked List

import java.util.*;

class User {
 int userId;
 String name;
 int age;
 List<Integer> friends; // list of friend IDs
 User next;

 public User(int userId, String name, int age) {
     this.userId = userId;
     this.name = name;
     this.age = age;
     this.friends = new ArrayList<>();
     this.next = null;
 }
}

class SocialMediaLinkedList {
 private User head;

 // Add new user
 public void addUser(int userId, String name, int age) {
     User newUser = new User(userId, name, age);
     if (head == null) {
         head = newUser;
     } else {
         User temp = head;
         while (temp.next != null) {
             temp = temp.next;
         }
         temp.next = newUser;
     }
 }

 // Search user by ID
 public User searchById(int userId) {
     User temp = head;
     while (temp != null) {
         if (temp.userId == userId) return temp;
         temp = temp.next;
     }
     return null;
 }

 // Search user by Name
 public User searchByName(String name) {
     User temp = head;
     while (temp != null) {
         if (temp.name.equalsIgnoreCase(name)) return temp;
         temp = temp.next;
     }
     return null;
 }

 // Add friend connection between two users
 public void addFriendConnection(int userId1, int userId2) {
     User user1 = searchById(userId1);
     User user2 = searchById(userId2);

     if (user1 == null || user2 == null) {
         System.out.println("One or both users not found!");
         return;
     }

     if (!user1.friends.contains(userId2)) user1.friends.add(userId2);
     if (!user2.friends.contains(userId1)) user2.friends.add(userId1);

     System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
 }

 // Remove friend connection
 public void removeFriendConnection(int userId1, int userId2) {
     User user1 = searchById(userId1);
     User user2 = searchById(userId2);

     if (user1 == null || user2 == null) {
         System.out.println("One or both users not found!");
         return;
     }

     user1.friends.remove(Integer.valueOf(userId2));
     user2.friends.remove(Integer.valueOf(userId1));

     System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
 }

 // Display all friends of a specific user
 public void displayFriends(int userId) {
     User user = searchById(userId);
     if (user == null) {
         System.out.println("User not found!");
         return;
     }
     System.out.print(user.name + "'s Friends: ");
     if (user.friends.isEmpty()) {
         System.out.println("No friends.");
         return;
     }
     for (int fid : user.friends) {
         User friend = searchById(fid);
         if (friend != null) {
             System.out.print(friend.name + " ");
         }
     }
     System.out.println();
 }

 // Find mutual friends between two users
 public void findMutualFriends(int userId1, int userId2) {
     User user1 = searchById(userId1);
     User user2 = searchById(userId2);

     if (user1 == null || user2 == null) {
         System.out.println("One or both users not found!");
         return;
     }

     Set<Integer> mutual = new HashSet<>(user1.friends);
     mutual.retainAll(user2.friends);

     System.out.print("Mutual friends between " + user1.name + " and " + user2.name + ": ");
     if (mutual.isEmpty()) {
         System.out.println("None.");
         return;
     }
     for (int fid : mutual) {
         User friend = searchById(fid);
         if (friend != null) {
             System.out.print(friend.name + " ");
         }
     }
     System.out.println();
 }

 // Count number of friends for each user
 public void countFriends() {
     User temp = head;
     while (temp != null) {
         System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
         temp = temp.next;
     }
 }

 // Display all users
 public void displayUsers() {
     if (head == null) {
         System.out.println("No users in the system.");
         return;
     }
     System.out.println("Users:");
     User temp = head;
     while (temp != null) {
         System.out.println("ID=" + temp.userId + ", Name=" + temp.name + ", Age=" + temp.age);
         temp = temp.next;
     }
 }
}

public class SocialMediaFriendConnections {
 public static void main(String[] args) {
     SocialMediaLinkedList sm = new SocialMediaLinkedList();

     // Add users
     sm.addUser(1, "Alice", 25);
     sm.addUser(2, "Bob", 30);
     sm.addUser(3, "Charlie", 28);
     sm.addUser(4, "David", 22);

     sm.displayUsers();

     // Add friend connections
     sm.addFriendConnection(1, 2);
     sm.addFriendConnection(1, 3);
     sm.addFriendConnection(2, 3);
     sm.addFriendConnection(3, 4);

     // Display friends
     sm.displayFriends(1);
     sm.displayFriends(3);

     // Mutual friends
     sm.findMutualFriends(1, 2);
     sm.findMutualFriends(1, 4);

     // Count friends
     sm.countFriends();

     // Remove connection
     sm.removeFriendConnection(1, 2);
     sm.displayFriends(1);
     sm.displayFriends(2);
 }
}
