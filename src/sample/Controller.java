package sample;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Controller {

    // Arcade Game GUI Elements
    public TableView<ElectronicGame> GameTable;
    public TableColumn<ElectronicGame, String> titleColumn;
    public TableColumn<ElectronicGame, Integer> releaseDateColumn;
    public TableColumn<ElectronicGame, Integer> soldColumn;
    public TableColumn<ElectronicGame, Double> revWithIntColumn;
    public TableColumn<ElectronicGame, Double> revWithoutIntColumn;

    public void initialize() {
        // This gets called BEFORE the User ever uses the UI
        ElectronicGame.setControllerMain(this);

        // Wire table's columns with fields in ToDoItem object
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("ReleaseDate"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("GameTitle"));
        soldColumn.setCellValueFactory(new PropertyValueFactory<>("AmountSold"));
        revWithIntColumn.setCellValueFactory(new PropertyValueFactory<>("RevWithInf"));
        revWithoutIntColumn.setCellValueFactory(new PropertyValueFactory<>("RevWithoutInf"));


        ArcadeGame.initialize();
        ElectronicGame.initialize();
        ElectronicGame.describeAll();
    }
    void updateGameUI() {
        // Delete every item from UI
        GameTable.getItems().clear();
        ArrayList<ElectronicGame> allGames = ElectronicGame.getGames();
        if (allGames != null) {
            allGames.forEach(electronicGame -> {
                GameTable.getItems().add(electronicGame);
            });
        }
    }

}
