package reflection;
import java.lang.annotation.*;

//Step 1: Create Author Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
 String name();
}

//Step 2: Apply Annotation to a Class
@Author(name = "Author Name")
class Book {
 public void display() {
     System.out.println("Book class");
 }
}

//Step 3: Retrieve Annotation Using Reflection
public class RetrieveAnnotationDemo {

 public static void main(String[] args) {

     // Get Class object
     Class<Book> cls = Book.class;

     // Check and retrieve annotation
     if (cls.isAnnotationPresent(Author.class)) {

         Author author = cls.getAnnotation(Author.class);

         System.out.println("Author Name: " + author.name());
     } else {
         System.out.println("Author annotation not found");
     }
 }
}
