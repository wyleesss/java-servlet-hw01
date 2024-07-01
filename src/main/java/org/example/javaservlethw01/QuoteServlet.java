package org.example.javaservlethw01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/quote")
public class QuoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String quote = "Bad programmers worry about the code. Good programmers worry about data structures and their relationships";
        String author = "Linus Torvalds";

        out.println("<html><body>");
        out.println(String.format("<h1><q>%s</q> - %s<h1>", quote, author));
        out.println("</body></html>");
    }
}
