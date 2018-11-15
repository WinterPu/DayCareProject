package neu.edu.csye6200.main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import neu.edu.csye6200.team.*;
import neu.edu.csye6200.team.controller.*;
import neu.edu.csye6200.team.data.*;
import neu.edu.csye6200.team.interfaces.*;
import neu.edu.csye6200.team.objects.*;
import neu.edu.csye6200.team.util.*;

public class Main extends Application {
	
	private ObservableList<Rules> ruleDate = FXCollections.observableArrayList();
    private static ObservableList<Teacher> tchData = FXCollections.observableArrayList();
    
	private Stage stage; 
	private Student student;
	private AnchorPane root;
	private Scene scene;
	
	private List<Student> students = new ArrayList<>();
	private List<Teacher> teachers = new ArrayList<>();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			initialize();
			
//			loadStudentInput();
			//goViewStudent();
			loadProgramPanel();
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initialize() {
		root = new AnchorPane();
		scene = new Scene(root,800,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		
	}
	
	public void loadProgramPanel() throws Exception {
		this.stage.setTitle("My Day Care ");
		AnchorPane pane = new AnchorPane();
		BackgroundPanelController controller = null ;
		controller = loadPane("static/FXML/BackgroundPanel.fxml",pane,controller);
		controller.setApp(this);
		System.out.println(controller);
	}
	
	
	
	
	
	public void loadStudentInput() throws Exception{
		AnchorPane pane = new AnchorPane();
		StudentEnterController controller = null;
		loadPane( "static/FXML/StudentEnter.fxml",pane,controller);
	}
	
	public void loadStudentView() throws Exception{
		BorderPane pane = new BorderPane();
		ViewStudentController controller = null;
		loadPane("static/FXML/ViewStudentInformation.fxml",pane,controller);
	}
	
	public void loadImmunizationView() throws Exception{
		AnchorPane pane = new AnchorPane();
		ImmunizationCheckController controller = new ImmunizationCheckController();
		loadPane("static/FXML/ImmunizationStatus.fxml",pane,controller);
	}
	
	public void loadTeacher() throws Exception{
		this.stage.setTitle("Teacher");
		AnchorPane pane = new AnchorPane();
		ViewTeacherController controller = null;
		loadPane("static/FXML/ViewTeacher.fxml",pane,controller);
	}
	
	

	
	
	public void loadAddStudent(Classroom classroom) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		FileInputStream fxmlStream = new FileInputStream("static/FXML/AddChild.fxml");
        AnchorPane pane = (AnchorPane) loader.load(fxmlStream);

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Add new student");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(stage);
        Scene scene = new Scene(pane);
        dialogStage.setScene(scene);

        AddStudentController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setApp(this);
        controller.setClassroom(classroom);

        dialogStage.showAndWait();
	}
	
	public void loadAddTeacher() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		FileInputStream fxmlStream = new FileInputStream("static/FXML/AddTeacher.fxml");
        AnchorPane pane = (AnchorPane) loader.load(fxmlStream);

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Add new teacher");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(stage);
        Scene scene = new Scene(pane);
        dialogStage.setScene(scene);

        AddTeacherController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setApp(this);

        dialogStage.showAndWait();
	}
	
	public void loadClassroonInfo(Classroom classroom) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		FileInputStream fxmlStream = new FileInputStream("static/FXML/Classroom Info.fxml");
        AnchorPane pane = (AnchorPane) loader.load(fxmlStream);

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Add new teacher");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(stage);
        Scene scene = new Scene(pane);
        dialogStage.setScene(scene);

        ClassroomInfoController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setApp(this);
        controller.setClassroom(classroom);
        
        dialogStage.showAndWait();
	}
	
	
	public void loadRegulationRules() throws Exception {
        FXMLLoader loader = new FXMLLoader();
		FileInputStream fxmlStream = new FileInputStream("static/FXML/ViewRegulationRule.fxml");
        AnchorPane pane = (AnchorPane) loader.load(fxmlStream);

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("View State Regulation Rules");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(stage);
        Scene scene = new Scene(pane);
        dialogStage.setScene(scene);

        // Set the person into the controller.
        RegulationRulesController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setApp(this);

        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();
	}
	
	
	
	public <TP extends Pane ,TC extends AbstractController> TC loadPane(String path, TP pane, TC controller) throws Exception {
		FXMLLoader loader = new FXMLLoader();  
		FileInputStream fxmlStream = new FileInputStream(path);
		
		pane = (TP)loader.load(fxmlStream);
	
		root.getChildren().setAll(pane);
	  
		System.out.println(pane.getClass().getName());
		controller = loader.getController();
		System.out.println(controller.getClass().getName());
	
		controller.setApp(this);
		return controller;
	}
		
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		DataManagement<Student> dm1 = new StudentDataManagement();
//		System.out.println(dm1.getDataList());
////		dm.deleteOneObject(new Student(100020, "A", "B", new Date(), 30));
//		DataManagement<Immunization> dm = new ImmuDataManagement();
//		System.out.println(dm.getDataList(100010));
//		
//		// Read in teacher.csv into tchData
//		DataManagement<Teacher> dmTeacher = new TeacherDataManagement();
//		tchData = FXCollections.observableArrayList(dmTeacher.getDataList());
		launch(args);
	}

	
	
	public ObservableList<Rules> getRuleDate() {
		return ruleDate;
	}
	
    public ObservableList<Teacher> getTeacherData() {
        return tchData;
    }
    
	public Stage getStage() {
		return stage;
	}
    
    
//	public void showRegulationRules() {
//    try {
//        // Load the fxml file and create a new stage for the popup dialog.
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(Main.class.getResource("team/view/ViewRegulationRule.fxml"));
//        AnchorPane page = (AnchorPane) loader.load();
//
//        // Create the dialog Stage.
//        Stage dialogStage = new Stage();
//        dialogStage.setTitle("View State Regulation Rules");
//        dialogStage.initModality(Modality.WINDOW_MODAL);
//        dialogStage.initOwner(primaryStage);
//        Scene scene = new Scene(page);
//        dialogStage.setScene(scene);
//
//        // Set the person into the controller.
//        RegulationRulesController controller = loader.getController();
//        controller.setDialogStage(dialogStage);
//        controller.setMain(this);
//
//        // Show the dialog and wait until the user closes it
//        dialogStage.showAndWait();
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
}
