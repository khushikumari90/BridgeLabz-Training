package linkedlist;
//Round Robin Scheduling using Circular Linked List

class Process {
 int pid;
 int burstTime;
 int priority;
 int remainingTime;
 Process next;

 public Process(int pid, int burstTime, int priority) {
     this.pid = pid;
     this.burstTime = burstTime;
     this.priority = priority;
     this.remainingTime = burstTime;
     this.next = null;
 }
}

class CircularProcessList {
 private Process head = null;
 private Process tail = null;

 // Add process at end
 public void addProcess(int pid, int burstTime, int priority) {
     Process newProcess = new Process(pid, burstTime, priority);
     if (head == null) {
         head = newProcess;
         tail = newProcess;
         newProcess.next = head; // circular link
     } else {
         tail.next = newProcess;
         newProcess.next = head;
         tail = newProcess;
     }
 }

 // Remove process by ID
 public void removeProcess(int pid) {
     if (head == null) return;

     Process temp = head, prev = tail;
     do {
         if (temp.pid == pid) {
             if (temp == head) {
                 if (head == tail) { // only one node
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
             return;
         }
         prev = temp;
         temp = temp.next;
     } while (temp != head);
 }

 // Display processes
 public void displayProcesses() {
     if (head == null) {
         System.out.println("No processes in queue.");
         return;
     }
     Process temp = head;
     System.out.print("Processes in Queue: ");
     do {
         System.out.print("[PID=" + temp.pid + ", Remaining=" + temp.remainingTime + "] ");
         temp = temp.next;
     } while (temp != head);
     System.out.println();
 }

 // Round Robin Scheduling Simulation
 public void roundRobin(int timeQuantum) {
     if (head == null) {
         System.out.println("No processes to schedule.");
         return;
     }

     int totalWaitingTime = 0;
     int totalTurnaroundTime = 0;
     int completedProcesses = 0;
     int currentTime = 0;

     Process current = head;
     while (head != null) {
         if (current.remainingTime > 0) {
             int execTime = Math.min(timeQuantum, current.remainingTime);
             current.remainingTime -= execTime;
             currentTime += execTime;

             System.out.println("Executing PID=" + current.pid + " for " + execTime + " units.");

             if (current.remainingTime == 0) {
                 int turnaroundTime = currentTime;
                 int waitingTime = turnaroundTime - current.burstTime;
                 totalTurnaroundTime += turnaroundTime;
                 totalWaitingTime += waitingTime;
                 completedProcesses++;

                 System.out.println("Process PID=" + current.pid + " completed. TAT=" + turnaroundTime + ", WT=" + waitingTime);

                 int pidToRemove = current.pid;
                 current = current.next; // move before removal
                 removeProcess(pidToRemove);
                 if (head == null) break;
             } else {
                 current = current.next;
             }
         } else {
             current = current.next;
         }
         displayProcesses();
     }

     System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / completedProcesses);
     System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / completedProcesses);
 }
}

public class RoundRobinScheduler {
 public static void main(String[] args) {
     CircularProcessList scheduler = new CircularProcessList();

     // Add processes
     scheduler.addProcess(1, 10, 1);
     scheduler.addProcess(2, 5, 2);
     scheduler.addProcess(3, 8, 1);

     // Display initial queue
     scheduler.displayProcesses();

     // Run Round Robin with time quantum = 3
     scheduler.roundRobin(3);
 }
}
