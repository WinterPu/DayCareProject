package neu.edu.csye6200.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesReader {
	
	private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("static/project.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Properties getProperties() {
		return prop;
	}
	
	private PropertiesReader() {}
}
