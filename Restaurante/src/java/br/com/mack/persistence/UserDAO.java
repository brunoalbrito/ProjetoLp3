/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.persistence;

import br.com.mack.persistence.entities.User;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */
@LocalBean
@Stateful
public class UserDAO implements GenericDAO<User> {

    @PersistenceContext(unitName = "RestaurantePU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public void create(User e) {
        try {
            em.persist(e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<User> readAll() {
        Query q = em.createQuery("SELECT u FROM User u");
        List<User> lista = q.getResultList();
        return lista;
    }

    @Override
    public User readById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void update(User e) {
        em.persist(e);
    }

    @Override
    public void delete(User e) {
        em.remove(em.merge(e));
    }

    public User findByUserAndPassword(String userName, String password) {
        try {
            return (User) em.createQuery("select u from User u where u.userName = :un and u.password = :p")
                    .setParameter("un", userName)
                    .setParameter("p", password)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
