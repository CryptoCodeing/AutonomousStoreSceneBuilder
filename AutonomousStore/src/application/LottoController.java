package application;

import java.awt.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LottoController {
	

    @FXML
    private TextField txtAnzahlSpiele;
    @FXML
    private Button btnZurueckZUProdAusVONLotto;
    @FXML
    private Label lblInfo;
    @FXML
    private AnchorPane pnlZahlentippErfassung;
    @FXML
    private Button btnZahlenAngeben;       
    @FXML
    private CheckBox cbxZusatzSpiel;
    
    
    @FXML
    void btnZahlenAngeben_clicked(ActionEvent event) {
    	Integer iAnzahlSpiele = Integer.parseInt(txtAnzahlSpiele.getText());
   
    	
    	//CHeckbox zustand lesen
    	if(cbxZusatzSpiel.isSelected()){
    		   
    		
    		
    		
    		} else {
    		   
    		}
    	
    	
    	
    	
    	
    	   	
    }
    
    
    
    
    
    
    
    
    
    
	    @FXML
	    void btnZurueckZUProdAusVONLotto_clicked(ActionEvent event) {
	    		
	    	try {				
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("ProdukteAuswahl.fxml"));
				Scene scene = new Scene(root);
				StageRegist.setScene(scene);
				StageRegist.show();
	    		} 
			
			catch(Exception e) {
				e.printStackTrace();
		}	
	    	
	    		}
					


							
}
