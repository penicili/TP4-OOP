import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;




public class InventoryPageController {
    String title;
    String creator;
    int total;
    int ready;
    int rented;
    int available;



    @FXML
    private TableColumn<Album, String> albumColumn;
    
    @FXML
    private TableColumn<Album, String> artistColumn;
    
    @FXML
    private TableColumn<Album, Integer> availColumn;
    
    @FXML
    private TableColumn<Album, Integer> totalColumn;

    @FXML
    private TableView<Album> tabelini;

    
    @FXML
    private TextField rentedInput;
    
    @FXML
    private TextField titleInput;
    
    @FXML
    private TextField totalInput;
    
    @FXML
    private Button updateButton;
    
    @FXML
    private TextField artistInput;

    @FXML
    private Button createButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button rentButton;

    ObservableList<Album> albumArray = FXCollections.observableArrayList();

    @FXML
    void createHandler(ActionEvent event) {
        
        try {
            title = titleInput.getText();
            creator = artistInput.getText();
            total = Integer.valueOf(totalInput.getText());
            rented = Integer.valueOf(rentedInput.getText());
            available = total - rented;
            Album album = new Album(title, creator, total, rented, available);
            int x = album.getAvailable();
            albumArray.add(album);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Album berhasil ditambahkan");
            alert.setContentText("album "+ x+ " berhasil dihapus");
            alert.showAndWait();
            clear();

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Masukkan data yang benar pada field");
            alert.showAndWait();
        }

    }

    @FXML
    void deleteHandler(ActionEvent event) {
        try {
            title = (titleInput.getText());


            for (Album i : albumArray) {
                if (i.getAlbumName() == title) {
                    albumArray.remove(i);
                    break;
                }
            }
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Album berhasil dihapus");
            alert.setContentText("album"+ title+ "berhasil dihapus");
            alert.showAndWait();

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Kesalahan dalam input data");
            alert.setContentText(String.valueOf(e));
            alert.showAndWait();
        }
    }
    

    @FXML
    void rentHandler(ActionEvent event) {
        int index = 0;

        try {
            title = titleInput.getText();
            creator = artistInput.getText();
            total = Integer.valueOf(totalInput.getText());
            rented = Integer.valueOf(rentedInput.getText()) + 1;
            available = total - rented;
            Album album = new Album(title, creator, total, rented, available);

            for (Album i : albumArray) {
                if (i.getAlbumName().equals(title)) {
                    albumArray.set(index, album);
                    break;
                }
                index++;
            }

            clear();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Kesalahan dalam input data");
            alert.setContentText("Silahkan cek data yang anda masukan");
            alert.showAndWait();
        }

    }

    @FXML
    void updateHandler(ActionEvent event) {
        int index = 0;

        try {
            title = titleInput.getText();
            creator = artistInput.getText();
            total = Integer.valueOf(totalInput.getText());
            rented = Integer.valueOf(rentedInput.getText());
            available = total - rented;
            Album album = new Album(title, creator, total, rented, available);

            for (Album i : albumArray) {
                if (i.getAlbumName().equals(title)) {
                    albumArray.set(index, album);
                    break;
                }
                index++;
            }

            clear();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Kesalahan dalam input data");
            alert.setContentText("Silahkan cek data yang anda masukan");
            alert.showAndWait();
        }
    }

    @FXML
    void select(MouseEvent event){
        try {
            if (event.getClickCount() == 1) {

                titleInput.setText(String.valueOf(tabelini.getSelectionModel().getSelectedItem().getAlbumName()));
                // titleInput.setDisable(true);
                totalInput.setText(String.valueOf(tabelini.getSelectionModel().getSelectedItem().getTotal()));
                artistInput.setText(String.valueOf(tabelini.getSelectionModel().getSelectedItem().getArtist()));
                rentedInput.setText(String.valueOf(tabelini.getSelectionModel().getSelectedItem().getRented()));

            }
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("No data");
            alert.setContentText("Please select filled row only");
            alert.showAndWait();
        } 
    }

    public void initialize() {
        albumColumn.setCellValueFactory(new PropertyValueFactory<Album, String>("albumName"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<Album, String>("artist"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<Album, Integer>("total"));
        availColumn.setCellValueFactory(new PropertyValueFactory<Album, Integer>("available"));
        tabelini.setItems(albumArray);
    }

    void clear(){
        titleInput.clear();
        totalInput.clear();
        artistInput.clear();
        rentedInput.clear();
    }
}
