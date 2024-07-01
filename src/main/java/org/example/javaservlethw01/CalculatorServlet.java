package org.example.javaservlethw01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        try {
            double number1 = Integer.parseInt(req.getParameter("firstNum"));
            double number2 = Integer.parseInt(req.getParameter("secondNum"));
            String operation = req.getParameter("operation");
            double result = 0;
            boolean validOperation = true;

            switch (operation) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        out.println("<h1>Error - Division by 0</h1>");
                        validOperation = false;
                    }
                    break;
                case "%":
                    if (number2 != 0) {
                        result = number1 % number2;
                    } else {
                        out.println("<h1>Error - Division by 0</h1>");
                        validOperation = false;
                    }
                    break;
                case "^":
                    result = Math.pow(number1, number2);
                    break;
                default:
                    out.println("<h1>Error - Unknown operation</h1>");
                    validOperation = false;
            }

            if (validOperation) {
                out.println(String.format("<h1>%s %s %s = %s</h1>", number1, operation, number2, result));
            }
        } catch (NumberFormatException e) {
            out.println(String.format("<h1>Error - %s<h1>", e.getMessage()));
        } finally {
            out.println("</body></html>");
        }
    }
}