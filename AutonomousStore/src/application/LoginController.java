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
	    	 

	  
		    	//Check ob Kunden id geschrieben wurde
		    	Integer iKundenummer = Integer.parseInt(txtKundennummer.getText());		    	
	    	    //SQLDBReadWrite.AbfrageKundenID(iKundenummer);
		    	boolean valid = true;
	    	    
	    	
	    	
	    	try {
				if(SQLDBReadWrite.AbfrageKundenID(iKundenummer))
	    	    
				{
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("ProdukteAuswahl.fxml"));
				Scene scene = new Scene(root);
				StageRegist.setScene(scene);
				StageRegist.show();
				}
				else {
		    		System.out.println("got u hacker ");
				}
			} 
			
			catch(Exception e) {
				//e.printStackTrace();
				System.out.println("got u hacker ");
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
