import java.io.IOException;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwdInput;

    @FXML
    private TextField unameInput;

    @FXML
void loginHandler(ActionEvent event) throws IOException {
    // Ambil input dari TextField
    String inputUname = unameInput.getText();
    String inputPasswd = passwdInput.getText();

    // Beralih ke halaman berikutnya jika validasi berhasil
    Parent homeParent = FXMLLoader.load(getClass().getResource("InventoryPage.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


    if (inputUname.equals("atemin") && inputPasswd.equals("1234")) {
        stage.setScene(homeScene);
        stage.show();
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText("Autentikasi Gagal");
        alert.setContentText("Username atau password salah. Silakan coba lagi.");
        alert.showAndWait();
    }
}


}
