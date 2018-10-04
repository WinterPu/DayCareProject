package application;
	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import neu.edu.csye6200.team.data.StudentDataManagement;
import neu.edu.csye6200.team.interfaces.DataManagement;
import neu.edu.csye6200.team.objects.Student;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		DataManagement<Student> dm = new StudentDataManagement();
		System.out.println(dm.getDataList());
		dm.deleteOneObject(new Student(100020, "A", "B", new Date(), 30));
		launch(args);
	}
}
