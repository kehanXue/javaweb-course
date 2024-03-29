﻿package lesson.j2ee.ex4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 显示选择结果
 *
 * @author liyong
 */
public class ShowBrownBeer extends HttpServlet {

    /**
     * The doGet method implements the request and response between browser and
     * server
     *
     * @param request  the browser request
     * @param response the server response
     * @throws IOException if there are errors from the input
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String colorParam = "Brown";
        PrintWriter out = response.getWriter();
        out.println(
                "<html> " + "<body>" + "<h1 align=center>Beer Color</h1>" + "<hr><br>" + "You selected beer color is: "
                        + colorParam + "<br>" + "Sorry, The brown beer have selled out !" + "</body>" + "</html>");
    }

}
