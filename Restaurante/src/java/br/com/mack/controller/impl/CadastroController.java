/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.UserRestDAO;
import br.com.mack.persistence.entities.UserRest;
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

    UserRestDAO userRestDAO = lookupUserRestDAOBean();

    @Override
    public void execute() {
        UserRest rest = new UserRest();
        rest.setFullName(request.getParameter("nome_completo"));
        rest.setBirthday(request.getParameter("dt_nasc"));
        rest.setEmail(request.getParameter("email"));
        rest.setUser(request.getParameter("usuario"));
        rest.setPassword(request.getParameter("senha"));
        userRestDAO.create(rest);

        this.returnPage = "sucesso.jsp";
    }

    private UserRestDAO lookupUserRestDAOBean() {
        try {
            Context c = new InitialContext();
            return (UserRestDAO) c.lookup("java:global/Restaurante/UserRestDAO!br.com.mack.persistence.UserRestDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
