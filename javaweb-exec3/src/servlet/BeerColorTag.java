package servlet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author kehanXue
 */
public class BeerColorTag extends SimpleTagSupport {
    /**
     * doTag()
     *
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        String sessionList = (String) getJspContext().findAttribute("sessionList");
        String[] beerColors = sessionList.split(",");

        int light = 0;
        int amber = 0;
        int brown = 0;
        int dark = 0;

        // System.out.println(Arrays.toString(beerColors));
        for (String beerColor : beerColors) {
            switch (beerColor) {
                case " light ":
                    light++;
                    break;
                case " amber ":
                    amber++;
                    break;
                case " brown ":
                    brown++;
                    break;
                case " dark ":
                    dark++;
                    break;
            }
        }

        JspWriter out = getJspContext().getOut();
        String outPrint = "";
        if (light != 0)
            outPrint += "light " + light + "<hr>";
        if (amber != 0)
            outPrint += "amber " + amber + "<hr>";
        if (brown != 0)
            outPrint += "brown " + brown + "<hr>";
        if (dark != 0)
            outPrint += "dark " + dark + "<hr>";
        out.print(outPrint);
    }
}
