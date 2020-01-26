package application;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ProdAusController {

	@FXML
	private Label lblInfoProdAus ;

	    @FXML
	    private ImageView imgZigaretten;

	    @FXML
	    void btnLottoSpielen_clicked (ActionEvent event) {
	    	lblInfoProdAus.setText("Hello World");
	    }

	}
	
	

