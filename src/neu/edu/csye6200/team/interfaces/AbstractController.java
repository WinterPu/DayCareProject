package neu.edu.csye6200.team.interfaces;

import java.util.List;

/**
 * This interface based on my own understanding for JavaFX framework. Methods should be implements by on Controller called 
 * ModelAndViewController, and actual data is transported by interface DayCareOperation
 * @author Huai Huang
 *
 * @param <T>
 */
public interface AbstractController<T> {

	public void showList(List<T> data);
	public void acceptDataFromView(T t);
	public void acceptDataListFromView(List<T> data);
	public void showOperation();
	public void showNotification();
}
