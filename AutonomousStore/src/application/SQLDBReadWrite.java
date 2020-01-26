	package application;	

	import java.sql.*;

	public class SQLDBReadWrite {
	    // Connect to your database.
	    // Replace server name, username, and password with your credentials
	    public static void InsertKundendaten(String tVorname,String tNachname,String tAdresse, Integer iPLZ, String tOrt) { //, Date dGeburtsdatum) {
	        
	    	String connectionUrl =
	                "jdbc:sqlserver://85.93.91.60\\SQL2019;"
	                        + "database=z_HWZAmazonGo;"
	                        + "user=AmazonGo_User;"
	                        + "password=showmesql;"
	                        + "encrypt=false;"
	                        + "trustServerCertificate=false;"
	                        + "loginTimeout=30;";
	        
	        
	        ResultSet resultSet = null;
	        
	        String insertSql = "INSERT INTO Kundendaten (tVorname,tNachname,tAdresse,iPLZ,tOrt) VALUES " //,dGeburtsdatum
	                + "('"+tVorname+ "','"+tNachname+ "','"+tAdresse+ "','"+iPLZ+ "','"+tOrt+ "');"; //,'"+dGeburtsdatum+ "'
	        

	        try (Connection connection = DriverManager.getConnection(connectionUrl);
	                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {

	            prepsInsertProduct.execute();
	            // Retrieve the generated key from the insert.
	            resultSet = prepsInsertProduct.getGeneratedKeys();

	            // Print the ID of the inserted row.
	            while (resultSet.next()) {
	                System.out.println("Generated: " + resultSet.getString(1));
	            }
	        }
	        
//	        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
//	            System.out.println("HelloDB");
//	            
//	            //Erstellen des Statement in welches der Query reingeschrieben werden kann
//	            Statement statement = connection.createStatement(); {
//
//	                // Erstellen und Ausführen des Query
//	                String selectSql = "SELECT * FROM T240_Kunden";
//	                resultSet = statement.executeQuery(selectSql);
//
//	                // Print results from select statement
//	                while (resultSet.next()) {
//	                    System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6));
//	                }
//	            }
//	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
