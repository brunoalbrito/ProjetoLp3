/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.UserDAO;
import br.com.mack.persistence.entities.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 31595472
 */
public class LoginController extends AbstractController{
    UserDAO userDAO = lookupUserDAOBean();

    @Override
    public void execute() {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        List<User> users = null;
        
        users = userDAO.readAll();
        
        for (User user : users) {
            if(user.getUserName().equals(usuario) && user.getPassword().equals(senha)){
                System.out.println(user);
                break;
            }
        }
        
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
