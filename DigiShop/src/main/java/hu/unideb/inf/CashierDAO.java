/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import hu.unideb.inf.model.Cashier;
import java.util.List;

/**
 *
 * @author KIMBERLET EPELLE
 */
public interface CashierDAO extends AutoCloseable{
    public void saveCashier(Cashier a);
       public void deleteCashier(Cashier a);
         public void updateCashier(Cashier a);
    public List<Cashier> getCashier();
}
