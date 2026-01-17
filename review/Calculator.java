package stack;

public class Calculator {
    public void addnumbers(int a,int b) {
    	System.out.println("Sum of a and b is : "+(a+b));
    }
    public void addnumbers(int a,int b,int c) {
    	System.out.println("Sum of a,b and c is : "+(a+b+c));
    }
    public void addnumbers(int a,int b,int c,int d) {
    	System.out.println("Sum of a,b,c and d is : "+(a+b+c+d));
    }
    public static void main(String args[]) {
         Calculator c=new Calculator();
         c.addnumbers(10, 20);
         c.addnumbers(20,40,60);
         c.addnumbers(30,60,90,120);
    }
}
