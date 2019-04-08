/*
    Mathima: Programatismos Diepathis Xristi
    Foititis: Paparounas Fotios
    Tmhma: Mhxanikon Pliroforikhs TEI Kavalas
    Kathigitis: Moisiadis Eleftherios, Xairi Kiourt
    Etos: 2018
*/
package TicTacToe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InputNameDialogController implements Initializable {
    
    @FXML Label label;
    @FXML Button ok,clean;
    @FXML TextField text;
    private boolean fistp = true;
    
    @FXML
    public void PressedOk(Event event) {    //Theloume na ektelesti 2 fores gia na perasoume ta onoma to paikton mas
        Players usr = new Players();        //tin 2h fora sinama tha kalesei tin Trilliza kai 8a klisi tin trexon scene

        if (fistp) {
            usr.setFplayer(text.getText());
            fistp = false;
            text.setText("");
            label.setText("Δώστε το Όνομα του 2ου παίχτη:");
        } else {
            try {
                usr.setSplayer(text.getText());
                openNewScene();
                ok.getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(InputNameDialogController.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
    }

    @FXML
    public void PressedClear() {    //Katharismos tou text field
        text.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setText("Δώστε το Όνομα του 1ου παίχτη:");
    }

   private void openNewScene() throws IOException { //Kalei tin Trilliza scene
        Stage pstage = new Stage();
        BorderPane root = FXMLLoader.load(getClass().getResource("Trilliza.fxml"));
        pstage.setTitle("Τρίλιζα");
        Scene scene = new Scene(root,300,385);
        pstage.setScene(scene);
        pstage.setResizable(false);
        pstage.show();      
    }

}