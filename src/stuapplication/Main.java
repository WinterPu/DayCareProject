package stuapplication;
	
import java.io.InputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import neu.edu.csye6200.team.controller.ImmunizationCheckController;
import neu.edu.csye6200.team.controller.StudentEnterController;
import neu.edu.csye6200.team.controller.UpdateImmunizationController;
import neu.edu.csye6200.team.controller.ViewStudentController;
import neu.edu.csye6200.team.objects.Student;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;

/**
 * 
 * @author Qianru
 * Main Class controlling interface switching
 */
public class Main extends Application {
	private Stage stage; 
	private Student student;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			goStudentEnter();
			//goViewStudent();
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void goStudentEnter() throws Exception{
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();  
		String path = "/FXML/StudentEnter.fxml";
		InputStream in = Main.class.getResourceAsStream(path);  
        loader.setBuilderFactory(new JavaFXBuilderFactory());  
        loader.setLocation(Main.class.getResource(path));  
		StudentEnterController econtroller;
		AnchorPane root;
		try {  
            root = (AnchorPane) loader.load(in);  
        } finally {  
            in.close();  
        }   
		Scene scene = new Scene(root,700,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		econtroller = loader.getController();
		System.out.println(econtroller);
		econtroller.setApp(this);
	}

	public void goViewStudent(Student stu) throws Exception {
		// TODO Auto-generated method stub
		ViewStudentController.student = stu;
		FXMLLoader loader = new FXMLLoader();  
		String path = "/FXML/ViewStudentInformation.fxml";
		InputStream in = Main.class.getResourceAsStream(path);  
        loader.setBuilderFactory(new JavaFXBuilderFactory());  
        loader.setLocation(Main.class.getResource(path));  
		ViewStudentController vcontroller;
		BorderPane root;
		try {  
            root = (BorderPane) loader.load(in);  
        } finally {  
            in.close();  
        }   
		Scene scene = new Scene(root,700,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		vcontroller = loader.getController();
		System.out.println(vcontroller);
		vcontroller.setApp(this);
	}

	public void goImmunization(Student stu) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Pass success");
		ImmunizationCheckController.student = stu;
		FXMLLoader loader = new FXMLLoader();  
		String path = "/FXML/ImmunizationStatus.fxml";
		InputStream in = Main.class.getResourceAsStream(path);  
        loader.setBuilderFactory(new JavaFXBuilderFactory());  
        loader.setLocation(Main.class.getResource(path));  
		ImmunizationCheckController imcontroller;
		AnchorPane root;
		try {  
            root = (AnchorPane) loader.load(in);  
        } finally {  
            in.close();  
        }   
		Scene scene = new Scene(root,700,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		imcontroller = loader.getController();
		imcontroller.setApp(this);
		//System.out.println(student+"    Main, before");
		//imcontroller.setStudent(student);
		//System.out.println(student+"    Main, after");
		stage.show();
	}
	
	public void goUpdate(Student stu) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Pass success");
		UpdateImmunizationController.student = stu;
		FXMLLoader loader = new FXMLLoader();  
		String path = "/FXML/UpdateImmunizations.fxml";
		InputStream in = Main.class.getResourceAsStream(path);  
        loader.setBuilderFactory(new JavaFXBuilderFactory());  
        loader.setLocation(Main.class.getResource(path));  
		UpdateImmunizationController upcontroller;
		AnchorPane root;
		try {  
            root = (AnchorPane) loader.load(in);  
        } finally {  
            in.close();  
        }   
		Scene scene = new Scene(root,700,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		upcontroller = loader.getController();
		upcontroller.setApp(this);
		//System.out.println(student+"    Main, before");
		//imcontroller.setStudent(student);
		//System.out.println(student+"    Main, after");
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
