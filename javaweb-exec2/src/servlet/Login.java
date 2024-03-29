package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录处理
 *
 * @author liyong
 * @author kehan
 * @version 1.0
 */
public class Login extends HttpServlet {

    /**
     * The doGet method implements the request and response between browser and
     * server
     *
     * @param req
     *            the browser request
     * @param res
     *            the server response
     *
     * @throws IOException
     *             if there are errors from the input
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String name = "";
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("name")) {
                name = cookies[i].getValue();
            }
        }

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        out.println("<html>");
        out.println("<title>");
        out.println("User list");
        out.println("</title>");
        out.println("<body><h5>Use Cookies</h5><hr><br><br>");
        out.println("<body><h4>User List:</h4><hr><br><br>");
        out.println(name);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    /**
     * The doPost method implements the request and response between browser and
     * server
     *
     * @param req
     *            the browser request
     * @param res
     *            the server response
     *
     * @throws IOException
     *             if there are errors from the input
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        boolean judge = true;
        System.out.println(name);
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("name")) {
                    cookies[i].setValue(name);
                    judge = false;
                }
                if (cookies[i].getName().equals("password")) {
                    cookies[i].setValue(password);
                    judge = false;
                }
            }
        }

        if (judge) {
            Cookie cookie_name = new Cookie("name", name);
            Cookie cookie_password = new Cookie("password", password);
            // 不设置的话，则cookies不写入硬盘,而是写在内存,只在当前页面有用,以秒为单位
            cookie_name.setMaxAge(24 * 60 * 60);
            cookie_password.setMaxAge(24 * 60 * 60);
            res.addCookie(cookie_name);
            res.addCookie(cookie_password);
        }

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        out.println("<html>");
        out.println("<title>");
        out.println("User list");
        out.println("</title>");
        out.println("<body><h4>User List:</h4><hr><br><br>");
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("name")) {
                    out.print(cookies[i].getValue());
                }
            }
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}


