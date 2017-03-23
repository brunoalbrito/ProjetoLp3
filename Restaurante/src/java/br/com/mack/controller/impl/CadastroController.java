/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.UserDAO;
import br.com.mack.persistence.entities.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Bruno
 */
public class CadastroController extends AbstractController {

    UserDAO userDAO = lookupUserDAOBean();

    @Override
    public void execute() {
        User user = new User();
        user.setFullName(request.getParameter("nome_completo"));
        user.setBirthday(request.getParameter("dt_nasc"));
        user.setEmail(request.getParameter("email"));
        user.setUserName(request.getParameter("usuario"));
        user.setPassword(request.getParameter("senha"));
        
        /**
         * 
         */
        try {
            userDAO.create(user);
            request.getSession().setAttribute("usuario", user);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            returnPage = "erro.jsp";
            return;
        }
        this.returnPage = "user_area/home.jsp";
    }

    private UserDAO lookupUserDAOBean() {
        try {
            Context c = new InitialContext();
            return (UserDAO) c.lookup("java:global/Restaurante/UserDAO!br.com.mack.persistence.UserDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
