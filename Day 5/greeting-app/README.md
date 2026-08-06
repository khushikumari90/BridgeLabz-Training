# Greeting App - Spring MVC (Servlet based)

## Project Structure (MVC Architecture)
- **Model** -> `GreetingModel.java`
- **View** -> `greeting.jsp` (WEB-INF/views ke andar)
- **Controller** -> `GreetingController.java` (1 GET + 1 POST method)
- **DispatcherServlet** -> `web.xml` me register hai (yahi Tomcat ka actual servlet hai)

## Methods
| Method | URL         | Kaam                                  |
|--------|-------------|----------------------------------------|
| GET    | `/greeting` | Form dikhata hai                       |
| POST   | `/greeting` | Form submit hone par greeting banata hai |

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
