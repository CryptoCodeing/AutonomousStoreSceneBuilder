package application;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistrierungController {

    

    @FXML
    private Label lblInfo;
    @FXML
    private TextField txtVorname;
    @FXML
    private TextField txtNachname;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtOrt;
    @FXML
    private TextField txtPLZ ;
    @FXML
    private DatePicker dpickerGeburtsdatum;

    @FXML
    private Button btnBenutzerkontoAnlegen;


    @FXML
    void btnBenutzerkontoAnlegen_clicked(ActionEvent event) {

    	String tVorname = txtVorname.getText();
    	String tNachname = txtNachname.getText();
    	String tAdresse = txtAdresse.getText();
    	String tOrt = txtOrt.getText();
    	String tPLZ = txtPLZ.getText();
    	LocalDate dGeburtsdatum = dpickerGeburtsdatum.getValue();
    		
    	
 
    	
    	SQLDBReadWrite.InsertKundendaten(tVorname,tNachname,tAdresse,tPLZ,tOrt,dGeburtsdatum);
    	
    	
    	lblInfo.setText("Ihre Registrierung war erfolgreich");
    	
    }

}
  
