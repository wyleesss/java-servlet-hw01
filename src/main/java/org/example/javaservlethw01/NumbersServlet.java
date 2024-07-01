package org.example.javaservlethw01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/numbers")
public class NumbersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        try {
            int number1 = Integer.parseInt(req.getParameter("firstNum"));
            int number2 = Integer.parseInt(req.getParameter("secondNum"));
            int number3 = Integer.parseInt(req.getParameter("thirdNum"));

            int result = switch (req.getParameter("operation")) {
                case "max" -> Math.max(number1, Math.max(number2, number3));
                case "min" -> Math.min(number1, Math.min(number2, number3));
                case "avg" -> (number1 + number2 + number3) / 3;
                default -> 0;
            };

            out.println(String.format("<h1>{%s, %s, %s}<br>result -> %s<h1>",
                    number1, number2, number3, result));
        } catch (NumberFormatException e) {
            out.println(String.format("<h1>Error - %s<h1>", e.getMessage()));
        } finally {
            out.println("</body></html>");
        }
    }
}
