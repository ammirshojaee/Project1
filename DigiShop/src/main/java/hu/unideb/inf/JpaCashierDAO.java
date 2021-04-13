/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import hu.unideb.inf.model.Cashier;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author KIMBERLET EPELLE
 */
public class JpaCashierDAO implements CashierDAO{
final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public void saveCashier(Cashier a) {
   entityManager.getTransaction().begin();
        
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCashier(Cashier a) {
    entityManager.getTransaction().begin();
        
        entityManager.remove(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateCashier(Cashier a) {
       
       saveCashier(a);
    }

    @Override
    public List<Cashier> getCashier() {
      TypedQuery<Cashier> query
              = entityManager.createQuery("SELECT a FROM Cashier a",
             Cashier.class);
      List<Cashier> cashiers = query.getResultList();
      return  cashiers;
    }

    @Override
    public void close() throws Exception {
        
     entityManager.close();
        entityManagerFactory.close();
    }
    
}
