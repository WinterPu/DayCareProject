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
	public List<T> getDataList(String key);
	public List<T> getDataList(int key);
	
	public void register(T t);
	public void delete(T t);
	public void update(T t);
	
}
