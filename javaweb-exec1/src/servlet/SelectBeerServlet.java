package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "SelectBeerServlet")
public class SelectBeerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String colorParam = request.getParameter("color");

        if (colorParam.equals("brown")) {

            response.sendRedirect("ShowBrownBeer.do?color=brown");

        } else if (colorParam.equals("dark")) {

            try {
                request.getRequestDispatcher("ShowDarkBeer.do").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

        PrintWriter out = response.getWriter();
        out.println("<html> " + "<body>"
                + "<h1 align=center>Beer Color</h1>" + "<br>"
                + "My selected beer color is: " + colorParam + "</body>" + "</html>");
    }
}
