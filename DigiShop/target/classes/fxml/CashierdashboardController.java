/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author amirs
 */
public class CashierdashboardController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private Button Dashboard;
    @FXML
    private Button Products;
    @FXML
    private Button Signout;
    @FXML
    private BarChart<String, Number> Chart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        XYChart.Series<String, Number> Series = new XYChart.Series<>();
        Series.setName("Best seller");
        Series.getData().add(new XYChart.Data<>("Iphone12",150));
        Series.getData().add(new XYChart.Data<>("Sony playstation 5",100));
        Series.getData().add(new XYChart.Data<>("Galaxy s21",70));
        
        Chart.getData().add(Series);
    }    
    
}
