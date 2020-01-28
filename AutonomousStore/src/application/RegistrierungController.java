package application;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JLabel;

import com.sun.prism.paint.Color;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.Collation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

//TEST COmmiting
    
    
    
    @SuppressWarnings("unlikely-arg-type")
	@FXML
    void btnBenutzerkontoAnlegen_clicked(ActionEvent event) {
    	

    	String tVorname = txtVorname.getText();
    	String tNachname = txtNachname.getText();
    	String tAdresse = txtAdresse.getText();
    	String tOrt = txtOrt.getText();
    	String tPLZ = txtPLZ.getText();
    	LocalDate dGeburtsdatum = dpickerGeburtsdatum.getValue();
    	boolean valid = true;
    	
    	

    	//Check ob Kunde nicht Leer speichert
    	if(tVorname.equals(""))
    	{

    	    
    		lblInfo.setText("Fehler: Bitte erfassen Sie einen Vornamen");
    		lblInfo.setTextFill(javafx.scene.paint.Color.RED);		
    		valid = false;
    		return;
    	}

    	if(tNachname.equals(""))       	
        	{
        		lblInfo.setText("Fehler: Bitte erfassen Sie einen Nachname !");
        		lblInfo.setTextFill(javafx.scene.paint.Color.RED);	
        		
        		valid = false;
        		return;
        	}
    	
    	if(tAdresse.equals(""))
    	
    	{
    		lblInfo.setText("Fehler: Bitte erfassen Sie eine Adresse!");
    		lblInfo.setTextFill(javafx.scene.paint.Color.RED);	
    		valid = false;
    		return;
    	}
    	
    	if (tOrt.equals(""))
    	{
    		lblInfo.setText("Fehler: Bitte erfassen Sie einen Ort!");
    		lblInfo.setTextFill(javafx.scene.paint.Color.RED);	
    		valid = false;
    		return;
    	}
    	
    	if(tPLZ.equals(""))
    	{
    		lblInfo.setText("Fehler: Bitte erfassen Sie eine PLZ!");
    		lblInfo.setTextFill(javafx.scene.paint.Color.RED);	
    		valid = false;
    		return;
    	}
    	
    	if(dGeburtsdatum == null)
    	{
    		lblInfo.setText("Fehler: Bitte erfassen Sie ein Geburtsdatum!");
    		lblInfo.setTextFill(javafx.scene.paint.Color.RED);	
    		valid = false;
    		return;
    	}

    	

    	
    	SQLDBReadWrite.InsertKundendaten(tVorname,tNachname,tAdresse,tPLZ,tOrt,dGeburtsdatum);
    	
    	
    	lblInfo.setText("Ihre Registrierung war erfolgreich");
    	
    }
    
    public Label getLblInfo() {
		return lblInfo;
	}

	public void setLblInfo(Label lblInfo) {
		this.lblInfo = lblInfo;
	}

}
  
