package servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


@WebServlet(name = "CodeReturnServlet")
public class CodeReturnServlet extends HttpServlet{

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/jar");
        ServletContext context = getServletContext();

        // TODO Relative Path
        InputStream inputStream = context.getResourceAsStream("/WEB-INF/classes/bookCode.jar");

        int read = 0;
        byte[] bytes = new byte[1024];
        //
        OutputStream outputStream = response.getOutputStream();
        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }
        outputStream.flush();
        outputStream.close();
    }

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}

