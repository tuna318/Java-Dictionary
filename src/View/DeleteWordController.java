package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.TreeMap;

public class DeleteWordController extends DictController implements Initializable {
    @FXML
    private Button delWord;
    private String wordToDelete;
    /*
     * init lay tu can delete (reference)
     */
    public void initData(String string) {
        wordToDelete = string;
    }
    @Override
    /*
     * xu ly  event delete
     */
    public void eventsHandle(ActionEvent event) {
        /*
         * xu ly nut yes
         */
        if(event.getTarget() == delWord) {
            deleteWord(dict, wordToDelete);
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
     * ham xoa tu khoi dict
     */
    private void deleteWord(TreeMap<String, String> dDict, String dWord) {
        dDict.remove(dWord);
    }
}
