package neu.edu.csye6200.team.view;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import neu.edu.csye6200.Main;
import neu.edu.csye6200.team.objects.Rules;
/**
 * Dialog to edit details of a person.
 * 
 * @author Marco Jakob
 */
public class RegulationRulesController {

	@FXML
    private TableView<Rules> personTable;
	@FXML
    private TableColumn<Rules, String> ageColumn;
    @FXML
    private TableColumn<Rules, String> groupSizeColumn;
    @FXML
    private TableColumn<Rules, String> ratioColumn;
    @FXML
    private TableColumn<Rules, String> maxGroupColumn;

    private Stage dialogStage;
    private Main main;
    
    @FXML
    private void initialize() {
    	
    	ageColumn.setCellValueFactory(
                cellData -> cellData.getValue().ageRangeProperty());
    	
    	groupSizeColumn.setCellValueFactory(
                cellData -> cellData.getValue().groupSizeProperty());
    	
    	ratioColumn.setCellValueFactory(
                cellData -> cellData.getValue().RatioProperty());
    	
    	maxGroupColumn.setCellValueFactory(
                cellData -> cellData.getValue().maxGroupProperty());
    	
    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMain(Main main) {
        this.main = main;
        personTable.setItems(main.getRuleDate());
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

}