package com.bridgelabz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//UC-2 : LoginServlet
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        response.getWriter().println("<h2>This is a GET request</h2>");
        response.getWriter().println("<p>Tomcat called the doGet() method.</p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //UC-3 : Name Validation
        String nameRegex = "^[A-Z][a-z]{2,}$";

        //UC-4 : Password validation
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=(?:.*[^A-Za-z0-9]){1}.*$).{8,}$";

        // Validate username
        boolean validUsername = (username != null && username.matches(nameRegex));

        // Validate password
        boolean validPassword = (password != null && password.matches(passwordRegex));

        //Validating credentials
        if (validUsername && validPassword) {
            request.setAttribute("message", "Login Successful");
            request.setAttribute("status",true);
            request.setAttribute("username", username);

        } else {
            request.setAttribute("message", "Invalid Username or Password");
            request.setAttribute("status",false);
        }
        request.getRequestDispatcher("loginOutput.jsp").forward(request, response);
    }
}