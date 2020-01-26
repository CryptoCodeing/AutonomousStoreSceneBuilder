package application;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ProdAusController {

	@FXML
	private Label lblInfo ;

	    @FXML
	    private ImageView imgZigaretten;

	    @FXML
	    void imgZigaretten_clicked(ActionEvent event) {
	    	lblInfo.setText("Hello WOrld");
	    }

	}
	
	

