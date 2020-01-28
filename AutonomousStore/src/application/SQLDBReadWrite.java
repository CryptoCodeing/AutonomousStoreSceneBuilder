	package application;	

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;



	public class SQLDBReadWrite {
		
	    @FXML
	    private static Label lblInfo;
	    
	    // Connect to your database.
	    // Replace server name, username, and password with your credentials
	    public static void InsertKundendaten(String tVorname,String tNachname,String tAdresse, String tPLZ, String tOrt, LocalDate dGeburtsdatum)  {
	    	ResultSet resultSet = null;
	    	String tinsertSql;
	    	
	    	String tconnectionUrl =
	                "jdbc:sqlserver://85.93.91.60\\SQL2019;"
	                        + "database=z_HWZAmazonGo;"
	                        + "user=AmazonGo_User;"
	                        + "password=showmesql;"
	                        + "encrypt=false;"
	                        + "trustServerCertificate=false;"
	                        + "loginTimeout=30;";	        	        	        
	        
	       tinsertSql  = "INSERT INTO Kundendaten (tVorname,tNachname,tAdresse,tPLZ,tOrt,dGeburtsdatum) VALUES " //
	                + "('"+tVorname+ "','"+tNachname+ "','"+tAdresse+ "','"+tPLZ+ "','"+tOrt+ "','"+dGeburtsdatum+ "' );"; //      

	       
	       
	        try (Connection connection = DriverManager.getConnection(tconnectionUrl);
	                PreparedStatement prepsInsertProduct = connection.prepareStatement(tinsertSql, Statement.RETURN_GENERATED_KEYS);) { 
	        		
	        	//SQL Query ausführen
	        		prepsInsertProduct.execute();
	                
	            
	            // get Inserted ID 
	        		resultSet = prepsInsertProduct.getGeneratedKeys();

	            // Anzeige Inserted ID in Konsole
	        		while (resultSet.next()) {
	        			System.out.println("Generated ID: " + resultSet.getString(1));
	            }
	        }
	        	catch (SQLException e) {
	        		e.printStackTrace();
	        }
	    }
	   


	    //Check ob Kudnen ID Vorhanden ist für Login 
	    public static  boolean AbfrageKundenID(Integer iKundenummer)
	    {


	        
	    	ResultSet resultSet = null;
	    	String tselectSQL;
	    	boolean bUservorhanden = false ;
	    	
	    	
	    	String tconnectionUrl =
	                "jdbc:sqlserver://85.93.91.60\\SQL2019;"
	                        + "database=z_HWZAmazonGo;"
	                        + "user=AmazonGo_User;"
	                        + "password=showmesql;"
	                        + "encrypt=false;"
	                        + "trustServerCertificate=false;"
	                        + "loginTimeout=30;";
	    	
	    	// SQL Query 
	    	tselectSQL =    " SELECT iKundennummer " +
	    					" FROM Kundendaten" +
	    					" WHERE iKundennummer = " + iKundenummer.toString();
	    		    
	        try (Connection connection = DriverManager.getConnection(tconnectionUrl);
	        PreparedStatement selectKundeID = connection.prepareStatement(tselectSQL, Statement.RETURN_GENERATED_KEYS);) 
	        {
	        	resultSet = selectKundeID.executeQuery();
	        		
	        		
	        		try 
	        		{
	        			//resultSet = selectKundeID.getGeneratedKeys();
	        			
	        			if(resultSet.next())
	        			{
	        				//resultSet.getInt(tconnectionUrl);
	        				bUservorhanden = true;
	        			}
	        			else
	        			{

	        				bUservorhanden = false ;
	        			}
	        			
	        		}
	        		catch(Exception e)
	        		{
	        			bUservorhanden = false ;

	        		}
	        		
	        	/*if Abfrag is NULL {
	        		
	        		bUservorhanden = false ;
	        		
	        	}
	        	
	        	elseif mehr als 1
	        	{
	        		
	        	
	        		
	        	}
	        	
	        	
	        	elseif 1 User
	        	{
	        		
	        		bUservorhanden = true;
	        	}
	        	*/
	        	
	        	
	        			

	        }
	        
	       
	        	catch (SQLException e) {
	        		e.printStackTrace();
	        }
			
	        return bUservorhanden;
	    }
	    

	    	
	}
	    
	
