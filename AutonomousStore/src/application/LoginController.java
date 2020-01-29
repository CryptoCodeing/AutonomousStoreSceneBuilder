package application;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	    @FXML
	    private Button btnAnmelden;

	    @FXML
	    private Button btnRegistrierung;

	    @FXML
	    private TextField txtKundennummer;

	    @FXML
	    private Label lblInfo;
	    
	    @FXML
	    void btnAnmelden_clicked (ActionEvent event) {
	    	
	    	try {
	    	// Check ob Kundennummereingabe durch Kunde leer ist
	    	if (txtKundennummer.getText().isEmpty()) 
    		{lblInfo.setText("Bitte erfassen Sie Ihre Kundennummer oder registrieren Sie sich, "
    				+ "sofern Sie keine Kundennummer besitzen.");   
    		lblInfo.setTextFill(javafx.scene.paint.Color.RED);
    		
    		return;}  			      	    	
	    	
	    	
	   System.out.println("TEST");
	    		// User eingabe in Variable abfüllen
		    	Integer iKundenummer = Integer.parseInt(txtKundennummer.getText());		    		    	   
		    	boolean valid = true;
	    		
				if(SQLDBReadWrite.AbfrageKundenID(iKundenummer))
	    	    
				{
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("ProdukteAuswahl.fxml"));
				Scene scene = new Scene(root);
				StageRegist.setScene(scene);
				StageRegist.show();
				}
				else {
		    		lblInfo.setText("Diese Kundennummer ist nicht vorhanden. "
		    				+ "Bitte erfassen Sie eine gültige Kundennummer");
		    		lblInfo.setTextFill(javafx.scene.paint.Color.RED);				
				} 
	    	}
			catch(Exception e) {
				//e.printStackTrace();
				lblInfo.setText("Es ist ein Fehler aufgetreten: "+ e.getMessage()) ; 
				}
	    	
}
	    @FXML
	    void btnRegistrierung_clicked(ActionEvent event) {
	    	
	    	try {
				
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("Registrierung.fxml"));
				Scene scene = new Scene(root,400,400);
				StageRegist.setScene(scene);
				StageRegist.show();
			} 
			
			catch(Exception e) {
				e.printStackTrace();
			}
	    }
}
