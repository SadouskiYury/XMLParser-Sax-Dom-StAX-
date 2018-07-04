package by.htp.xml.entity;

public class Child {
	private String name;
	private String surname;
	private int age;
	private String gender;

	public Child() {
		super();

	}

	public Child(String name, String surname, int age, String gender) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Child [name=" + name + ", surname=" + surname + ", age=" + age + ", gender=" + gender ;
	}

}
