package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ZigarettenController {
	
	@FXML
    private Label lblInfo;
	
	@FXML
    private CheckBox cbxCamel820;

    @FXML
    private CheckBox cbxMarlboro900;

    @FXML
    private TextField txtMengeproAuswahl;

    @FXML
    private CheckBox cbxAmericanSprit770;

    @FXML
    private CheckBox cbxLuckyStrike810;

    @FXML
    private Button btnZurueckZuProdAusVONZigare;

    @FXML
    private Button btnZigarettenWarenkorbHinzu;

    @FXML
    void btnZigarettenWarenkorbHinzu_clicked(ActionEvent event) {
    	//WarenkorPosition Daten
    	Integer iref_Warenkorb = 0;
    	Integer iArtikelnummer = 0;
    	String tArtikelbezeichnungBuild = "";
    	String tArtikelbezeichnung = "";
    	float fPreisProStueck = 0;
    	Integer iAnzahl = 0;
    	float fPreisPositionTotal = 0.00f;   
    	
    	try {
    		
    	if(cbxAmericanSprit770.isSelected()) {    		
    		iref_Warenkorb = LoginController.iWarenkorbID;
         	iArtikelnummer = 12001;
         	tArtikelbezeichnungBuild = ("American Spirit Orange");
         	tArtikelbezeichnung = tArtikelbezeichnungBuild;
         	fPreisProStueck = 7.7f;
         	iAnzahl = Integer.parseInt(txtMengeproAuswahl.getText());
         	fPreisPositionTotal = iAnzahl * fPreisProStueck;
 		
     	SQLDBReadWrite.INSERTWarenkorbPosition( iref_Warenkorb,  iArtikelnummer,  tArtikelbezeichnung, fPreisProStueck,  iAnzahl, fPreisPositionTotal) ;    
     	lblInfo.setText("Ihrem Produkte wurden erfolgreich zum Warenkorb hinzugefügt");
     	btnZigarettenWarenkorbHinzu.setDisable(true);
     	txtMengeproAuswahl.setDisable(true);
    	}
    	
    	if (cbxLuckyStrike810.isSelected()) {
    		iref_Warenkorb = LoginController.iWarenkorbID;
         	iArtikelnummer = 12002;
         	tArtikelbezeichnungBuild = ("Lucky Strike Blau");
         	tArtikelbezeichnung = tArtikelbezeichnungBuild;
         	fPreisProStueck = 8.1f;
         	iAnzahl = Integer.parseInt(txtMengeproAuswahl.getText());
         	fPreisPositionTotal = iAnzahl * fPreisProStueck;
 		
     	SQLDBReadWrite.INSERTWarenkorbPosition( iref_Warenkorb,  iArtikelnummer,  tArtikelbezeichnung, fPreisProStueck,  iAnzahl, fPreisPositionTotal) ;    
     	lblInfo.setText("Ihrem Produkte wurden erfolgreich zum Warenkorb hinzugefügt");
     	btnZigarettenWarenkorbHinzu.setDisable(true);
     	txtMengeproAuswahl.setDisable(true);
		}
    	
    	if (cbxCamel820.isSelected()) {
    		iref_Warenkorb = LoginController.iWarenkorbID;
         	iArtikelnummer = 12003;
         	tArtikelbezeichnungBuild = ("Camel Filter");
         	tArtikelbezeichnung = tArtikelbezeichnungBuild;
         	fPreisProStueck = 8.2f;
         	iAnzahl = Integer.parseInt(txtMengeproAuswahl.getText());
         	fPreisPositionTotal = iAnzahl * fPreisProStueck;
 		
     	SQLDBReadWrite.INSERTWarenkorbPosition( iref_Warenkorb,  iArtikelnummer,  tArtikelbezeichnung, fPreisProStueck,  iAnzahl, fPreisPositionTotal) ;    
     	lblInfo.setText("Ihrem Produkte wurden erfolgreich zum Warenkorb hinzugefügt");
     	btnZigarettenWarenkorbHinzu.setDisable(true);
     	txtMengeproAuswahl.setDisable(true);
    	}
    	
    	if (cbxMarlboro900.isSelected()) {
    		iref_Warenkorb = LoginController.iWarenkorbID;
         	iArtikelnummer = 12004;
         	tArtikelbezeichnungBuild = ("Marlboro Rot");
         	tArtikelbezeichnung = tArtikelbezeichnungBuild;
         	fPreisProStueck = 9.0f;
         	iAnzahl = Integer.parseInt(txtMengeproAuswahl.getText());
         	fPreisPositionTotal = iAnzahl * fPreisProStueck;
 		
     	SQLDBReadWrite.INSERTWarenkorbPosition( iref_Warenkorb,  iArtikelnummer,  tArtikelbezeichnung, fPreisProStueck,  iAnzahl, fPreisPositionTotal) ;    
     	lblInfo.setText("Ihrem Produkte wurden erfolgreich zum Warenkorb hinzugefügt");
     	btnZigarettenWarenkorbHinzu.setDisable(true);
     	txtMengeproAuswahl.setDisable(true);
    	}
    	
    	} 
    	catch (Exception e) {
		lblInfo.setText("Es ist ein Fehler aufgetreten: " + e.getMessage());
		
		} 	            		
         		    		
	         			 }
    
    @FXML
    void btnZurueckZuProdAusVONZigare_clicked(ActionEvent event) {
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

