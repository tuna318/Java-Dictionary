package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.TreeMap;

public class EditWordController extends DictController implements Initializable {
    @FXML
    private TextField edWord;
    @FXML
    private Button updateButton;
    @FXML
    private TextArea edMeaning;
    @FXML
    private Button backEButton;
    public static String temp1; //static variable de khong bi thay doi khi load screen
    /*
     * ham khoi tao cho textfield edWord
     */
    void initData(String string) {
        edWord.setText(string);
    }
    /*
     * xu ly edit
     */
    @Override
    public void eventsHandle(ActionEvent event) {
        /*
         * xu ly nut edit
         */
        if(event.getTarget() == updateButton) {
            //temp1 = new String(edWord.getText());
            if (!edMeaning.getText().equals("")) { //neu TextArea edMeaning ko rong
                //updateWord(dict, edWord.getText(), edMeaning.getText());
                dictWord.setWord(edWord.getText());
                dictWord.setMeaning(edMeaning.getText());
                databaseMN.updateWord(dictWord, currentDict);
                //System.out.println(searchWord(dict, edWord.getText()));
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Notify.fxml"));
                    Parent loadScreen = (Parent) loader.load();
                    Scene newScene = new Scene(loadScreen);
                    Stage mainStage = Main.parentWindow;
                    mainStage.setTitle("Notify");
                    mainStage.setScene(newScene);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {                                //con neu rong chuyen sang man hinh fail
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/NotifyFailEdit1.fxml"));
                    Parent loadScreen = (Parent) loader.load();
                    Scene newScene = new Scene(loadScreen);
                    Stage mainStage = Main.parentWindow;
                    mainStage.setTitle("NotifyFailEdit");
                    mainStage.setScene(newScene);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }
        /*
         * xu ly nut backEButton trong NotifyFailEdit1.xml
         */
        else if(event.getTarget() == backEButton) {
            try {
                Stage mainStage = showStageEdit(temp1,"../View/EditWord.fxml"); // dua tro lai man hinh edit voi word co san
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        /*
         * xu ly nut cancel(backButton)
         */
        else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Dictionary.fxml"));
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
     * ham editword
     */


    //private void updateWord(TreeMap<String, String> uDict, String uWord, String uMeaning) {
     //   uDict.replace(uWord, uMeaning);
    //}

}
