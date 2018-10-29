package neu.edu.csye6200.team.view;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import neu.edu.csye6200.Main;

public class AdminController {

    // Reference to the main application.
    private Main main;
    
    public void setMainApp(Main main) {
        this.main = main;
    }
    
    @FXML
    private void handleRegulationRules() {
        main.showRegulationRules();
    }
}