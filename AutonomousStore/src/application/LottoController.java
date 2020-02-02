package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LottoController {
	
	@FXML
    public TextField txtTippZahlen;
    @FXML
    public TextField txtAnzahlSpiele;
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
    private Button btnTippAbgeben;
    
    Integer iWarenkorbID;
    Integer iVerbleibendeSpiele = 0;
 	Integer iGespielteSpiele = 0;
    
    
    
  
    
    
    @FXML
    void btnZahlenAngeben_clicked(ActionEvent event) {    
    	pnlZahlentippErfassung.setVisible(true);
    }
    
  
    @FXML
    void btnTippAbgeben_clicked(ActionEvent event) {	
	 	//Handling Anzahl Spiele Daten
    	Integer iAnzahlSpiele = Integer.parseInt(txtAnzahlSpiele.getText());
	 	//WarenkorPosition Daten
    	Integer iref_Warenkorb = 0;
    	Integer iArtikelnummer = 0;
    	String tArtikelbezeichnungBuild = "";
    	String tArtikelbezeichnung = "";
    	float fPreisProStueck = 0;
    	Integer iAnzahl = 0;
    	float fPreisPositionTotal = 0.00f;
    	
    	
    	
    	   
    	
        	
        	   
         		
         		    		
         		iref_Warenkorb = LoginController.iWarenkorbID;
             	iArtikelnummer = 10101010;
             	tArtikelbezeichnungBuild = ("Lotozahlentipp: " + txtTippZahlen.getText());
             	tArtikelbezeichnung = tArtikelbezeichnungBuild;
             	fPreisProStueck = 5.5f;
             	iAnzahl = 1;
             	fPreisPositionTotal = 5.5f;
         		
             	SQLDBReadWrite.INSERTWarenkorbPosition( iref_Warenkorb,  iArtikelnummer,  tArtikelbezeichnung, fPreisProStueck,  iAnzahl, fPreisPositionTotal) ;
             	
             		iGespielteSpiele += 1;
             		
             		iVerbleibendeSpiele = iAnzahlSpiele-iGespielteSpiele;
             		lblInfo.setText("Sie haben noch "+iVerbleibendeSpiele+". Tipps.");             		
             		lblInfo.setFont(new Font("Arial", 14));
             		
        	if (iAnzahlSpiele==iGespielteSpiele)
        	{
        	lblInfo.setText(iAnzahlSpiele+". Tipps wurden dem Warenkorb hinzugefügt, Viel Glück!");
        	lblInfo.setFont(new Font("Arial", 16));
        	lblInfo.setTextFill(javafx.scene.paint.Color.GREEN);
        	btnTippAbgeben.setDisable(true);
        	}
	
	
	
    	
	   	
	
    	
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
