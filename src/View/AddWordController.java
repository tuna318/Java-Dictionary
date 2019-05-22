package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.util.TreeMap;

public class AddWordController extends DictController implements Initializable {
    @FXML
    private TextField adWord;
    @FXML
    private Button addButton;
    @FXML
    private TextArea adMeaning;
    @FXML
    private Button backAButton;
    /*
     * xu ly add
     */
    @Override
    public void eventsHandle(ActionEvent event) {
        /*
         * xu ly nut add
         */
        if (event.getTarget() == addButton) {
            if (!adWord.getText().equals("") && !adMeaning.getText().equals("")) { //neu TextField va Area ko rong
                addWord(dict, adWord.getText(), adMeaning.getText());
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Notify.fxml"));
                    Parent loadScreen = (Parent) loader.load();
                    Scene newScene = new Scene(loadScreen);
                    Stage mainStage = Main.parentWindow;
                    mainStage.setTitle("Notify");
                    mainStage.setScene(newScene);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {                                                              // con khong thi bao loi
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("NotifyFailEdit2.fxml"));
                    Parent loadScreen = (Parent) loader.load();
                    Scene newScene = new Scene(loadScreen);
                    Stage mainStage = Main.parentWindow;
                    mainStage.setTitle("NotifyFailAdd");
                    mainStage.setScene(newScene);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        /*
         * xu ly nut backAButton trong NotifyFailEdit2.fxml
         */
        else if(event.getTarget() == backAButton) {
            try {
                Stage mainStage = showStageAdd("AddWord.fxml"); // tro ve man hinh addWord
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        /*
         * xu ly nut cancel(backButton)
         */
        else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Dictionary.fxml"));
                Parent loadScreen = (Parent) loader.load();
                Scene newScene = new Scene(loadScreen);
                Stage mainStage = Main.parentWindow;
                mainStage.setTitle("Dictionary");
                mainStage.setScene(newScene);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /*
     * ham addword
     */
    private void addWord(TreeMap<String, String> aDict, String aWord, String aMeaning) {
        aDict.put(aWord, aMeaning);
    }
}
