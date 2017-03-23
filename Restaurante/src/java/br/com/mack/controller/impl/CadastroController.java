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
        User rest = new User();
        rest.setFullName(request.getParameter("nome_completo"));
        rest.setBirthday(request.getParameter("dt_nasc"));
        rest.setEmail(request.getParameter("email"));
        rest.setUserName(request.getParameter("usuario"));
        rest.setPassword(request.getParameter("senha"));
        
        userDAO.create(rest);

        this.returnPage = "sucesso.jsp";
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
