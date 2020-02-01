package application;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LottoController {
	

    @FXML
    private TextField txtAnzahlSpiele;
    @FXML
    private Button btnZurueckZUProdAusVONLotto;
    @FXML
    private Label lblInfo;
    @FXML
    private AnchorPane pnlZahlentippErfassung;
    @FXML
    private Button btnZahlenAngeben;       
    @FXML
    private CheckBox cbxZusatzSpiel;    
    @FXML
    private TextField txtTippZahlen;
    
    
    @FXML
    void btnZahlenAngeben_clicked(ActionEvent event) {    	
    	pnlZahlentippErfassung.setVisible(true);
    	
    	
    	Integer iAnzahlSpiele = Integer.parseInt(txtAnzahlSpiele.getText());
    	//Checkbox zustand lesen
    	
    }
    
    
    
    
    public static void ParameterUebergabe()
	
	{}
    
    
    
    
    
    @FXML
    void btnTippAbgeben_clicked(ActionEvent event) {
    	Integer iref_Warenkorb = 0;
    	Integer iArtikelnummer = 0;
    	String tArtikelbezeichnung = "";
    	float fPreisProStueck = 0;
    	Integer iAnzahl = 0;
    	float fPreisPositionTotal = 0.00f;
    	
    	//iref_Warenkorb ;
    	iArtikelnummer = 10101010;
    	tArtikelbezeichnung = "Lotozahlentipp: " + txtTippZahlen.getText();
    	fPreisProStueck = 5.5f;
    	iAnzahl = 1;
    	fPreisPositionTotal = 5.5f;
    	
    	
    	
    	
    	if(cbxZusatzSpiel.isSelected()){} else {}
	
	
	
	
	SQLDBReadWrite.INSERTWarenkorbPosition( iref_Warenkorb,  iArtikelnummer,  tArtikelbezeichnung, fPreisProStueck,  iAnzahl, fPreisPositionTotal) ;
    	
	   	
	
    	
    }
    
    
    
    
    
	    @FXML
	    void btnZurueckZUProdAusVONLotto_clicked(ActionEvent event) {
	    		
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
