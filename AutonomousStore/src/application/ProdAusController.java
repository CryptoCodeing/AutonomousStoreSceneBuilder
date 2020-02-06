package application;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProdAusController {

	
	@FXML
    private Button btnCheckout;

    @FXML
    private ImageView imgZigaretten;

    @FXML
    private Label lblInfo;

    @FXML
    private Button btnLottoSpielen;

    @FXML
    private Button btnZigarettenKaufen;

    @FXML
    private Label lblWarenkorbnummerAnzeige;

    @FXML
    private Label lblWarenkorbInfo;

    @FXML
    private Button btnLebensmittelKaufen;

    @FXML
    private ListView<?> listviewWarenkorbPositionen;

    @FXML
    private Button btnWarenkorbAnzeigen;

    @FXML
    private AnchorPane pnlWarenkorbAnzeigen;

    Integer iref_Warenkorb=LoginController.iWarenkorbID;
	    
	    //Kunden Detail Daten Anzeigen 
	    public static void KundeDetailAnzeigen(Integer iKundenummer)
	    
	    { 
	    	  
	    		//Muss so oder so nochmals ein SQL gwemacht werden der Kudne gibt nur die ID ein der Rest wird mit SQL gemacht 
	    	try {
				    	// SQLDBReadWrite.SELECTTKundenDaten(iKundenummer);
				    	 
				 //LM so kann Warenkorb ID gehot werden  Integer iWarenkorbID =  LoginController.iWarenkorbID;
				    	 
				   
				   //	lblKundenummerAnzeigen.getText()
	    	
			} 
			 
			catch(Exception e) {
				e.printStackTrace();
			}
	    }
	  
	    @FXML	    
	    void btnLottoSpielen_clicked (ActionEvent event) {
	    	try {
				
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("LottoSpielen.fxml"));
				Scene scene = new Scene(root);
				StageRegist.setScene(scene);
				StageRegist.show();
				
			} 
			
			catch(Exception e) {
				e.printStackTrace();
			}
	    }

	    @FXML
	    void btnZigarettenKaufen_clicked(ActionEvent event) {
try {
	boolean bAlterscheckPositiv = false; 
				
	    									
				
			bAlterscheckPositiv =	SQLDBReadWrite.Alterscheck(LoginController.iKundennummer);
				
			if (bAlterscheckPositiv)				
			{
			Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("ZigarettenKaufen.fxml"));
			Scene scene = new Scene(root);
			StageRegist.setScene(scene);
			StageRegist.show();				
			}
			else
			{
			lblInfo.setText("Leider sind Sie zu Jung um Zigaretten kaufen zu dürfen!");
			lblInfo.setTextFill(javafx.scene.paint.Color.RED);
			btnZigarettenKaufen.setDisable(true);				
			}
						
				} 
			
			catch(Exception e) {
				e.printStackTrace();
			}
	    }

	    @FXML
	    void btnLebensmittelKaufen_clicked(ActionEvent event) {
try {
				
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("LebensmittelKaufen.fxml"));
				Scene scene = new Scene(root);
				StageRegist.setScene(scene);
				StageRegist.show();
			} 
			
			catch(Exception e) {
				e.printStackTrace();
			}
	    }
	   
	    @FXML
	    void btnWarenkorbAnzeigen_clicked(ActionEvent event) {
			try {	
				//String test;
				
				//ResultSet rsWarenkorbPositionen;				
				//rsWarenkorbPositionen= SQLDBReadWrite.SELECTTWarenkorbPositionen(iref_Warenkorb);
				
			//	while (
						//rsWarenkorbPositionen.next();
						//)
			//	{
				//test = rsWarenkorbPositionen.getString(1);
					
					//lblInfo.setText(test);
					
				//listviewWarenkorbPositionen.getItems().addAll(rsWarenkorbPositionen);				
	//			}		
//				listviewWarenkorbPositionen.set
//				
//
//				while (rsWarenkorbPositionen.next()) {
//				    ResultSet mExample = new Resultset();      
//				    mExample.ID = resSet.getInt("ExampleID");
//				    mExample.name = resSet.getString("ExampleName");
//				    [..]
//				    mExampleList.add(mExample);
//				}
//				TODO Abfüllen von Resultset in Listview
//				
				
 				lblWarenkorbnummerAnzeige.setText(Integer.toString(iref_Warenkorb));						
				pnlWarenkorbAnzeigen.setVisible(true);
				} 
			catch (Exception e) {
				lblInfo.setText("Es ist ein Fehler aufgetreten: "+e.getMessage());
			}
	    	
		
			
						
		}
	    
	    @FXML
	    void btnCheckout_clicked(ActionEvent event) {

	    	float fWarenkorbTotal = 0;
	    	Integer iKundennummer = 0;
	    	
	    	
	    	iKundennummer = LoginController.iKundennummer;
	    	fWarenkorbTotal = SQLDBReadWrite.WarenkorbTOTALermitteln(iref_Warenkorb);
	    	lblInfo.setText("Ihrem Kundenkontonr: "+iKundennummer+", wurde der Betrag: "+fWarenkorbTotal +"CHF belastet. Herzlichen Dank für Ihren Einkauf. ");    	
	    	lblInfo.setTextFill(javafx.scene.paint.Color.GREEN);
	    	
	    	btnLebensmittelKaufen.setDisable(true);
	    	btnLottoSpielen.setDisable(true);
	    	btnWarenkorbAnzeigen.setDisable(true);
	    	btnZigarettenKaufen.setDisable(true);
	    }	    
}
	
	

