package neu.edu.csye6200.team.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import neu.edu.csye6200.team.interfaces.DataManagement;
import neu.edu.csye6200.team.objects.Immunization;
import neu.edu.csye6200.team.util.FileIO;

/**
 * This is the implementation of Immunization data management
 * @author Huai Huang
 *
 */
public class ImmuDataManagement implements DataManagement<Immunization> {
	
	//In this case, I do not recommend you to use this method. It's meaningless to see all immunization information
	@Override
	public List<Immunization> getDataList() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * search by immunization name
	 */
	@Override
	public List<Immunization> getDataList(String key) {
		// TODO Auto-generated method stub
		List<Immunization> immus = FileIO.readFileOfMap(Immunization.class, "stuImm");
		List<Immunization> selectedImmus = new ArrayList<>();
		immus.forEach(immu -> {if(immu.getImmuName().equals(key)) selectedImmus.add(immu);});
		return selectedImmus;
	}

	@Override
	public List<Immunization> getDataList(int key) {
		// TODO Auto-generated method stub
		List<Immunization> immus = FileIO.readFileOfMap(Immunization.class, "stuImm");
		List<Immunization> selectedImmus = new ArrayList<>();
		immus.forEach(immu -> {if(immu.getStuId() == key) selectedImmus.add(immu);});
		return selectedImmus;
	}

	@Override
	public void registerOneObject(Immunization t) {
		// TODO Auto-generated method stub
		FileIO.writeFileAppended(Arrays.asList(t), "stuImm");
	}

	@Override
	public void deleteOneObject(Immunization t) {
		// TODO Auto-generated method stub
		List<Immunization> immus = FileIO.readFileOfMap(Immunization.class, "stuImm");
		immus.forEach(immu -> {if(immu.getImmuId() == t.getImmuId() && immu.getStuId() == t.getStuId()) immus.remove(immu);});
		refreshAll(immus);
	}

	@Override
	public void updateOneObject(Immunization t) {
		// TODO Auto-generated method stub
		List<Immunization> immus = FileIO.readFileOfMap(Immunization.class, "stuImm");
		immus.forEach(immu -> {if(immu.getImmuId() == t.getImmuId() && immu.getStuId() == t.getStuId()) immu = t;});
		refreshAll(immus);
	}

	@Override
	public void refreshAll(List<Immunization> list) {
		// TODO Auto-generated method stub
		FileIO.writeFile(list, Immunization.class, "stuImm");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * This method generate the basic data only if there is no data.
	 */
//	private static void initialize() {
//		// TODO Auto-generated method stub
//		if(FileIO.isFileEmpty("stuImm")) {
//			List<Immunization> immus = new ArrayList<>();
//			immus.add(new Immunization(100001, 1, "Im1", 2, new Date(System.currentTimeMillis()-4*300*24*60*60*1000)));
//			immus.add(new Immunization(100002, 1, "Im1", 2, new Date(System.currentTimeMillis()-3*271*24*60*60*1000)));
//			immus.add(new Immunization(100003, 1, "Im2", 1, new Date(System.currentTimeMillis()-3*268*23*60*60*1000)));
//			immus.add(new Immunization(100003, 2, "Im2", 1, new Date(System.currentTimeMillis()-3*268*23*60*60*1000)));
//			immus.add(new Immunization(100004, 2, "Im2", 1, new Date(System.currentTimeMillis()-3*243*24*60*60*1000)));
//			immus.add(new Immunization(100005, 1, "Im1", 2, new Date(System.currentTimeMillis()-3*344*24*60*60*1000)));
//			immus.add(new Immunization(100005, 2, "Im2", 1, new Date(System.currentTimeMillis()-3*344*24*60*60*1000)));
//			immus.add(new Immunization(100005, 3, "Im3", 1, new Date(System.currentTimeMillis()-3*344*24*60*60*1000)));
//			immus.add(new Immunization(100006, 1, "Im1", 2, new Date(System.currentTimeMillis()-2*430*23*60*60*1000)));
//			immus.add(new Immunization(100006, 2, "Im2", 1, new Date(System.currentTimeMillis()-2*430*23*60*60*1000)));
//			immus.add(new Immunization(100007, 2, "Im2", 1, new Date(System.currentTimeMillis()-2*365*24*60*60*1000)));
//			immus.add(new Immunization(100007, 3, "Im3", 1, new Date(System.currentTimeMillis()-2*365*24*60*60*1000)));
//			immus.add(new Immunization(100008, 2, "Im2", 1, new Date(System.currentTimeMillis()-2*230*24*60*60*1000)));
//			immus.add(new Immunization(100008, 3, "Im3", 1, new Date(System.currentTimeMillis()-2*230*24*60*60*1000)));
//			immus.add(new Immunization(100008, 4, "Im4", 2, new Date(System.currentTimeMillis()-2*230*24*60*60*1000)));
//			immus.add(new Immunization(100009, 1, "Im1", 2, new Date(System.currentTimeMillis()-2*230*24*59*59*1000)));
//			immus.add(new Immunization(100009, 3, "Im3", 1, new Date(System.currentTimeMillis()-2*230*24*59*59*1000)));
//			immus.add(new Immunization(100009, 4, "Im4", 2, new Date(System.currentTimeMillis()-2*230*24*59*59*1000)));
//			immus.add(new Immunization(100010, 1, "Im1", 2, new Date(System.currentTimeMillis()-2*169*24*60*60*1000)));
//			immus.add(new Immunization(100010, 2, "Im2", 1, new Date(System.currentTimeMillis()-2*169*24*60*60*1000)));
//			immus.add(new Immunization(100010, 3, "Im3", 1, new Date(System.currentTimeMillis()-2*169*24*60*60*1000)));
//			immus.add(new Immunization(100010, 4, "Im4", 2, new Date(System.currentTimeMillis()-2*169*24*60*60*1000)));
//			immus.add(new Immunization(100011, 2, "Im2", 1, new Date(System.currentTimeMillis()-233*24*60*60*1000)));
//			immus.add(new Immunization(100011, 4, "Im4", 2, new Date(System.currentTimeMillis()-233*24*60*60*1000)));
//			immus.add(new Immunization(100012, 1, "Im1", 2, new Date(System.currentTimeMillis()-300*24*60*60*1000)));
//			immus.add(new Immunization(100013, 1, "Im1", 2, new Date(System.currentTimeMillis()-209*24*60*60*1000)));
//			immus.add(new Immunization(100013, 4, "Im4", 2, new Date(System.currentTimeMillis()-209*24*60*60*1000)));
//			immus.add(new Immunization(100014, 2, "Im2", 1, new Date(System.currentTimeMillis()-191*24*60*60*1000)));
//			immus.add(new Immunization(100015, 2, "Im2", 1, new Date(System.currentTimeMillis()-120*24*60*60*1000)));
//			immus.add(new Immunization(100015, 3, "Im3", 1, new Date(System.currentTimeMillis()-120*24*60*60*1000)));
//			immus.add(new Immunization(100015, 4, "Im4", 2, new Date(System.currentTimeMillis()-120*24*60*60*1000)));
//			immus.add(new Immunization(100016, 1, "Im1", 2, new Date(System.currentTimeMillis()-120*24*59*59*1000)));
//			immus.add(new Immunization(100016, 3, "Im3", 1, new Date(System.currentTimeMillis()-120*24*59*59*1000)));
//			immus.add(new Immunization(100017, 1, "Im1", 2, new Date(System.currentTimeMillis()-24*60*60*1000)));
//			immus.add(new Immunization(100017, 3, "Im3", 1, new Date(System.currentTimeMillis()-24*60*60*1000)));
//			immus.add(new Immunization(100017, 4, "Im4", 2, new Date(System.currentTimeMillis()-24*60*60*1000)));
//			immus.add(new Immunization(100018, 1, "Im1", 2, new Date(System.currentTimeMillis()-22*24*58*60*1000)));
//			immus.add(new Immunization(100018, 2, "Im2", 1, new Date(System.currentTimeMillis()-22*24*58*60*1000)));
//			immus.add(new Immunization(100019, 2, "Im2", 1, new Date(System.currentTimeMillis()-24*60*60*1000)));
//			FileIO.writeFile(immus, Immunization.class, "stuImm");
//		}
//	}
}
