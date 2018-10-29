package neu.edu.csye6200.team.objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rules {
	
	private final StringProperty minAge;
	private final StringProperty maxAge;
	private final StringProperty ageRange;
	private final StringProperty groupSize;
	private final StringProperty ratio;
	private final StringProperty maxGroup;
	
	public Rules(String minage, String maxage, String groupsize, String ratio, String maxgroup) {
		this.minAge = new SimpleStringProperty(minage);
		this.maxAge = new SimpleStringProperty(maxage);
		this.groupSize = new SimpleStringProperty(groupsize);
		this.ratio = new SimpleStringProperty(ratio);
		this.maxGroup = new SimpleStringProperty(maxgroup);
		this.ageRange = new SimpleStringProperty(minage + "¡ª¡ª" + maxage);
	}
	
	
	
	public String getMinAge() {
        return minAge.get();
    }

	public StringProperty minAgeProperty() {
        return minAge;
    }
	
	public String getMaxAge() {
        return maxAge.get();
    }

	public StringProperty maxAgeProperty() {
        return maxAge;
    }
	
	public String getGroupSize() {
        return groupSize.get();
    }

	public StringProperty groupSizeProperty() {
        return groupSize;
    }
	
	public String getMaxGroup() {
        return maxGroup.get();
    }

	public StringProperty maxGroupProperty() {
        return maxGroup;
    }
	
	public String getAgeRange() {
        return ageRange.get();
    }

	public StringProperty ageRangeProperty() {
        return ageRange;
    }
	
	public String getRatio() {
        return ratio.get();
    }

	public StringProperty RatioProperty() {
        return ratio;
    }
	
}
