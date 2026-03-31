package linkedlist;
//Undo/Redo Functionality using Doubly Linked List

class TextState {
 String content;
 TextState prev;
 TextState next;

 public TextState(String content) {
     this.content = content;
     this.prev = null;
     this.next = null;
 }
}

class TextEditor {
 private TextState head;
 private TextState tail;
 private TextState current;
 private int size;
 private final int MAX_HISTORY = 10;

 // Add new state at the end
 public void addState(String content) {
     TextState newState = new TextState(content);

     // If current is not the last, discard redo history
     if (current != null && current.next != null) {
         current.next.prev = null;
         current.next = null;
         tail = current;
         size = countSize();
     }

     if (head == null) {
         head = tail = newState;
     } else {
         tail.next = newState;
         newState.prev = tail;
         tail = newState;
     }
     current = newState;
     size++;

     // Limit history size
     if (size > MAX_HISTORY) {
         head = head.next;
         head.prev = null;
         size--;
     }
 }

 // Undo functionality
 public void undo() {
     if (current != null && current.prev != null) {
         current = current.prev;
         System.out.println("Undo performed.");
     } else {
         System.out.println("No more undo available.");
     }
 }

 // Redo functionality
 public void redo() {
     if (current != null && current.next != null) {
         current = current.next;
         System.out.println("Redo performed.");
     } else {
         System.out.println("No more redo available.");
     }
 }

 // Display current state
 public void displayCurrentState() {
     if (current == null) {
         System.out.println("No text available.");
     } else {
         System.out.println("Current Text: \"" + current.content + "\"");
     }
 }

 // Count size (helper for trimming history)
 private int countSize() {
     int count = 0;
     TextState temp = head;
     while (temp != null) {
         count++;
         temp = temp.next;
     }
     return count;
 }
}

public class UndoRedoTextEditor {
 public static void main(String[] args) {
     TextEditor editor = new TextEditor();

     // Simulate typing
     editor.addState("Hello");
     editor.addState("Hello World");
     editor.addState("Hello World!");
     editor.displayCurrentState();

     // Undo operations
     editor.undo();
     editor.displayCurrentState();

     editor.undo();
     editor.displayCurrentState();

     // Redo operation
     editor.redo();
     editor.displayCurrentState();

     // Add new state after undo (redo history cleared)
     editor.addState("Hello Universe!");
     editor.displayCurrentState();

     // Add more states to exceed history limit
     for (int i = 1; i <= 12; i++) {
         editor.addState("State " + i);
     }
     editor.displayCurrentState();
 }
}