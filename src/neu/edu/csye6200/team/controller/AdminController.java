package neu.edu.csye6200.team.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import neu.edu.csye6200.main.*;

public class AdminController extends AbstractController {

    // Reference to the main application.
    private Main main;
    
    public void setApp(Main main) {
        this.main = main;
    }
    
    @FXML
    private void handleRegulationRules() throws Exception {
        main.loadRegulationRules();
    }
}