/*
    Mathima: Programatismos Diepathis Xristi
    Foititis: Paparounas Fotios
    Tmhma: Mhxanikon Pliroforikhs TEI Kavalas
    Kathigitis: Moisiadis Eleftherios, Xairi Kiourt
    Etos: 2018
*/
package TicTacToe;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
        @Override
	public void start(Stage primaryStage) throws Exception {
            AnchorPane root = FXMLLoader.load(getClass().getResource("InputNameDialog.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Καταχώριση Oνομάτων:");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
 	}
	
	public static void main(String[] args) {
		launch(args);
	}
   
}