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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    private Stage stage;
private Scene scene;  
private Parent root;
String name="admin";
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
           /*it goes through the list and if the name is not found nothing
           happens but if it is, the we check if its an admin login or a cashier
           then it leads them to their respectful pages
           */
            for (Login_User user: aList ){
                if((user.getName().equals(a.getName())&& (user.getPassword().equals(a.getPassword())))==false){
                    
                }
                else{
                    if((user.getName().equals(name))&&(user.getPassword().equals(name))){
                   JOptionPane.showMessageDialog(null,"Login Successful");
                   FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/fxml/FXMLCashierScene.fxml"));
                    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(loader.load());
                    stage.setScene(scene);
                    stage.setTitle("Admin Page");
                    stage.show();
                    }
                    
                    else{
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/fxml/FXMLCashierScene.fxml"));
                    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(loader.load());
                    stage.setScene(scene);
                    stage.setTitle("Cashier Page");
                    stage.show();
                    }
                }   
           }
       
                
          
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
