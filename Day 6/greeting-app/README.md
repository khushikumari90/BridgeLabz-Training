# Greeting App - Spring MVC (Servlet based)

## Project Structure (MVC Architecture)
- **Model** -> `GreetingModel.java`
- **View** -> `greeting.jsp` (WEB-INF/views ke andar)
- **Controller** -> `GreetingController.java` (1 GET + 1 POST method)
- **DispatcherServlet** -> `web.xml` me register hai (yahi Tomcat ka actual servlet hai)

## Methods

### Simple Greeting (no database)
| Method | URL         | Kaam                                  |
|--------|-------------|----------------------------------------|
| GET    | `/greeting` | Form dikhata hai                       |
| POST   | `/greeting` | Form submit hone par greeting banata hai |

### Greeting CRUD (database backed)
| Method | URL                     | Kaam                     |
|--------|--------------------------|---------------------------|
| GET    | `/greetings`             | Sabhi greetings ki list   |
| GET    | `/greetings/add`         | Add form dikhata hai      |
| POST   | `/greetings/add`         | Naya greeting save karta hai |
| GET    | `/greetings/edit/{id}`   | Edit form dikhata hai     |
| POST   | `/greetings/edit/{id}`   | Greeting update karta hai |
| GET    | `/greetings/delete/{id}` | Greeting delete karta hai |

## Database Setup
1. `database/greeting_schema.sql` file ko MySQL me run karo (isse `greeting_db` database aur `greetings` table ban jayegi)
2. `DBConnection.java` (`src/main/java/com/example/greeting/util/`) me apna MySQL username/password set karo:
   ```
   URL = jdbc:mysql://localhost:3306/greeting_db
   USERNAME = root
   PASSWORD = root
   ```

## Build (WAR file banane ke liye)
Maven install hona chahiye. Terminal me project folder ke andar jaake:

```
mvn clean package
```

Isse `target/greeting-app.war` ban jayegi.

## Tomcat par Deploy karna
1. Apache Tomcat download/install karo (agar nahi hai): https://tomcat.apache.org/
2. `target/greeting-app.war` file ko Tomcat ke `webapps/` folder me copy kar do.
3. Tomcat start karo:
   - Windows: `startup.bat`
   - Linux/Mac: `./startup.sh` (Tomcat ke `bin` folder ke andar se)
4. Browser me kholo:
   ```
   http://localhost:8080/greeting-app/greeting
   ```
5. Naam likh ke "Greet Me" dabao -> POST request jayegi aur greeting message dikhega.

## Note
- Java 11 aur Maven pehle se installed hone chahiye.
- Agar Tomcat 9 use kar rahe ho to Servlet 4.0 already compatible hai (pom.xml me set hai).
