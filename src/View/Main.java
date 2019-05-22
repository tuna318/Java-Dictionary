package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.TreeMap;

public class Main extends Application {
    public static Stage parentWindow;
    @Override
    public void start(Stage stage) {
        DictController.enVi.put("aardvark","a medium-sized, burrowing, nocturnal mammal native to Africa");
        DictController.enVi.put("baron","a rank of nobility or title of honour, below Viscount");
        DictController.enVi.put("viscount","a rank of nobility or title of honour, below Count");
        DictController.viEn.put("ba tuoc","mot tuoc hieu hay cap bac trong gioi quy toc, duoi hau tuoc");
        DictController.viEn.put("hau tuoc","mot tuoc hieu hay cap bac trong gioi quy toc, duoi cong tuoc");
        DictController.viEn.put("cong tuoc","mot tuoc hieu hay cap bac trong gioi quy toc, duoi hoang tu va cong chua");
        DictController.myDict.put("1012","nguoi ba nhat cai Viet Nhat nay");
        DictController.myDict.put("ramu","reigning champion of Hedspi Speech Contest");
        DictController.myDict.put("a Tu","naiteisha cua MF, sau tam 10 phut suy nghi ve cac lua chon cua minh");
        DictController.dict = DictController.enVi;
        try {
            parentWindow = stage;
            Parent root = FXMLLoader.load(getClass().getResource("Dictionary.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Dictionary");
            stage.setScene(scene);
            stage.show();
        }  catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
