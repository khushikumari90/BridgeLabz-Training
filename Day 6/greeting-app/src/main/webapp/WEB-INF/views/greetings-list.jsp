<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Greetings</title>
    <style>
        body { font-family: Arial, sans-serif; background:#f4f6f8; padding:40px; }
        .container { max-width:700px; margin:0 auto; background:#fff; padding:25px 35px;
                     border-radius:10px; box-shadow:0 4px 12px rgba(0,0,0,0.1); }
        table { width:100%; border-collapse:collapse; margin-top:15px; }
        th, td { padding:10px; border-bottom:1px solid #eee; text-align:left; }
        th { background:#f0f0f0; }
        a { text-decoration:none; margin-right:10px; }
        .edit { color:#1976d2; }
        .delete { color:#d32f2f; }
        .add-btn { display:inline-block; margin-top:15px; padding:8px 18px; background:#4CAF50;
                   color:#fff; border-radius:5px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>All Greetings</h2>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Message</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="g" items="${greetings}">
                <tr>
                    <td>${g.id}</td>
                    <td>${g.name}</td>
                    <td>${g.message}</td>
                    <td>
                        <a class="edit" href="${pageContext.request.contextPath}/greetings/edit/${g.id}">Edit</a>
                        <a class="delete" href="${pageContext.request.contextPath}/greetings/delete/${g.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a class="add-btn" href="${pageContext.request.contextPath}/greetings/add">Add New Greeting</a>
    </div>
</body>
</html>
