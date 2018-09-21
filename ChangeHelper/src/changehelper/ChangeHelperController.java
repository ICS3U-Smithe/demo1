package changehelper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * this program calculates how much change is due in a functional GUI
 * this class handles the logic. 
 * 
 * @author Mr. Smithe
 * @version 1.0
 */
public class ChangeHelperController implements Initializable {
    
    @FXML
    private TextField amountDueField;
    @FXML
    private TextField amountReceivedField;
    @FXML
    private TextField changeDueField;
    
    
    @FXML
    private TextField twentiesField;
    @FXML
    private TextField tensField;
    @FXML
    private TextField fivesField;
    @FXML
    private TextField tooniesField;
    @FXML
    private TextField looniesField;
    @FXML
    private TextField quartersField;
    @FXML
    private TextField dimesField;
    @FXML
    private TextField nickelsField;
    @FXML
    private TextField penniesField;
    
    private double amountDue, amountReceived, changeDue;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        amountDue = Double.parseDouble(amountDueField.getText());
        amountReceived = Double.parseDouble(amountReceivedField.getText());
        changeDue = amountReceived - amountDue;
        
        changeDueField.setText("$" + changeDue);
        
        
        //TODO: Calculate change due in terms of bills and coins;
        
        
        //TODO: Update the content of the text fields. 
        twentiesField.setText("20");
        tensField.setText("12");
        fivesField.setText(changeDue + "");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // we don't need this - but it has to be here. 
    }    
}
