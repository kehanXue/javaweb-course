package servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


public class BookAddedListener implements HttpSessionAttributeListener {

    /**
     * The attributeAdded method implements the httpSessionBindingEvent to listen attribute added
     * event
     *
     * @param httpSessionBindingEvent the http session binding event
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

        String name = httpSessionBindingEvent.getName();
        Object value = httpSessionBindingEvent.getValue();
        System.out.println("Attribute added: " + name + ": " +value);
    }

    /**
     * The attributeRemoved method implements the httpSessionBindingEvent to listen attribute removed
     * event
     *
     * @param httpSessionBindingEvent the http session binding event
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

        String name = httpSessionBindingEvent.getName();
        Object value = httpSessionBindingEvent.getValue();
        System.out.println("Attribute removed: " + name + ": " +value);
    }

    /**
     * The attributeReplaced method implements the httpSessionBindingEvent to listen attribute replaced
     * event
     *
     * @param httpSessionBindingEvent the http session binding event
     */
    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

        String name = httpSessionBindingEvent.getName();
        Object value = httpSessionBindingEvent.getValue();
        System.out.println("Attribute replaced: " + name + ": " +value);
    }
}
