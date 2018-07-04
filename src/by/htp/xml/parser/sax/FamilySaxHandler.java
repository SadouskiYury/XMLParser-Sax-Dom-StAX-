package by.htp.xml.parser.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.xml.entity.Child;
import by.htp.xml.entity.Children;
import by.htp.xml.entity.Families;
import by.htp.xml.entity.Family;
import by.htp.xml.entity.FamilyEnum;
import by.htp.xml.entity.Father;
import by.htp.xml.entity.Mother;

public class FamilySaxHandler extends DefaultHandler {
	private Families families;
	private Family family;
	private Children children;
	private Mother mother;
	private Father father;
	private Child child;
	private FamilyEnum attr = null;
	private FamilyEnum currentPerson = null;

	public FamilySaxHandler() {
		this.families = new Families();
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("startDocument ");

	}

	@Override
	public void endDocument() throws SAXException {
		families.showFamilies();
		System.out.println("end document");

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (localName) {
		case "family":
			this.family = new Family();
			currentPerson = FamilyEnum.FAMILY;
			break;
		case "mother":
			this.mother = new Mother();
			currentPerson = FamilyEnum.MOTHER;
			break;
		case "father":
			this.father = new Father();
			currentPerson = FamilyEnum.FATHER;
			break;
		case "children":
			this.children = new Children();
			currentPerson = FamilyEnum.CHILDREN;
			break;
		case "child":
			this.child = new Child();
			currentPerson = FamilyEnum.CHILD;
			break;
		default:
			attr = FamilyEnum.valueOf(localName.toUpperCase());
			break;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (localName) {
		case "family":
			families.add(family);
			currentPerson = null;
			break;
		case "mother":
			family.setMother(mother);
			currentPerson = null;
			break;
		case "father":
			family.setFather(father);
			currentPerson = null;
			break;
		case "children":
			family.setChildren(children);
			currentPerson = null;
			break;
		case "child":
			children.addChild(child);
			currentPerson = null;
			break;
		default:
			break;
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String text = new String(ch, start, length).trim();
		if (currentPerson != null && attr != null) {
			switch (currentPerson) {
			case MOTHER:
				switch (attr) {
				case NAME:
					mother.setName(text);
					break;
				case SURNAME:
					mother.setSurname(text);
					break;
				case AGE:
					mother.setAge(Integer.parseInt(text));
					break;
				default:
					break;
				}
				attr = null;
				break;
			case FATHER:
				switch (attr) {
				case NAME:
					father.setName(text);
					break;
				case SURNAME:
					father.setSurname(text);
					break;
				case AGE:
					father.setAge(Integer.parseInt(text));
					break;
				case MILITARY:
					father.setMilitary(attr.getValue());
					break;
				default:
					break;
				}
				attr = null;
				break;
			case CHILD:
				switch (attr) {
				case NAME:
					child.setName(text);
					break;
				case SURNAME:
					child.setSurname(text);
					break;
				case AGE:
					child.setAge(Integer.parseInt(text));
					break;
				case GENDER:
					child.setGender(text);
					break;
				default:
					break;
				}
				attr = null;
				break;
			default:
				break;
			}

		}

	}

}
