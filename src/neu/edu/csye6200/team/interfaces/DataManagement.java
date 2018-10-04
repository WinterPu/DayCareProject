package neu.edu.csye6200.team.interfaces;

import java.util.List;

/**
 * Basic Data Operation Interface
 * This interface provide abstract method for accessing and operating data
 * @author Huai Huang
 * 
 * @param <T> The general type refers to the object needed to be operated
 * 
 */
public interface DataManagement<T> {

	//Using overload to separate the same type method has different arguments 
	public List<T> getDataList();
	//Tell me if you want to use this method
	public List<T> getDataList(String key);
	//This is the method using primary key search
	public List<T> getDataList(int key);
	//Conditional search
	public List<T> getDataList(int min, int max);
	public List<T> getDataList(String min, String max);
	
	//These methods are safe. If the object you operate on doesn't actually exists in the data file, nothing will happens.
	public void registerOneObject(T t);
	public void deleteOneObject(T t);
	public void updateOneObject(T t);
	
	//Rewrite the file with new data
	public void refreshAll(List<T> list);
}
