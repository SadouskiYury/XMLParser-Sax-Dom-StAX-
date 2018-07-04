package by.htp.xml.entity;

public enum FamilyEnum {
	AGE("age"), NAME("name"), SURNAME("surname"), GENDER("gender"), MILITARY("military"), MOTHER("mother"), FATHER(
			"father"), CHILD("child"),CHILDREN("children"),FAMILY("family"),FAMILIES("families");
	private String value;

	private FamilyEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
