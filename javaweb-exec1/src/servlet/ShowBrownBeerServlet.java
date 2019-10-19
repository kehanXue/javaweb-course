package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ShowBrownBeerServlet")
public class ShowBrownBeerServlet extends HttpServlet {

    /**
     * The doGet method implements the request and response between browser and
     * server
     *
     * @param request
     *            the browser request
     * @param response
     *            the server response
     *
     * @throws IOException
     *             if there are errors from the input
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String colorParam = request.getParameter("color");

        PrintWriter out = response.getWriter();
        out.println("<html> " + "<body>"
                + "<h1 align=center>Beer Color</h1>" + "<br>"
                + "(Redirect)My selected beer color is: " + colorParam + "</body>" + "</html>");
    }

    /**
     * The doPost method implements the request and response between browser and
     * server
     *
     * @param request
     *            the browser request
     * @param response
     *            the server response
     *
     * @throws IOException
     *             if there are errors from the input
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        doPost(request, response);
    }
}