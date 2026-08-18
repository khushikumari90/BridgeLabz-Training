<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>

<body>
<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>

<h3><%= message %></h3>

<%
   }
%>

<br>
<%
    Boolean status = (Boolean) request.getAttribute("status");
    if (Boolean.TRUE.equals(status)) {
%>
    <button>
        <a href="login.html" style="text-decoration:none">Logout</a>
    </button>
<%
    } else{
%>
    <button>
        <a href="loginHelp.jsp" style="text-decoration:none">Login Help</a>
    </button>
<%
    }
%>
</body>
</html>