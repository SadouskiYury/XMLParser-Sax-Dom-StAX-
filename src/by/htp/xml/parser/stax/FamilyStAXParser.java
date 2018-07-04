package by.htp.xml.parser.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.htp.xml.entity.Child;
import by.htp.xml.entity.Children;
import by.htp.xml.entity.Families;
import by.htp.xml.entity.Family;
import by.htp.xml.entity.FamilyEnum;
import by.htp.xml.entity.Father;
import by.htp.xml.entity.Mother;

public class FamilyStAXParser {
	private Families families;
	private XMLInputFactory inputFactory;
	private Family family;
	private FileInputStream input;

	public FamilyStAXParser() {
		families = new Families();
		inputFactory = XMLInputFactory.newInstance();
		input = null;
	}

	public Families parseFamily(String path) {

		try {
			// StringReader input = new StringReader(path);
			input = new FileInputStream(new File(path));
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

			while (reader.hasNext()) {
				int Element = reader.next();
				if (Element == XMLStreamReader.START_ELEMENT) {
					String name = reader.getLocalName();
					if (name == "family") {
						families.add(buildFamily(reader));

					}
				}
			}

		} catch (XMLStreamException ex) {
			System.err.println("StAX parsing error! " + ex.getMessage());
		} catch (FileNotFoundException ex) {
			System.err.println("File " + path + " not found! " + ex);
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				System.err.println("Impossible close file " + path + " : " + e);
			}
		}
		return families;
	}

	private Family buildFamily(XMLStreamReader reader) {
		Family family = new Family();

		try {
			while (reader.hasNext()) {
				int Element = reader.next();
				if (Element == XMLStreamReader.START_ELEMENT) {
					String name = reader.getLocalName();
					switch (FamilyEnum.valueOf(reader.getLocalName().toUpperCase())) {
					case MOTHER:
						family.setMother(buildMother(reader));
						break;
					case FATHER:
						family.setFather(buildFather(reader));
						break;
					case CHILDREN:
						family.setChildren(buildChildren(reader));
						break;
					default:
						System.out.println(reader.getLocalName());
						break;
					}
				} else if (Element == XMLStreamReader.END_ELEMENT && reader.getLocalName() == "family") {
					return family;

				}
			}
		} catch (XMLStreamException e) {
			System.err.println("Unknown element in tag Family");
			e.printStackTrace();
		}

		return family;
	}

	private Mother buildMother(XMLStreamReader reader) throws XMLStreamException {
		Mother mother = new Mother();
		while (reader.hasNext()) {
			int Element = reader.next();
			switch (Element) {
			case XMLStreamReader.START_ELEMENT:
				String name = reader.getLocalName();
				switch (FamilyEnum.valueOf(reader.getLocalName().toUpperCase())) {
				case NAME:
					mother.setName(reader.getElementText().trim());
					break;
				case SURNAME:
					mother.setSurname(reader.getElementText().trim());
					break;
				case AGE:
					mother.setAge(Integer.parseInt(reader.getElementText()));
					break;
				default:
					break;
				}
				break;
			case XMLStreamReader.END_ELEMENT:
				if (reader.getLocalName() == FamilyEnum.MOTHER.getValue())
					return mother;
				break;
			}
		}

		throw new XMLStreamException("Unknown element in tag Mother");
	}

	private Father buildFather(XMLStreamReader reader) throws XMLStreamException {
		Father father = new Father();
		while (reader.hasNext()) {
			int Element = reader.next();
			switch (Element) {
			case XMLStreamReader.START_ELEMENT:
				String name = reader.getLocalName();
				switch (FamilyEnum.valueOf(reader.getLocalName().toUpperCase())) {
				case NAME:
					father.setName(reader.getElementText().trim());
					break;
				case SURNAME:
					father.setSurname(reader.getElementText().trim());
					break;
				case AGE:
					father.setAge(Integer.parseInt(reader.getElementText()));
					break;
				case MILITARY:
					father.setMilitary(reader.getLocalName());
					break;
				}
			case XMLStreamReader.END_ELEMENT:
				if (reader.getLocalName() == FamilyEnum.FATHER.getValue())
					return father;
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Father");
	}

	private Children buildChildren(XMLStreamReader reader) {
		Children children = new Children();

		try {
			while (reader.hasNext()) {
				int Element = reader.next();
				if (Element == XMLStreamReader.START_ELEMENT)
					children.addChild(buildChild(reader));
				else if (Element == XMLStreamReader.END_ELEMENT && reader.getLocalName() == "children") {
					return children;
				}
			}
		} catch (XMLStreamException e) {
			System.err.println("Unknown element in tag Children" + e);
		}
		return children;

	}

	private Child buildChild(XMLStreamReader reader) {
		Child child = new Child();
		try {
			while (reader.hasNext()) {
				int Element = reader.next();
				switch (Element) {
				case XMLStreamReader.START_ELEMENT:
					String name = reader.getLocalName();
					switch (FamilyEnum.valueOf(reader.getLocalName().toUpperCase())) {
					case NAME:
						child.setName(reader.getElementText().trim());
						break;
					case SURNAME:
						child.setSurname(reader.getElementText().trim());
						break;
					case AGE:
						child.setAge(Integer.parseInt(reader.getElementText()));
						break;
					case GENDER:
						child.setGender(reader.getElementText().trim());
					default:
						break;
					}
					break;
				case XMLStreamReader.END_ELEMENT:
					if (reader.getLocalName() == FamilyEnum.CHILD.getValue())
						return child;
					break;
				}
			}
		} catch (NumberFormatException | XMLStreamException e) {

			System.err.println("Unknown element in tag Child");
			e.printStackTrace();
		}
		return child;
	}

}
