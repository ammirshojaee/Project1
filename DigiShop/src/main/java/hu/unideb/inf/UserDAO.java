/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import hu.unideb.inf.model.Login_User;
import java.util.List;

/**
 *
 * @author KIMBERLET EPELLE
 */
public interface UserDAO extends AutoCloseable{
    public void saveUser(Login_User a);
       public void deleteUser(Login_User a);
         public void updateUser(Login_User a);
    public List<Login_User> getUser();
    
}
