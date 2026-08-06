<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Greeting App - Spring MVC</title>
    <style>
        body { font-family: Arial, sans-serif; background:#f4f6f8; display:flex;
               justify-content:center; align-items:center; height:100vh; margin:0; }
        .card { background:#fff; padding:30px 40px; border-radius:10px;
                box-shadow:0 4px 12px rgba(0,0,0,0.1); text-align:center; width:320px; }
        input[type=text] { padding:8px; width:80%; margin:10px 0; border:1px solid #ccc; border-radius:5px; }
        input[type=submit] { padding:8px 20px; background:#4CAF50; color:#fff; border:none;
                              border-radius:5px; cursor:pointer; }
        input[type=submit]:hover { background:#45a049; }
        .message { margin-top:15px; color:#2e7d32; font-weight:bold; }
    </style>
</head>
<body>
    <div class="card">
        <h2>Greeting App</h2>

        <!-- POST request yahin se jayega -->
        <form action="greeting" method="post">
            <input type="text" name="name" placeholder="Enter your name" required />
            <br/>
            <input type="submit" value="Greet Me" />
        </form>

        <c:if test="${not empty message}">
            <p class="message">${message}</p>
        </c:if>
    </div>
</body>
</html>
