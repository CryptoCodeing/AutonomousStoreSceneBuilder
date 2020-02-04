	package application;	

	import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.scene.control.Label;

	public class SQLDBReadWrite {
		

		// SQL Connection String Globale static variable, für alle Methoden zugänglich
		static String tconnectionUrl =
                "jdbc:sqlserver://85.93.91.60\\SQL2019;"
                        + "database=z_HWZAmazonGo;"
                        + "user=AmazonGo_User;"
                        + "password=showmesql;"
                        + "encrypt=false;"
                       + "trustServerCertificate=false;"
                        + "loginTimeout=30;";	
	 
	    //Insert fuer Registrierung
	    public static Integer INSERTKundendaten(String tVorname,String tNachname,String tAdresse, String tPLZ, String tOrt, LocalDate dGeburtsdatum)  {

	    	ResultSet resultSet = null;
	    	String tinsertSql;
	    	Integer iKundennummer = 0;
	    	
	    		        	        	        
	        
	       tinsertSql  = "INSERT INTO Kundendaten (tVorname,tNachname,tAdresse,tPLZ,tOrt,dGeburtsdatum) VALUES " //
	                + "('"+tVorname+ "','"+tNachname+ "','"+tAdresse+ "','"+tPLZ+ "','"+tOrt+ "','"+dGeburtsdatum+ "' );"; //      

	       
	       
	        try (Connection connection = DriverManager.getConnection(tconnectionUrl);
	                PreparedStatement prepsInsertProduct = connection.prepareStatement(tinsertSql, Statement.RETURN_GENERATED_KEYS);) { 
	        		
	        	//SQL Query ausführen
	        		prepsInsertProduct.execute();
	                
	            
	            // get Inserted ID 
	        		resultSet = prepsInsertProduct.getGeneratedKeys();

	            // Anzeige Inserted ID = Kundennummer
	        		if (resultSet.next()) {
	        			
	        			 iKundennummer = Integer.parseInt(resultSet.getString(1));
	            }
	        		else {
					iKundennummer = 0000000000000 ;
					}
	        		
	        }
	        	catch (SQLException e) {
	        		e.printStackTrace();
	        }
	        
	        return iKundennummer;
	    }
	    //Check ob Kudnen ID Vorhanden ist für Login 
	    public static  boolean AbfrageKundenIDvorhanden(Integer iKundenummer)
	    {


	        
	    	ResultSet resultSet = null;
	    	String tselectSQL;

	    	boolean bUservorhanden = false ;
	    	
	    	

	    	tselectSQL =    " SELECT iKundennummer " +
	    					" FROM Kundendaten" +
	    					" WHERE iKundennummer = " + iKundenummer.toString();
	    		    
	        try (Connection connection = DriverManager.getConnection(tconnectionUrl);
	        PreparedStatement selectKundeID = connection.prepareStatement(tselectSQL, Statement.RETURN_GENERATED_KEYS);) 
	        {
	        	resultSet = selectKundeID.executeQuery();
	        		
	        		
	        		try 
	        		{	        			
	        			if(resultSet.next())  
	        			{
	        				bUservorhanden = true;
	        			}
	        			else 
	        			{

	        				bUservorhanden = false ;
	        
	        			}
	        			
	        		}
	        		catch(Exception e)
	        		{
	        		System.out.println("Es ist ein Fehler aufgetreten" + e.getMessage());

	        		}
	        			        			

	        }
	        
	       
	        	catch (SQLException e) {
	        		e.printStackTrace();
	        }

			
	        return bUservorhanden;

	    }
	    //Erstellen eienes Warenkorb
	    public static Integer INSERTWarenkorbGenID(Integer iKundenID)	   
	    {
	    	ResultSet resultSet = null;
	    	String tInsertSQL = "";
	    	Integer iGeneratedWarenKorbID = 0;
	    	
	    	// SQL Query 
	    	tInsertSQL =    "INSERT INTO TWarenkorb (ref_Kunde) VALUES "
	    				+   "("									+ iKundenID +     ");";
	    		    
	        try (Connection connection = DriverManager.getConnection(tconnectionUrl);
	        PreparedStatement InsertWarenkorbGenID = connection.prepareStatement(tInsertSQL, Statement.RETURN_GENERATED_KEYS);) 
	        {
	        	InsertWarenkorbGenID.execute();
	        	
	        	resultSet = InsertWarenkorbGenID.getGeneratedKeys();
	        	
	        	resultSet.next();
	        	
	        	iGeneratedWarenKorbID = Integer.parseInt(resultSet.getString(1));	        		        	
	        	 
	        }
	        	catch (SQLException e) {
	        		e.printStackTrace();
	        }
	        
	        
	        return iGeneratedWarenKorbID;
	    }
	    //Erstellen einer WarenkorbPosition
	    public static boolean INSERTWarenkorbPosition(Integer iref_Warenkorb, Integer iArtikelnummer, String tArtikelbezeichnung, float fPreisProStueck, Integer iAnzahl, float fPreisPositionTotal) {
	    		    	
	    	String tInsertSQL = "";
	    	boolean bInsertErfolgreich = false;
	    	
	    	// SQL Query 
	    	tInsertSQL =    "INSERT INTO TWarenkorbPositionen (iref_Warenkorb, iArtikelnummer, tArtikelbeschreibung, fPreisProStück, iAnzahl, fPreisPositionTotal ) VALUES "
	    				+   "("+iref_Warenkorb+","+iArtikelnummer+",'"+tArtikelbezeichnung+"',"+fPreisProStueck+","+iAnzahl+","+fPreisPositionTotal+")";
	    		    
	        try (Connection connection = DriverManager.getConnection(tconnectionUrl);
	        PreparedStatement InsertWarenkorbPosition = connection.prepareStatement(tInsertSQL, Statement.RETURN_GENERATED_KEYS);) 
	        {
	        	InsertWarenkorbPosition.execute();	        
	        	   bInsertErfolgreich = true;     	        	
	        }
	        	catch (SQLException e) {
	        		e.printStackTrace();
	        		bInsertErfolgreich = false;
	        }
	        
	        
	        return bInsertErfolgreich;
	    }	    
	    //SELECT aller Kundendaten in TKundendaten
	    public static  ResultSet SELECTTKundenDaten(Integer iKundenummer)
	    {
	        
	    	ResultSet rsSELECTallKundedaten = null;
	    	String tselectSQL;

	    	tselectSQL =    " SELECT * " +
	    					" FROM Kundendaten" +
	    					" WHERE iKundennummer = " + iKundenummer.toString();
	    		    
	        try (Connection connection = DriverManager.getConnection(tconnectionUrl);
	        PreparedStatement selectKundeDaten = connection.prepareStatement(tselectSQL);) 
	        {
	        	rsSELECTallKundedaten = selectKundeDaten.executeQuery();	           			        			        			
	        }
	        	catch (SQLException e) {
	        		e.printStackTrace();
	        }

			
	        return rsSELECTallKundedaten;

	    }
	    // SELECT aller Warenkorb Positionen
	    public static  ResultSet SELECTTWarenkorbPositionen(Integer iref_Warenkorb)
	    {
	        
	    	ResultSet rsSELECTWarenkorbPositionen = null;
	    	String tselectSQL;

	    	tselectSQL =    " SELECT * " +
	    					" FROM TWarenkorbPositionen " +
	    					" WHERE iref_Warenkorb = " + iref_Warenkorb.toString();
	    		    
	        try (Connection connection = DriverManager.getConnection(tconnectionUrl);
	        PreparedStatement selectWarenkorbPositionen = connection.prepareStatement(tselectSQL);) 
	        {
	        	rsSELECTWarenkorbPositionen = selectWarenkorbPositionen.executeQuery();	           			        			        			
	        }
	        	catch (SQLException e) {
	        		e.printStackTrace();
	        }

			
	        return rsSELECTWarenkorbPositionen;

	    }		
	    //SELECT und abfüllen von Warenkorb Total Summe
	    public static float WarenkorbTOTALermitteln (Integer iref_Warenkorb) {
	    	
	    	float fWarenkorbTotal = 0.0f ;	    	
	    	ResultSet rsWarenkorbTOTAL = null;
	    	String tselectSumSQL;

	    	tselectSumSQL = " SELECT sum(fPreisPositionTotal) " +
	    					" FROM TWarenkorbPositionen " +
	    					" WHERE iref_Warenkorb = " + iref_Warenkorb.toString();
	    		    
	        try (Connection connection = DriverManager.getConnection(tconnectionUrl);
	        PreparedStatement selectWarenkorbPositionen = connection.prepareStatement(tselectSumSQL);) 
	        {
	        	rsWarenkorbTOTAL = selectWarenkorbPositionen.executeQuery();
	        	rsWarenkorbTOTAL.next();
	        	
	        	fWarenkorbTotal = rsWarenkorbTOTAL.getFloat(1);
	        }
	        	catch (SQLException e) {
	        		e.printStackTrace();
	        }

	    	
	    	return fWarenkorbTotal;
	    }
	    //Alterscheck für Zigaretten Kauf
	    public static  boolean Alterscheck(Integer iKundenummer)
	    {	ResultSet resultSet = null;
	    	String tselectSQL;
	    	Date dGeburtsdatum;
	    	//Date dDatumGrenze = 06/02/2004  ;
	    	boolean bUservorhanden = false ;
	    	
	    	
	    	tselectSQL =    " SELECT dGeburtsdatum " +
	    					" FROM Kundendaten" +
	    					" WHERE iKundennummer = " + iKundenummer.toString();
	    		    
	        try (Connection connection = DriverManager.getConnection(tconnectionUrl);
	        PreparedStatement selectKundeID = connection.prepareStatement(tselectSQL, Statement.RETURN_GENERATED_KEYS);) 
	        {
	        	resultSet = selectKundeID.executeQuery();
	        	
	        	
	        		
	        		try 
	        		{	   
	        			resultSet.next();
	        			dGeburtsdatum = resultSet.getObject("dGeburtsdatum",Date.class);
	        			
	        		
	        			
	        		}
	        		catch(Exception e)
	        		{
	        		System.out.println("Es ist ein Fehler aufgetreten" + e.getMessage());

	        		}
	        			        			

	        }
	        
	       
	        	catch (SQLException e) {
	        		e.printStackTrace();
	        }

			
	        return bUservorhanden;

	    }
	  
	    
	    
	    
	    
	    
	}
	    
	
