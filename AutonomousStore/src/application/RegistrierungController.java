package application;
import java.time.LocalDate;
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
    private TextField txtPLZ;
    @FXML
    private TextField txtOrt;
    @FXML
    private DatePicker dpickerGeburtsdatum;
    @FXML
    private Button btnBenutzerkontoAnlegen;

//TEST Commiting
    
    
    
    @FXML
    void btnBenutzerkontoAnlegen_clicked(ActionEvent event) {
    	

    	String tVorname = txtVorname.getText();
    	String tNachname = txtNachname.getText();
    	String tAdresse = txtAdresse.getText();
    	String tPLZ = txtPLZ.getText();
    	String tOrt = txtOrt.getText();
    	LocalDate dGeburtsdatum = dpickerGeburtsdatum.getValue();
    	Integer iKundennummerNEU = 0;
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
    	
    	if(tPLZ.equals(""))
    	{
    		lblInfo.setText("Fehler: Bitte erfassen Sie eine PLZ!");
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
    	
    	
    	if(dGeburtsdatum == null)
    	{
    		lblInfo.setText("Fehler: Bitte erfassen ein Geburtsdatum!");
    		lblInfo.setTextFill(javafx.scene.paint.Color.RED);	
    		valid = false;
    		return;
    	}

    	

    	
    	iKundennummerNEU = SQLDBReadWrite.InsertKundendaten(tVorname,tNachname,tAdresse,tPLZ,tOrt,dGeburtsdatum);
    	
    	
    	lblInfo.setText("Ihre Registrierung war erfolgreich, Ihre Kundennummer ist: " + iKundennummerNEU);
    	lblInfo.setTextFill(javafx.scene.paint.Color.GREEN);	
    	
    
    	
    }
    


}
  
