package hu.unideb.inf.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hu.unideb.inf.JPAproductDAO;
import hu.unideb.inf.ProductDAO;
import hu.unideb.inf.model.AddProducts;
import hu.unideb.inf.model.Category;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author bideo
 */
public class AddproductController implements Initializable {
  ObservableList pList= FXCollections.observableArrayList();
    private void loadData(String nm){
   pList.removeAll(pList);
    
    pList.addAll(nm);
    category.getItems().addAll(pList);
    
    }
    @FXML
    private TextField pname;

    @FXML
    private TextField pdescription;

    @FXML
    private TextField price;

    @FXML
    private TextField pQuantity;

    @FXML
    private ComboBox<String> category;
    
Date currentdate=new Date();

    @FXML
    void addProduct(ActionEvent event) throws Exception {
       AddProducts dew= new AddProducts();
       dew.setName(pname.getText());
       dew.setDescription(pdescription.getText());
       dew.setPrice(Double.parseDouble(price.getText()));
       dew.setQuantity(Integer.parseInt(pQuantity.getText()));
       dew.setEntryDate(currentdate);
       boolean found=false;
       try (ProductDAO aDAO= new JPAproductDAO()){
       aDAO.saveProduct(dew);
       List<Category> kList =aDAO.getCategory();
         for (Category cat: kList){
               if(cat.getCatName().equals(category.getValue())){
               cat.getProducts().add(dew);
               ((JPAproductDAO)aDAO).saveCategory(cat);
               found=true;
               }
                }
         if(found==false){
              Category red =new Category();
              red.setCatName(category.getValue());
              red.getProducts().add(dew);
              ((JPAproductDAO)aDAO).saveCategory(red);
              
              
         
         }
       }
    }

    @FXML
    void deleteProd(ActionEvent event) throws Exception{
try (ProductDAO aDAO= new JPAproductDAO()){
        List<AddProducts> aList =aDAO.getProducts();
           for (AddProducts prod: aList ){
               if(prod.getName().equals(pname.getText())){
                   aDAO.deleteProduct(prod);
              
               }
                  System.out.println(prod);
            }
           }
       
    }

    @FXML
    void searchProd(ActionEvent event) throws Exception {
        try (ProductDAO aDAO= new JPAproductDAO()){
             
           List<AddProducts> aList =aDAO.getProducts();
           for (AddProducts prod: aList ){
               if(prod.getName().equals(pname.getText())){
                  // pid.setText(String.valueOf(prod.getId()));
                  category.setValue(prod.getCategory().getCatName());
                  pdescription.setText(prod.getDescription());
                  pQuantity.setText(String.valueOf(prod.getQuantity()));
                  price.setText(String.valueOf(prod.getPrice())); 
                
                  
            }
           }
        }

    }

    @FXML
    void updateProd(ActionEvent event) throws Exception {
    AddProducts dew= new AddProducts();
       dew.setName(pname.getText());
       dew.setDescription(pdescription.getText());
       dew.setPrice(Double.parseDouble(price.getText()));
       dew.setQuantity(Integer.parseInt(pQuantity.getText()));
       dew.setEntryDate(currentdate);
       
       try (ProductDAO aDAO= new JPAproductDAO()){
       aDAO.saveProduct(dew);
       List<Category> kList =aDAO.getCategory();
         for (Category cat: kList){
               if(cat.getCatName().equals(category.getValue())){
               cat.getProducts().add(dew);
               ((JPAproductDAO)aDAO).saveCategory(cat);
               }
                }
       }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     ProductDAO aDAO= new JPAproductDAO();
    List<Category> kList =aDAO.getCategory();
         for (Category cat: kList){
               loadData(cat.getCatName());
                }

// TODO
    }    
    
}
