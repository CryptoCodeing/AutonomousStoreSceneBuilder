	package application;	

	import java.sql.*;
import java.time.LocalDate;

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
		
	    public static int InsertKundendaten(String tVorname,String tNachname,String tAdresse, String tPLZ, String tOrt, LocalDate dGeburtsdatum)  {
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
	    public static void AbfrageKundenID(Integer iKundenummer)
	    {
	    	ResultSet resultSet = null;
	    	String tselectSQL;
	    
	    	// SQL Query 
	    	tselectSQL =    " SELECT iKundennummer " +
	    					" FROM Kundendaten" +
	    					" WHERE iKundennummer = " + iKundenummer.toString();
	    		    
	        try (Connection connection = DriverManager.getConnection(tconnectionUrl);
	        PreparedStatement selectKundeID = connection.prepareStatement(tselectSQL, Statement.RETURN_GENERATED_KEYS);) 
	        {
	        	selectKundeID.execute();
	        
	        	

	        	
	        	
	        }
	        	catch (SQLException e) {
	        		e.printStackTrace();
	        }
	    
	    }
	    
	    

	    public static int INSERTWarenkorbGenID(Integer iKundenID)
	    {
	    	ResultSet resultSet = null;
	    	String tInsertSQL = "";
	    	Integer iGeneratedWarenKorbID = 0;
	    	
	    	// SQL Query 
	    	tInsertSQL =    "INSERT INTO TWarenkorbPositionen (ref_Kunde) VALUES "
	    				+   "("									+ iKundenID +     ")";
	    		    
	        try (Connection connection = DriverManager.getConnection(tconnectionUrl);
	        PreparedStatement InsertWarenkorbGenID = connection.prepareStatement(tInsertSQL, Statement.RETURN_GENERATED_KEYS);) 
	        {
	        	InsertWarenkorbGenID.execute();
	        	
	        	resultSet = InsertWarenkorbGenID.getGeneratedKeys();
	        	 iGeneratedWarenKorbID = Integer.parseInt(resultSet.getString(1));	        		        	
	        	 
	        }
	        	catch (SQLException e) {
	        		e.printStackTrace();
	        }
	        
	        
	        return iGeneratedWarenKorbID;
	    }
	    
	    	
	    
	}
	    
	
