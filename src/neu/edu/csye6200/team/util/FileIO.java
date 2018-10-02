package neu.edu.csye6200.team.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import neu.edu.csye6200.main.PropertiesReader;

/**
 * This class provide some basic methods about reading and writing files. These methods should not be modified. Every data operation, which needs 
 * to read or write files, should use only the method provided here.
 * @author Huai Huang
 *
 */
public class FileIO<T> {
	
	private static final Properties prop = PropertiesReader.getProperties();
	private static final String filePath = prop.getProperty("file");
	private static final SimpleDateFormat sdf = new SimpleDateFormat(prop.getProperty("dateFormat"));

	//This is the basic method to write a file.
	public static <T> void writeFile(List<T> data, Class<T> clazz) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath)))) {
			StringBuffer sb = new StringBuffer("");
			Arrays.asList(clazz.getDeclaredFields()).forEach(f -> {sb.append(f.getName()+",");});
			sb.delete(sb.length()-1, sb.length());
			sb.append("\n");
			data.forEach(o -> {sb.append(o);});
			bw.write(sb.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//This is the method to append something in a file.
		public static <T> void writeFileAppended(List<T> data) {
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath), true))) {
				StringBuffer sb = new StringBuffer("");
				data.forEach(o -> {sb.append(o);});
				bw.write(sb.toString());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	
	//This is the basic method to transit a CSV file into data list. It can automatically package the data into certain type that you defined.
	/**
	 * Using java reflection to do this thing. Normally you should choose this method to read data. A CSV file always have column titles.
	 * @param clazz The reflection of the class you need to read.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> readFileOfMap(Class<T> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		List<T> data = new ArrayList<>();
		try(BufferedReader bw = new BufferedReader(new FileReader(filePath))) {
			String[] titles = new String[fields.length];
			int count = 0; //just to make sure getting the title.
			while(bw.ready()) {
				String[] values = bw.readLine().split(",");
				if(count == 0) {//First Line, record as title
					for(int i = 0; i < values.length; i++) {
						titles[i] = values[i];
					}
					count++; continue;
				}
				Map<String, String> pairs = new HashMap<>();
				for(int i = 0; i < values.length; i++) {
					pairs.put(titles[i], values[i]);
				}
				T o = (T) clazz.getConstructors()[0].newInstance();
				for(Field field : fields) {
					field.setAccessible(true);//Fields are private, must make them accessible
					if(pairs.containsKey(field.getName())) {
						switch (field.getType().getSimpleName()) {//To handle different type of values, use switch typeName to do it in different ways
						case "int":case "Integer":field.set(o, Integer.valueOf(pairs.get(field.getName())));break;
						case "double":case "Double":field.set(o, Double.valueOf(pairs.get(field.getName())));break;
						case "String":field.set(o, pairs.get(field.getName()));break;
						case "Date":field.set(o, sdf.parse(pairs.get(field.getName())));break;
						default:break;
						}
					}
				}
				data.add(o);
				count++;
			}
			return data;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	//This is the basic method to transit a CSV file into data list. It can automatically package the data into certain type that you defined.
//	/**
//	 * Using java reflection to do this thing. If the data distribute like a list(no column title), use this method.
//	 * Make sure the order of the value is the same as the order of the fields of the T
//	 * @param clazz The reflection of the class you need to read.
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static <T> List<T> readFileOfList(Class<T> clazz) {
//		Field[] fields = clazz.getDeclaredFields();
//		List<T> data = new ArrayList<>();
//		try(BufferedReader bw = new BufferedReader(new FileReader(filePath))) {
//			while(bw.ready()) {
//				String[] values = bw.readLine().split(",");
//				T o = (T) clazz.getConstructors()[0].newInstance();
//				for(int i = 0; i < values.length; i++) {
//					fields[i].setAccessible(true);//Fields are private, must make them accessible
//					switch (fields[i].getType().getSimpleName()) {//To handle different type of values, use switch typeName to do it in different ways
//					case "int":case "Integer":fields[i].set(o, Integer.valueOf(values[i]));break;
//					case "double":case "Double":fields[i].set(o, Double.valueOf(values[i]));break;
//					case "String":fields[i].set(o, values[i]);break;
//					case "Date":fields[i].set(o, sdf.parse(values[i]));break;
//					default:break;
//					}
//				}
//				data.add(o);
//			}
//			return data;
//		} catch (Exception e) {
//			// TODO: handle exception
//			return null;
//		}
//	}
}
