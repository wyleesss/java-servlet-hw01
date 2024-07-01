package org.example.javaservlethw01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/text")
public class TextServlet extends HttpServlet {
    private static final String vowelList = "AEIOUaeiouАЕЄИІЇОУЮЯаеєиіїоуюя";
    private static final String consonantList = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyzБВГҐДЖЗЙКЛМНПРСТФХЦЧШЩбвгґджзйклмнпрстфхцчшщ";
    private static final String punctuationList = ".,:;?!-()\"'/";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String text = req.getParameter("text");

        Set<Character> vowels = new HashSet<>();
        Set<Character> consonants = new HashSet<>();
        Set<Character> punctuation = new HashSet<>();

        int vowelCount = 0;
        int consonantCount = 0;
        int punctuationCount = 0;

        for (char c : text.toCharArray()) {
            if (vowelList.indexOf(c) != -1) {
                vowels.add(c);
                vowelCount++;
            } else if (consonantList.indexOf(c) != -1) {
                consonants.add(c);
                consonantCount++;
            } else if (punctuationList.indexOf(c) != -1) {
                punctuation.add(c);
                punctuationCount++;
            }
        }

        out.println("<html><body>");
        out.println(String.format("<h1>Vowel Count: %s</h1>", vowelCount));
        out.println(String.format("<h1>Vowels: %s</h1>", vowels));
        out.println(String.format("<h1>Consonant Count: %s</h1>", consonantCount));
        out.println(String.format("<h1>Consonants: %s</h1>", consonants));
        out.println(String.format("<h1>Punctuation Count: %s</h1>", punctuationCount));
        out.println("<h1>Punctuation characters: [");
        for (char c : punctuation) {
            out.print(c);
        }
        out.println("]</h1>");
        out.println("</body></html>");
    }
}
