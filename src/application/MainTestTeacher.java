package application;
	
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
import javafx.stage.Stage;
import neu.edu.csye6200.team.controller.ViewTeacherController;
import neu.edu.csye6200.team.data.ImmuDataManagement;
import neu.edu.csye6200.team.interfaces.DataManagement;
import neu.edu.csye6200.team.objects.Immunization;
import neu.edu.csye6200.team.objects.Teacher;


public class MainTestTeacher extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    
    private ObservableList<Teacher> tchData = FXCollections.observableArrayList();
    
    public MainTestTeacher() {
	}
    
    public ObservableList<Teacher> getTeacherData() {
        return tchData;
    }
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("Teacher");
	        
	        initRootLayout();
	        showTeacherOverview();
	        
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
    	rootLayout = new BorderPane();
        Scene scene = new Scene(rootLayout, 650, 450);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		
		// Load root layout from fxml file.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(MainTestTeacher.class.getResource("../neu/edu/csye6200/team/controller/ViewStudentInformation.fxml"));
//            rootLayout = (BorderPane) loader.load();
 
		// Show the scene containing the root layout.
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    public void showTeacherOverview() {
    	try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainTestTeacher.class.getResource("../neu/edu/csye6200/team/controller/ViewTeacher.fxml"));
            AnchorPane teacherOverview = (AnchorPane) loader.load();
            // Set person overview into the center of root layout.
            rootLayout.setCenter(teacherOverview);

            // Give the controller access to the main app.
            ViewTeacherController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		DataManagement<Student> dm = new StudentDataManagement();
//		System.out.println(dm.getDataList());
//		dm.deleteOneObject(new Student(100020, "A", "B", new Date(), 30));
		
//		DataManagement<Immunization> dm = new ImmuDataManagement();
//		System.out.println(dm.getDataList(100010));
		launch(args);
	}
}
