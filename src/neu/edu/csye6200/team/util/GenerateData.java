package neu.edu.csye6200.team.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import neu.edu.csye6200.team.data.DataStore;
import neu.edu.csye6200.team.data.StudentDataManagement;
import neu.edu.csye6200.team.interfaces.DataManagement;
import neu.edu.csye6200.team.objects.Student;
import neu.edu.csye6200.team.objects.Teacher;

public class GenerateData {
	
	private BufferedReader reader;
	private String[] header;
	
	public GenerateData(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if(!file.exists())
            throw new FileNotFoundException("File not found at the path specified: "+fileName);
        reader = new BufferedReader(new FileReader(file));
    }
	
	public String[] getNextRow() throws IOException{
        if (header == null)
            header = getFileHeader();
        String line = "";
        if((line = reader.readLine()) != null){
            String[] rows = line.split(",");
            return rows;
        }
        return null;
    }
    
    public String[] getFileHeader() throws IOException{
        if(header == null){
            String line = "";
            if((line = reader.readLine()) != null){
                String[] rows = line.split(",");
                header = rows;
            }
        }
        return header;
    }
    
    public void generateData(){
		try {
    	DataManagement<Student> dm1 = new StudentDataManagement();
		DataStore.getInstance().getStudents().addAll(dm1.getDataList());
		
		GenerateData reader = new GenerateData("static/teacher.csv");
		String[] teacherRow;
		reader.getNextRow();
		while((teacherRow = reader.getNextRow()) != null) {
			DataStore.getInstance().getTeachers().add(new Teacher(Integer.parseInt(teacherRow[0]),teacherRow[1],teacherRow[2]));
		}
		}catch(Exception e) {}
	}
}
