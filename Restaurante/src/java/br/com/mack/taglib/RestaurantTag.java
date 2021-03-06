/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.taglib;

import br.com.mack.persistence.entities.Restaurant;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Bruno
 */
public class RestaurantTag extends SimpleTagSupport {

    private List<Restaurant> items;

    public void setItems(List<Restaurant> items) {
        this.items = items;
    }

    private StringWriter sw = new StringWriter();

    @Override
    public void doTag() {
        try {
            JspWriter out = getJspContext().getOut();
            for (Restaurant restaurant : items ) {
                out.println( "<div id='bloco'>"
                        + "<div id='\"description\"'><h1>"+restaurant.getName()+"</h1><h3>Endereço</h3><p>"+restaurant.getLocation().getAddress()+"</p></div>"
                                + "<div id='\"foto\"'><img src="+restaurant.getImage()+"></div>"
                                        + "</div>");
            }
//            out.print("<h1>Hello World!</h1>");
        } catch (IOException ex) {
            Logger.getLogger(RestaurantTag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
