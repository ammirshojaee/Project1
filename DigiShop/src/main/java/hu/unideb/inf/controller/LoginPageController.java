/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.CashierDAO;
import hu.unideb.inf.JpaCashierDAO;
import hu.unideb.inf.JpaUserDAO;
import hu.unideb.inf.UserDAO;
import hu.unideb.inf.model.Cashier;
import hu.unideb.inf.model.Login_User;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 * FXML Controller class 
 *
 * @author KIMBERLEY EPELLE
 */
public class LoginPageController implements Initializable {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    void close(MouseEvent event) {

    }

    @FXML
    void pushedLogin(ActionEvent event) throws Exception{
final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        
         Login_User a=new Login_User();
        a.setName(username.getText());
        a.setPassword(password.getText());
        
        
        try (UserDAO aDAO= new JpaUserDAO()) {
            List<Login_User> aList =aDAO.getUser();
            
          
        for (Login_User user: aList ){
            
            if(user.getName().equals(a.getName())){
                
                 JOptionPane.showMessageDialog(null,"exists");
                 break;
            }
                 else{
                   JOptionPane.showMessageDialog(null,"does not exist");}
        }
           /* 
               
               
               JOptionPane.showMessageDialog(null,"exists");
              break;
               }else{
                   JOptionPane.showMessageDialog(null,"does not exist");
                  /* entityManager.getTransaction().begin();
         
          entityManager.persist(a);
          entityManager.getTransaction().commit(); aDAO.getUser();
            System.out.println(user);*/
          
            
             
            for (Login_User user: aList ){
                System.out.println(user);
            }
}
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
