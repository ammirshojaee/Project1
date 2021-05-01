package hu.unideb.inf.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hu.unideb.inf.model.AddProducts;
import java.net.URL;
import java.util.ResourceBundle;
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

    @FXML
    void addProduct(ActionEvent event) {
       
    }

    @FXML
    void deleteProd(ActionEvent event) {

    }

    @FXML
    void searchProd(ActionEvent event) {

    }

    @FXML
    void updateProd(ActionEvent event) {

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
