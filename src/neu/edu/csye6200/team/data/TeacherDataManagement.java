package neu.edu.csye6200.team.data;

import java.util.ArrayList;
import java.util.List;

import neu.edu.csye6200.team.interfaces.DataManagement;
import neu.edu.csye6200.team.objects.Teacher;
import neu.edu.csye6200.team.util.FileIO;

public class TeacherDataManagement implements DataManagement<Teacher> {

	@Override
	public List<Teacher> getDataList() {
		return FileIO.readFileOfMap(Teacher.class, "teacher");
	}

	@Override
	public List<Teacher> getDataList(String key) {
		return null;
	}

	@Override
	public List<Teacher> getDataList(int key) {
		List<Teacher> ts = new ArrayList<>();
		getDataList().forEach(t -> {if(t.getTchId() == key) ts.add(t);});
		return ts;
	}

	@Override
	public List<Teacher> getDataList(int min, int max) {
		return null;
	}

	@Override
	public List<Teacher> getDataList(String min, String max) {
		List<Teacher> ts = new ArrayList<>();
		getDataList().forEach(t -> {if(t.firstName.compareTo(min) >= 0 && t.firstName.compareTo(max) <= 0) ts.add(t);});
		return ts;
	}
	
	@Override
	public void registerOneObject(Teacher t) {
		List<Teacher> ts = new ArrayList<>();
		int maxId = 0;
		List<Teacher> allts = getDataList();
		for(Teacher tch : allts) {if(tch.getTchId() > maxId) maxId = tch.getTchId();}
		t.setTchId(maxId+1);
		ts.add(t);
		FileIO.writeFileAppended(ts, "Teacher");
	}

	@Override
	public void deleteOneObject(Teacher t) {
		List<Teacher> ts = new ArrayList<>();
		getDataList().forEach(tch -> {if(tch.getTchId() != t.getTchId()) ts.add(tch);});
		refreshAll(ts);
	}

	@Override
	public void updateOneObject(Teacher t) {
		List<Teacher> ts = new ArrayList<>();
		getDataList().forEach(tch -> {
			if(tch.getTchId() != t.getTchId()) ts.add(tch);
			else ts.add(t);
			});
		refreshAll(ts);
	}
	
	@Override
	public void refreshAll(List<Teacher> list) {
		FileIO.writeFile(list, Teacher.class, "teacher");
	}

}