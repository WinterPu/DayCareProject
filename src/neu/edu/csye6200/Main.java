package neu.edu.csye6200;
	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import neu.edu.csye6200.team.data.ImmuDataManagement;
import neu.edu.csye6200.team.data.StudentDataManagement;
import neu.edu.csye6200.team.interfaces.DataManagement;
import neu.edu.csye6200.team.objects.Immunization;
import neu.edu.csye6200.team.objects.Student;
import neu.edu.csye6200.team.view.AdminController;
import neu.edu.csye6200.team.view.RegulationRulesController;
import neu.edu.csye6200.team.objects.Rules;

public class Main extends Application {
	
	private Stage primaryStage;
	private ObservableList<Rules> ruleDate = FXCollections.observableArrayList();
	
	public Main() {
		ruleDate.add(new Rules("6","12","4","4:1","3"));
		ruleDate.add(new Rules("13","24","5","5:1","3"));
		ruleDate.add(new Rules("25","35","6","6:1","3"));
		ruleDate.add(new Rules("36","47","8","8:1","3"));
		ruleDate.add(new Rules("48","59","12","12:1","2"));
		ruleDate.add(new Rules("60","on up","15","15:1","2"));
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,650,450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("team/view/Admin.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            
            // Give the controller access to the main app.
            AdminController controller = loader.getController();
            controller.setMainApp(this);

            // Set person overview into the center of root layout.
            root.setCenter(personOverview);
            
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showRegulationRules() {
	    try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("team/view/ViewRegulationRule.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("View State Regulation Rules");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        RegulationRulesController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setMain(this);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
		
	public static void main(String[] args) throws FileNotFoundException, IOException {
		DataManagement<Student> dm1 = new StudentDataManagement();
		System.out.println(dm1.getDataList());
//		dm.deleteOneObject(new Student(100020, "A", "B", new Date(), 30));
		DataManagement<Immunization> dm = new ImmuDataManagement();
		System.out.println(dm.getDataList(100010));
		launch(args);
	}

	public ObservableList<Rules> getRuleDate() {
		return ruleDate;
	}
}
