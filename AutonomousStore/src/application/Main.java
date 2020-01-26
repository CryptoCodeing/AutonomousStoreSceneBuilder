package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import sun.security.jgss.LoginConfigImpl;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application 


{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Registrierung.fxml"));
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
		
		//SQLDBReadWrite oDBWrite = new SQLDBReadWrite();
		
		//SQLDBReadWrite.InsertKundendaten("Test","Des","Main",8989,"Test");
		
	}
	
	
}
