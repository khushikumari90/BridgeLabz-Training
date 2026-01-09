package linkedlist;
//Task Scheduler using Circular Linked List

class Task {
 int taskId;
 String taskName;
 int priority;
 String dueDate;
 Task next;

 public Task(int taskId, String taskName, int priority, String dueDate) {
     this.taskId = taskId;
     this.taskName = taskName;
     this.priority = priority;
     this.dueDate = dueDate;
     this.next = null;
 }
}

class CircularTaskList {
 private Task head;
 private Task current;

 // Add at beginning
 public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
     Task newTask = new Task(taskId, taskName, priority, dueDate);
     if (head == null) {
         head = newTask;
         head.next = head;
     } else {
         Task temp = head;
         while (temp.next != head) {
             temp = temp.next;
         }
         temp.next = newTask;
         newTask.next = head;
         head = newTask;
     }
 }

 // Add at end
 public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
     Task newTask = new Task(taskId, taskName, priority, dueDate);
     if (head == null) {
         head = newTask;
         head.next = head;
     } else {
         Task temp = head;
         while (temp.next != head) {
             temp = temp.next;
         }
         temp.next = newTask;
         newTask.next = head;
     }
 }

 // Add at specific position (1-based index)
 public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
     if (position <= 0) {
         System.out.println("Invalid position!");
         return;
     }
     if (position == 1) {
         addAtBeginning(taskId, taskName, priority, dueDate);
         return;
     }
     Task newTask = new Task(taskId, taskName, priority, dueDate);
     Task temp = head;
     for (int i = 1; temp.next != head && i < position - 1; i++) {
         temp = temp.next;
     }
     newTask.next = temp.next;
     temp.next = newTask;
 }

 // Remove by Task ID
 public void removeByTaskId(int taskId) {
     if (head == null) {
         System.out.println("List is empty!");
         return;
     }
     if (head.taskId == taskId) {
         if (head.next == head) {
             head = null;
         } else {
             Task temp = head;
             while (temp.next != head) {
                 temp = temp.next;
             }
             temp.next = head.next;
             head = head.next;
         }
         System.out.println("Task removed successfully.");
         return;
     }
     Task temp = head;
     while (temp.next != head && temp.next.taskId != taskId) {
         temp = temp.next;
     }
     if (temp.next == head) {
         System.out.println("Task not found!");
     } else {
         temp.next = temp.next.next;
         System.out.println("Task removed successfully.");
     }
 }

 // View current task
 public void viewCurrentTask() {
     if (current == null) {
         current = head;
     }
     if (current != null) {
         System.out.println("Current Task: ID=" + current.taskId + ", Name=" + current.taskName +
                 ", Priority=" + current.priority + ", DueDate=" + current.dueDate);
     } else {
         System.out.println("No tasks available.");
     }
 }

 // Move to next task
 public void moveToNextTask() {
     if (current == null) {
         current = head;
     } else {
         current = current.next;
     }
     viewCurrentTask();
 }

 // Display all tasks
 public void displayTasks() {
     if (head == null) {
         System.out.println("No tasks to display.");
         return;
     }
     System.out.println("Tasks in Circular List:");
     Task temp = head;
     do {
         System.out.println("ID=" + temp.taskId + ", Name=" + temp.taskName +
                 ", Priority=" + temp.priority + ", DueDate=" + temp.dueDate);
         temp = temp.next;
     } while (temp != head);
 }

 // Search by Priority
 public void searchByPriority(int priority) {
     if (head == null) {
         System.out.println("No tasks available.");
         return;
     }
     Task temp = head;
     boolean found = false;
     do {
         if (temp.priority == priority) {
             System.out.println("Found Task: ID=" + temp.taskId + ", Name=" + temp.taskName +
                     ", DueDate=" + temp.dueDate);
             found = true;
         }
         temp = temp.next;
     } while (temp != head);
     if (!found) {
         System.out.println("No tasks found with priority " + priority);
     }
 }
}

public class TaskScheduler {
 public static void main(String[] args) {
     CircularTaskList list = new CircularTaskList();

     // Adding tasks
     list.addAtBeginning(1, "Design Module", 2, "2026-01-15");
     list.addAtEnd(2, "Implement Feature", 1, "2026-01-20");
     list.addAtPosition(2, 3, "Write Documentation", 3, "2026-01-25");

     // Display tasks
     list.displayTasks();

     // View current task and move to next
     list.viewCurrentTask();
     list.moveToNextTask();
     list.moveToNextTask();

     // Search by priority
     list.searchByPriority(1);

     // Remove a task
     list.removeByTaskId(2);

     // Display after removal
     list.displayTasks();
 }
}