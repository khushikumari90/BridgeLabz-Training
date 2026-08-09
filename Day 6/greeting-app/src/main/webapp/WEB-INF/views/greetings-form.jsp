<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Greeting Form</title>
    <style>
        body { font-family: Arial, sans-serif; background:#f4f6f8; display:flex;
               justify-content:center; align-items:center; height:100vh; margin:0; }
        .card { background:#fff; padding:30px 40px; border-radius:10px;
                box-shadow:0 4px 12px rgba(0,0,0,0.1); width:320px; }
        input[type=text] { padding:8px; width:90%; margin:8px 0; border:1px solid #ccc; border-radius:5px; }
        input[type=submit] { padding:8px 20px; background:#4CAF50; color:#fff; border:none;
                              border-radius:5px; cursor:pointer; margin-top:10px; }
        input[type=submit]:hover { background:#45a049; }
        .back { display:block; margin-top:15px; text-align:center; color:#1976d2; }
    </style>
</head>
<body>
    <div class="card">
        <h2>${greeting.id > 0 ? "Edit Greeting" : "Add Greeting"}</h2>

        <c:choose>
            <c:when test="${greeting.id > 0}">
                <form action="${pageContext.request.contextPath}/greetings/edit/${greeting.id}" method="post">
            </c:when>
            <c:otherwise>
                <form action="${pageContext.request.contextPath}/greetings/add" method="post">
            </c:otherwise>
        </c:choose>

            <label>Name</label><br/>
            <input type="text" name="name" value="${greeting.name}" required /><br/>

            <label>Message</label><br/>
            <input type="text" name="message" value="${greeting.message}" required /><br/>

            <input type="submit" value="Save" />
        </form>

        <a class="back" href="${pageContext.request.contextPath}/greetings">Back to List</a>
    </div>
</body>
</html>
