package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LottoController {
	  @FXML
	    private Button btnZurueckZUProdAusVONLotto;

	    @FXML
	    private Label lblInfoLotto;

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
