package servlet;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ShowCartTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        PageContext pageContext = (PageContext) getJspContext();
        HttpSession httpSession = pageContext.getSession();
        Integer itemCount = (Integer) httpSession.getAttribute("itemCount");

        if (itemCount == null)
            itemCount = 0;


        String[] itemsSelected;
        String itemName;
        itemsSelected = pageContext.getRequest().getParameterValues("item");

        JspWriter jspWriter = getJspContext().getOut();
        if (itemsSelected != null) {
            for (String s : itemsSelected) {
                itemName = s;
                System.out.println(itemName);
                itemCount = itemCount + 1;

                httpSession.setAttribute("item" + itemCount, itemName);

                httpSession.setAttribute("itemCount", itemCount);
            }
        }

        for (int i = 1; i <= itemCount; i++) {
            jspWriter.println((String) httpSession.getAttribute("item" + i) + "<hr>");
        }
        jspWriter.close();
    }
}

