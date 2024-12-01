import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    // stackpane itu container yang mengatur child (div)
    // scene itu objek gui (parent, width, height)
    public void start(Stage loginpage) throws Exception {
        Parent root =  FXMLLoader.load(getClass().getResource("loginpage.fxml"));
        Scene scene = new Scene(root, 360, 240);

        loginpage.setTitle("Zeppeli's listening bar");
        loginpage.setScene(scene);
        loginpage.show();
        
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }


}
