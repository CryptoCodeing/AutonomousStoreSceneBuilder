package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ZigarettenController {

    @FXML
    private TextField txtMengeproAuswahl;

    @FXML
    private Button btnZigarettenWarenkorbHinzu;

    @FXML
    void btnZigarettenWarenkorbHinzu_clicked(ActionEvent event) {
    	txtMengeproAuswahl.setText("Hello World");
    }

}

