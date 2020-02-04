package application;
import java.sql.ResultSet;

import com.sun.crypto.provider.RSACipher;

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
	    private Button btnLottoSpielen;

	    @FXML
	    private Label lblKundennummer;

	    @FXML
	    private Button btnZigarettenKaufen;

	    @FXML
	    private Label lblWarenkorbInfo;

	    @FXML
	    private Button btnLebensmittelKaufen;

	    @FXML
	    private ListView<ResultSet> listviewWarenkorbPositionen;

	    @FXML
	    private Label lblInfoProdAus;

	    @FXML
	    private Button btnZurueckZUAnmelden;

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
				    	 SQLDBReadWrite.SELECTTKundenDaten(iKundenummer);
				    	 
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
				
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("ZigarettenKaufen.fxml"));
				Scene scene = new Scene(root);
				StageRegist.setScene(scene);
				StageRegist.show();
				
				// TODO Alterscheck
				
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
	    void btnZurueckZUAnmelden_clicked(ActionEvent event) {

	    	try {
				
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
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
				String test;
				
				ResultSet rsWarenkorbPositionen;				
				rsWarenkorbPositionen= SQLDBReadWrite.SELECTTWarenkorbPositionen(iref_Warenkorb);
				
			//	while (
						//rsWarenkorbPositionen.next();
						//)
			//	{
				//test = rsWarenkorbPositionen.getString(1);
					
					//lblInfoProdAus.setText(test);
					
				//listviewWarenkorbPositionen.getItems().addAll(rsWarenkorbPositionen);				
	//			}
				
				pnlWarenkorbAnzeigen.setVisible(true);
				} 
			catch (Exception e) {
				lblInfoProdAus.setText("Es ist ein Fehler aufgetreten: "+e.getMessage());
			}
	    	
		
			
						
		}
	    
	    @FXML
	    void btnCheckout_clicked(ActionEvent event) {

	    	float fWarenkorbTotal = 0 ;
	    	
	    	
	    	fWarenkorbTotal = SQLDBReadWrite.WarenkorbTOTALermitteln(iref_Warenkorb);
	    	
	    	lblInfoProdAus.setText("Total des Warenkorbs: "+fWarenkorbTotal);
	    	
	    	
	    	//lblInfoProdAus.setText("Der Betrag von: "+fWarenkorbTotal +"CHF wurde Ihrem Konto belastet. Vielen Dank für Ihren Einkauf ");
	    	
	    	
	    }	    
	}
	
	

