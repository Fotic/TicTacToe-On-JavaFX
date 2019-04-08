/*
    Mathima: Programatismos Diepathis Xristi
    Foititis: Paparounas Fotios
    Tmhma: Mhxanikon Pliroforikhs TEI Kavalas
    Kathigitis: Moisiadis Eleftherios, Xairi Kiourt
    Etos: 2018
*/
package TicTacToe;

import static TicTacToe.Players.getFplayer;
import static TicTacToe.Players.getSplayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TrillizaController {
   
   @FXML Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
   @FXML Button about,restart;
   @FXML Label score;
   @FXML GridPane gameBoard;

   private boolean Player = true;
   private int P1Count = 0,P2Count = 0;

   @FXML
   public void buttonClickHandler(ActionEvent evt){
        Button clickedButton = (Button) evt.getTarget();
	String buttonLabel = clickedButton.getText();

        if ("".equals(buttonLabel) && Player){  //Elenxi pios pektis exei seira
            clickedButton.setStyle("-fx-font:28 arial;-fx-text-fill: green");	
            clickedButton.setText("X");
            Player = false;
        } else if("".equals(buttonLabel) && !Player){
            clickedButton.setStyle("-fx-font:28 arial;-fx-text-fill: red");
            clickedButton.setText("O");
            Player = true;                       
        }
        
	if (CheckStatus()==1){                  //Elenxi ean uparxi nikitis
                if (Player == false){           //Elenxi pios einai o nikitis
                    PopupMsgWinner("Νικητής είναι ο/η " + getFplayer());
                    ResetGame();
                    P1Count++;}
                else {PopupMsgWinner("Νικητής είναι ο/η "+ getSplayer());
                      ResetGame();
                      P2Count++;}
        }else if(CheckStatus()==0){
            PopupMsgWinner("Ισοπαλία");
            ResetGame();}
        setScore();
   
   }	
   
    private int CheckStatus(){
	   //Grammi 1
	   if (""!=b1.getText() && b1.getText() == b2.getText() 
		   && b2.getText() == b3.getText()){
		   return 1;
	   }
	   //Grammi 2
           else if (""!=b4.getText() && b4.getText() == b5.getText() 
		   && b5.getText() == b6.getText()){
		   return 1;
	   }
	   //Grammi 3
	   else if (""!=b7.getText() && b7.getText() == b8.getText() 
		   && b8.getText() == b9.getText()){
		   return 1;
	   }
	   //Stili 1
	   else if (""!=b1.getText() && b1.getText() == b4.getText() 
		   && b4.getText() == b7.getText()){
		   return 1;
	   }
	   //Stili 2
	   else if (""!=b2.getText() && b2.getText() == b5.getText() 
		   && b5.getText() == b8.getText()){
		   return 1;
	   }
	   //Stili 3
	   else if (""!=b3.getText() && b3.getText() == b6.getText() 
		   && b6.getText() == b9.getText()){
		   return 1;
	   }
	   //Diagonios 1
	   else if (""!=b1.getText() && b1.getText() == b5.getText() 
		   && b5.getText() == b9.getText()){
		   return 1;
	   }
	   //Diagonios 2
	   else if (""!=b3.getText() && b3.getText() == b5.getText() 
		   && b5.getText() == b7.getText()){
		   return 1;
	   }
           //Isopalia
           else if (b1.getText()!=""&& b2.getText()!="" && b3.getText()!=""&&
                    b4.getText()!=""&& b5.getText()!="" && b6.getText()!=""&&
                    b7.getText()!=""&& b8.getText()!="" && b9.getText()!="")
                   return 0;
           
           else return -1;
    }
    
    private void ResetGame(){  //Kanei reset ta text(X h O) pou uparxoun mesa sta koumpia
    b1.setText("");           //kai sinama ksana kalei tin setScore.
    b2.setText("");
    b3.setText("");
    b4.setText("");
    b5.setText("");
    b6.setText("");
    b7.setText("");
    b8.setText("");
    b9.setText("");  
    setScore();
}
  
    private void setScore(){   //Emfanizei to score mesa sto Label me ID=score.
    score.setText("Score του/της " +getFplayer() +": "+P1Count+"\nScore του/της "+ getSplayer() +": "+P2Count);
    score.setStyle("-fx-font:16 calibri");
    }  

   @FXML
   public void AboutClick(){                                   //Ta properties tou About Massage
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //Ekteleite otan patisoume to koumpi "About"
        alert.setTitle("Σχετικά:");
        alert.setHeaderText(null);
        alert.setContentText("Creator: Παπρούνας Φώτιος 3792 \n\n"+
                             "Διδάσκον Καθηγητής: Μωυσιάδης Ελευθέριος\n\n" +
                             "Η εργασία δημιουργήθηκε στα πλαίσια του μαθήματος Προγραμματισμός Διεπαφής Χρήστη\n\n" +
                             "Copyright @ 2018");
        alert.showAndWait();
   }
  
   @FXML
   public void RestartGame(){ //Kanei restart-reset to Score kai to trexon game
        P1Count = 0;
        P2Count = 0;
        ResetGame();
   }
   
    private void PopupMsgWinner(String WinnerName) { //Ta properties tou Winner Massage
        Alert alert = new Alert(AlertType.INFORMATION);//Ekteleite otan teleiosi h partida
        alert.setTitle("Αποτέλεσμα:");
        alert.setHeaderText(null);
        alert.setContentText(WinnerName);
        alert.showAndWait();
    } 

}
   