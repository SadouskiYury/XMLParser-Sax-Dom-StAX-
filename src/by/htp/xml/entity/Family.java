package by.htp.xml.entity;

public class Family {
	private Mother mother;
	private Father father;
	private Children children;

	public Family() {

	}

	public Family(Mother mother, Father father, Children child) {
		this.mother = mother;
		this.father = father;
		this.children = child;
	}

	public Mother getMother() {
		return mother;
	}

	public void setMother(Mother mother) {
		this.mother = mother;
	}

	public Father getFather() {
		return father;
	}

	public void setFather(Father father) {
		this.father = father;
	}

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children child) {
		this.children = child;
	}

	@Override
	public String toString() {
		return "Family :"+"\n" + mother  + father  + children ;
	}
	

}
