package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "TestInitParamsServlet")
public class TestInitParamsServlet extends HttpServlet {

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

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        java.util.Enumeration e = getServletConfig().getInitParameterNames();
        while (e.hasMoreElements()) {
            out.println("<br>servlet param name is: " + e.nextElement() + "<br>");
        }
        out.println("<br>servlet param is: " + getServletConfig().getInitParameter("servletParam") + "<br>");
        out.println("<br>context param is: " + getServletContext().getInitParameter("contextParam") + "<br>");
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

        doGet(request, response);
    }
}
