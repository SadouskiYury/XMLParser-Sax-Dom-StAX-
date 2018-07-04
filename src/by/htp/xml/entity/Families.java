package by.htp.xml.entity;

import java.util.ArrayList;
import java.util.List;

public class Families {
	private List<Family> families;

	public Families() {
		this.families = new ArrayList<>();
	}

	public Families(List<Family> families) {
		this.families = families;
	}

	public boolean add(Family family) {
		return families.add(family);

	}

	public List<Family> getFamilies() {
		return families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
	}

	public boolean showFamilies() {
		for (Family s : families)
			System.out.println(s);
		return true;
	}

	@Override
	public String toString() {
		return "Families [families=" + families + "]";
	}

}
