/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.CommonUserDAO;
import br.com.mack.persistence.entities.User;
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

    CommonUserDAO userDAO = lookupUserDAOBean();

    @Override
    public void execute() {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        User user = null;
        user = userDAO.login(usuario, senha);
        
        if(user != null){
            this.returnPage = "user_area/home.jsp";
            this.request.getSession().setAttribute("usuario", user);
        }else{
            this.returnPage = "erro.jsp";
            this.request.getSession().setAttribute("errorMessages", new String[]{"Usuário ou senha incorreto!"});
        }
    }

    private CommonUserDAO lookupUserDAOBean() {
        try {
            Context c = new InitialContext();
            return (CommonUserDAO) c.lookup("java:global/Restaurante/UserDAO!br.com.mack.persistence.UserDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
