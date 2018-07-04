package by.htp.xml.entity;

import java.util.ArrayList;
import java.util.List;

public class Children {
	private List<Child> children;

	public Children() {
		this.children = new ArrayList<>();
	}

	public Children(List<Child> child) {
		this.children = child;
	}

	public boolean addChild(Child child) {
		return children.add(child);
	}

	public List<Child> getChild() {
		return children;
	}

	public void setChild(List<Child> child) {
		this.children = child;
	}

	@Override
	public String toString() {
		return "Children " + children +"\n";
	}

}
