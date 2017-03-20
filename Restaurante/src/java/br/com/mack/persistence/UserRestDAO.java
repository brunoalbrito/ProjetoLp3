/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.persistence;

import br.com.mack.persistence.entities.UserRest;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */
@LocalBean
@Stateful
public class UserRestDAO implements GenericDAO<UserRest> {

    @PersistenceContext(unitName = "RestaurantePU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public void create(UserRest e) {
        em.persist(e);
    }

    @Override
    public List<UserRest> readAll() {
        Query q = em.createQuery("SELECT u FROM UserRest u");
        List<UserRest> lista = q.getResultList();
        return lista;
    }

    @Override
    public UserRest readById(long id) {
        return em.find(UserRest.class, id);
    }

    @Override
    public void update(UserRest e) {
        em.persist(e);
    }

    @Override
    public void delete(UserRest e) {
        em.remove(em.merge(e));
    }

}
