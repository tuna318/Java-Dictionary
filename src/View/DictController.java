package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;



public class DictController implements Initializable {
    @FXML
    private MenuItem closeItem;
    @FXML
    private MenuItem enViItem;
    @FXML
    private MenuItem viEnItem;
    @FXML
    private MenuItem myDictItem;
    @FXML
    private Button editWord;
    @FXML
    private Button deleteWord;
    @FXML
    private Button addWord;
    @FXML
    private Button searchWord;
    @FXML
    private TextField word;
    @FXML
    private TextArea meaning;
    /*
     * EditWord.fxml
     */
    @FXML
    private TextField edWord;
    @FXML
    private Button updateButton;
    @FXML
    private TextArea edMeaning;
    @FXML
    private Button backButton;
    @FXML
    private Button okButton;

    public String temp;
    /*
     * static variable de khong bi thay doi moi khi load man hinh (load lai cac instance)
     */
    public static TreeMap<String, String> dict = new TreeMap<>();
    public static TreeMap<String, String> enVi = new TreeMap<>();
    public static TreeMap<String, String> viEn = new TreeMap<>();
    public static TreeMap<String, String> myDict = new TreeMap<>();
    /*public TreeMap<String, String> dict = new TreeMap<>();
    public TreeMap<String, String> enVi = new TreeMap<>();
    public TreeMap<String, String> viEn = new TreeMap<>();
    public TreeMap<String, String> myDict = new TreeMap<>();
    */

    @Override
    public void initialize(URL Location, ResourceBundle resources) {
    }
    /*
     * xu ly cac events chinh
     *
     */
    @FXML
    public void eventsHandle(ActionEvent event) {
        /*
         * xu ly nut edit
         * neu khong co tu do thi bao loi
         */
        if(event.getTarget() == editWord) {
            temp = new String(word.getText()); //temp de truyen sang textfield cua editword
            System.out.println(temp);
            if (searchWord(dict, word.getText()) != null) {
                try {
                    Stage mainStage = showStageEdit(temp,"EditWord.fxml"); //Man hinh editword
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("NotifyFailEdit.fxml"));
                    Parent loadScreen = (Parent) loader.load();
                    Scene newScene = new Scene(loadScreen);
                    Stage mainStage = (Stage)  ((Node)event.getSource()).getScene().getWindow();
                    mainStage.setTitle(editWord.getText());
                    mainStage.setScene(newScene);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        /*
         * xu ly nut delete
         * neu khong co tu do thi bao loi
         */
        else if(event.getTarget() == deleteWord) {
            temp = new String(word.getText());
            if (searchWord(dict, word.getText()) != null) {
                 try {
                    Stage mainStage = showStageDelete(temp,"DeleteWord.fxml"); //man hinh delete
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("NotifyFailEdit.fxml"));
                    Parent loadScreen = (Parent) loader.load();
                    Scene newScene = new Scene(loadScreen);
                    Stage mainStage = (Stage)  ((Node)event.getSource()).getScene().getWindow();
                    mainStage.setTitle(deleteWord.getText());
                    mainStage.setScene(newScene);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        /*
         * xu ly nut add
         */
        else if(event.getTarget() == addWord) {
            try {
                Stage mainStage = showStageAdd("AddWord.fxml");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        /*
         * xu ly nut search
         */
        else if(event.getTarget() == searchWord) {
            meaning.setText(searchWord(dict, word.getText()));
        }
        /*
         * menu chuyen dict sang cac dict khac nhau
         */
        else if(event.getTarget() == enViItem) {
            dict = enVi;
        }
        else if(event.getTarget() == viEnItem) {
            dict = viEn;
        }
        else if(event.getTarget() == myDictItem) {
            dict = myDict;
        }
        /*
         * ket thuc chuong trinh
         */
        else if(event.getTarget() == closeItem) {
            System.exit(0);
        }
        /*
         * xu ly cac nut BackButton
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
     * ham tim kiem tu
     */
    public String searchWord(TreeMap<String, String> sDict, String sWord) {
        return sDict.get(sWord);
    }
    /*
     * ham hien thi man hinh edit truyen vao 1 string tu DictController
     */
    public Stage showStageEdit(String paraWord, String resource) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        Parent loadScreen = (Parent) loader.load();
        Scene newScene = new Scene(loadScreen);
        Stage editStage = Main.parentWindow;
        editStage.setTitle("EditWord");
        editStage.setScene(newScene);
        EditWordController controller = loader.<EditWordController>getController();
        controller.initData(paraWord);
        return editStage;
    }
    /*
     * ham hien thi man hinh delete truyen vao 1 string tu DictController
     */
    public Stage showStageDelete(String paraWord, String resource) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        Parent loadScreen = (Parent) loader.load();
        Scene newScene = new Scene(loadScreen);
        Stage deleteStage = Main.parentWindow;
        deleteStage.setTitle("DeleteWord");
        deleteStage.setScene(newScene);
        DeleteWordController controller = loader.<DeleteWordController>getController();
        controller.initData(paraWord);
        return deleteStage;
    }
    /*
     * ham hien thi man hinh add
     */
    public Stage showStageAdd(String resource) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        Parent loadScreen = (Parent) loader.load();
        Scene newScene = new Scene(loadScreen);
        Stage addStage = Main.parentWindow;
        addStage.setTitle("AddWord");
        addStage.setScene(newScene);
        return addStage;
    }
}
