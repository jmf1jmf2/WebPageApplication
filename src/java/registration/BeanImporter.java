/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Jacob
 */
public class BeanImporter extends SimpleTagSupport {

    private FormBean formItems;
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        try {
            JspWriter out = getJspContext().getOut();
            JspFragment f = getJspBody();
            Class c = Class.forName("registration.FormBean");
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                String name = field.getName();
                String camelText = "get" + (name.substring(0,1).toUpperCase() + name.substring(1));
                Method m = c.getMethod(camelText);
                getJspContext().setAttribute("name", name);
                getJspContext().setAttribute("value", m.invoke(formItems));
                if (f != null) {
                    f.invoke(out);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeanImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BeanImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BeanImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BeanImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BeanImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BeanImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*try {            
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            
            
            if (f != null) {
            f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
            } catch (java.io.IOException ex) {
            throw new JspException("Error in BeanImporter tag", ex);
            }*/
    }
    
    public void setBean(FormBean in) {
        this.formItems = in;
    }
    
}
