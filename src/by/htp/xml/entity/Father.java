package by.htp.xml.entity;

public class Father {
	private String name;
	private String surname;
	private int age;
	private String military;

	public Father() {
		super();
	}

	public Father(String name, String surname, int age, String military) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.military = military;
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

	public String getMilitary() {
		return military;
	}

	public void setMilitary(String military) {
		this.military = military;
	}

	@Override
	public String toString() {
		return "Father [name=" + name + ", surname=" + surname + ", age=" + age + ", military=" + military + "]"+"\n";
	}

}
