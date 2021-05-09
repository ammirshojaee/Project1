package hu.unideb.inf.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hu.unideb.inf.JPAproductDAO;
import hu.unideb.inf.ProductDAO;
import hu.unideb.inf.model.AddProducts;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author KIMBERLET EPELLE
 */
public class FXMLCashierSceneController implements Initializable {
    
     public void billheader(){
       receipt.setText("---------------------------------------------"+"\n"
               + "DIGISHOP"+"\n"
               + "------------------------------------------------"+"\n"+
               "Product Name-------------Price"+"\n");
        }
     public void billfooter(){
     
     
     }
    
    @FXML
    private TextArea receipt;
    
    @FXML
    private TextField pdname;

    @FXML
    private Spinner<Integer> counter;

    @FXML
    private TextField total;
    
    @FXML
    private TextField pdPrice;

    @FXML
    private TableView<AddProducts> purchasetable;

    @FXML
    private TableColumn<AddProducts, Integer> pid;

    @FXML
    private TableColumn<AddProducts, String> pname;

    @FXML
    private TableColumn<AddProducts, Integer> qdemand;

    
    
    
    @FXML
    private TableColumn<AddProducts, Double> pricedemand;
double sum=0;
    @FXML
    void addbtn(ActionEvent event) throws Exception{
        
        
try (ProductDAO aDAO= new JPAproductDAO()){
        List<AddProducts> aList =aDAO.getProducts();
           for (AddProducts prod: aList ){
               if(prod.getName().equalsIgnoreCase(pdname.getText())){
                  pdPrice.setText(String.valueOf(prod.getPrice()));
                   int a=counter.getValue();
                   double d=prod.getPrice()*a;
                  prod.setPrice(d);
                  prod.setQuantity(a);
                   
               pid.setCellValueFactory(new PropertyValueFactory<>("id"));
               pname.setCellValueFactory(new PropertyValueFactory<>("name"));
              pricedemand.setCellValueFactory(new PropertyValueFactory<>("price"));
              qdemand.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
               
               purchasetable.getItems().add(prod);
               sum=sum+d;
               total.setText(String.valueOf(sum));
               receipt.setText(receipt.getText()+prod.getName()+"\t\t\t"
                       +String.valueOf(prod.getPrice())+"\n");
                break;
               }
            }
           
    }
    }

    @FXML
    void searchbtn(ActionEvent event) throws Exception {
    boolean found = false;
    try (ProductDAO aDAO= new JPAproductDAO()){
        List<AddProducts> aList =aDAO.getProducts();
           for (AddProducts prod: aList ){
               if(prod.getName().equalsIgnoreCase(pdname.getText())){
                   pdPrice.setText(String.valueOf(prod.getPrice()));
SpinnerValueFactory<Integer> countervalue=new SpinnerValueFactory.IntegerSpinnerValueFactory(0, prod.getQuantity(), 1);
this.counter.setValueFactory(countervalue);

            found=true;
                break;
               }
            }
           
    }
    if(found==false){
    JOptionPane.showMessageDialog(null, "No product available");
    }
    }
    
    
    @FXML
    void printreceipt(ActionEvent event) {
        Date cur=new Date();
        
receipt.setText(receipt.getText()+"========================="+"\n"+
        "Total:"+"\t\t\t"+total.getText()+"\n"+"========================="+"\n"+cur.toString());
         try {
             print(receipt.getText());
         } catch (FileNotFoundException ex) {
             Logger.getLogger(FXMLCashierSceneController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       billheader();
        // TODO
    }    
    public static void print(String n) throws FileNotFoundException {
        JOptionPane.showConfirmDialog(null, "Would you like to continue?");
        String k= System.getProperty("user.home");
        PrintWriter pw =new PrintWriter(new File(k,"/Desktop/receipt.txt"));
        pw.println(n);
        pw.close();
        
    }
}
