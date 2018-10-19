package neu.edu.csye6200;
	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import neu.edu.csye6200.team.data.ImmuDataManagement;
import neu.edu.csye6200.team.data.StudentDataManagement;
import neu.edu.csye6200.team.interfaces.DataManagement;
import neu.edu.csye6200.team.objects.Immunization;
import neu.edu.csye6200.team.objects.Student;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,650,450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("team/view/Admin.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            root.setCenter(personOverview);
            
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		DataManagement<Student> dm = new StudentDataManagement();
//		System.out.println(dm.getDataList());
//		dm.deleteOneObject(new Student(100020, "A", "B", new Date(), 30));
		DataManagement<Immunization> dm = new ImmuDataManagement();
		System.out.println(dm.getDataList(100010));
		launch(args);
	}
}
