package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LebensmittelController {

	@FXML
    private Label lblInfo;
	
	@FXML
    private CheckBox cbxCocaCola295;

    @FXML
    private CheckBox cbxGoldbaeren195;

    @FXML
    private Button btnLebensmittelWarenkorbHinzu;

    @FXML
    private CheckBox cbxSnickers170;

    @FXML
    private CheckBox cbxOrbit310;

    @FXML
    private TextField txtMengeproAuswahl;

    @FXML
    private Button btnZurueckZuProd;

    @FXML
    void btnLebensmittelWarenkorbHinzu_clicked(ActionEvent event) {
    	//WarenkorPosition Daten
    	Integer iref_Warenkorb = 0;
    	Integer iArtikelnummer = 0;
    	String tArtikelbezeichnungBuild = "";
    	String tArtikelbezeichnung = "";
    	float fPreisProStueck = 0;
    	Integer iAnzahl = 0;
    	float fPreisPositionTotal = 0.00f;   
    	
    	String tAusgabeProdukteHinzugefuegt = "Ihre Produkte wurden erfolgreich zum Warenkorb hinzugefügt!";
    	
    	try {
    		
    	if(cbxSnickers170.isSelected()) {    		
    		iref_Warenkorb = LoginController.iWarenkorbID;
         	iArtikelnummer = 14001;
         	tArtikelbezeichnungBuild = ("Snickers");
         	tArtikelbezeichnung = tArtikelbezeichnungBuild;
         	fPreisProStueck = 1.7f;
         	iAnzahl = Integer.parseInt(txtMengeproAuswahl.getText());
         	fPreisPositionTotal = iAnzahl * fPreisProStueck;
 		
     	SQLDBReadWrite.INSERTWarenkorbPosition( iref_Warenkorb,  iArtikelnummer,  tArtikelbezeichnung, fPreisProStueck,  iAnzahl, fPreisPositionTotal) ;    
    	lblInfo.setText(tAusgabeProdukteHinzugefuegt);
    	lblInfo.setTextFill(javafx.scene.paint.Color.GREEN);
    	btnLebensmittelWarenkorbHinzu.setDisable(true);
    	txtMengeproAuswahl.setDisable(true);
    	}
    	
    	if (cbxGoldbaeren195.isSelected()) {
    		iref_Warenkorb = LoginController.iWarenkorbID;
         	iArtikelnummer = 14002;
         	tArtikelbezeichnungBuild = ("Haribo Goldbären");
         	tArtikelbezeichnung = tArtikelbezeichnungBuild;
         	fPreisProStueck = 1.95f;
         	iAnzahl = Integer.parseInt(txtMengeproAuswahl.getText());
         	fPreisPositionTotal = iAnzahl * fPreisProStueck;
 		
     	SQLDBReadWrite.INSERTWarenkorbPosition( iref_Warenkorb,  iArtikelnummer,  tArtikelbezeichnung, fPreisProStueck,  iAnzahl, fPreisPositionTotal) ;    
     	lblInfo.setText(tAusgabeProdukteHinzugefuegt);
     	lblInfo.setTextFill(javafx.scene.paint.Color.GREEN);
     	btnLebensmittelWarenkorbHinzu.setDisable(true);
     	txtMengeproAuswahl.setDisable(true);
		}
    	
    	if (cbxCocaCola295.isSelected()) {
    		iref_Warenkorb = LoginController.iWarenkorbID;
         	iArtikelnummer = 14003;
         	tArtikelbezeichnungBuild = ("Coca Cola Dose");
         	tArtikelbezeichnung = tArtikelbezeichnungBuild;
         	fPreisProStueck = 2.95f;
         	iAnzahl = Integer.parseInt(txtMengeproAuswahl.getText());
         	fPreisPositionTotal = iAnzahl * fPreisProStueck;
 		
     	SQLDBReadWrite.INSERTWarenkorbPosition( iref_Warenkorb,  iArtikelnummer,  tArtikelbezeichnung, fPreisProStueck,  iAnzahl, fPreisPositionTotal) ;    
     	lblInfo.setText(tAusgabeProdukteHinzugefuegt);
     	lblInfo.setTextFill(javafx.scene.paint.Color.GREEN);
     	btnLebensmittelWarenkorbHinzu.setDisable(true);
     	txtMengeproAuswahl.setDisable(true);
		}
    	
    	if (cbxOrbit310.isSelected()) {
    		iref_Warenkorb = LoginController.iWarenkorbID;
         	iArtikelnummer = 14004;
         	tArtikelbezeichnungBuild = ("Orbit Kaugummi");
         	tArtikelbezeichnung = tArtikelbezeichnungBuild;
         	fPreisProStueck = 3.1f;
         	iAnzahl = Integer.parseInt(txtMengeproAuswahl.getText());
         	fPreisPositionTotal = iAnzahl * fPreisProStueck;
 		
     	SQLDBReadWrite.INSERTWarenkorbPosition( iref_Warenkorb,  iArtikelnummer,  tArtikelbezeichnung, fPreisProStueck,  iAnzahl, fPreisPositionTotal) ;    
     	lblInfo.setText(tAusgabeProdukteHinzugefuegt);
     	lblInfo.setTextFill(javafx.scene.paint.Color.GREEN);
     	btnLebensmittelWarenkorbHinzu.setDisable(true);
     	txtMengeproAuswahl.setDisable(true);
		}
    	
    	} 
    	catch (Exception e) {
		lblInfo.setText("Es ist ein Fehler aufgetreten: " + e.getMessage());
		
		} 	            		
         		    		
	         			 }
    
    @FXML
    void btnZurueckZuProd_clicked(ActionEvent event) {
    	try {				
    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("ProdukteAuswahl.fxml"));
			Scene scene = new Scene(root);
			StageRegist.setScene(scene);
			StageRegist.show();
    		} 
		
		catch(Exception e) {
			e.printStackTrace();
	}	
    }

}