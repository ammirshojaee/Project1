/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import hu.unideb.inf.model.Login_User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author KIMBERLET EPELLE
 */
public class JpaUserDAO implements UserDAO {
    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public void saveUser(Login_User a) {
   entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUser(Login_User a) {
    entityManager.getTransaction().begin();
        
        entityManager.remove(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateUser(Login_User a) {
       
       saveUser(a);
    }

    @Override
    public List<Login_User> getUser() {
      TypedQuery<Login_User> query
              = entityManager.createQuery("SELECT a FROM Login_User a",
             Login_User.class);
      List<Login_User> users = query.getResultList();
      return  users;
    }

    @Override
    public void close() throws Exception {
     entityManager.close();
     entityManagerFactory.close();
    }
    
    
}
