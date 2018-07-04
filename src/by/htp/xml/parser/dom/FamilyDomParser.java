package by.htp.xml.parser.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.htp.xml.entity.Child;
import by.htp.xml.entity.Children;
import by.htp.xml.entity.Families;
import by.htp.xml.entity.Family;
import by.htp.xml.entity.Father;
import by.htp.xml.entity.Mother;
import by.htp.xml.parser.FamilyParser;

public class FamilyDomParser implements FamilyParser {

	public Families parseFamilyDoc(String path) {

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		Families families = new Families();
		try {
			DocumentBuilder documentBuulder = builderFactory.newDocumentBuilder();
			Document document = documentBuulder.parse(path);
			Element element = document.getDocumentElement();
			// List<Family> families = new ArrayList<>();
			// получение списка дочерних элементов <family>
			NodeList childNodes = element.getElementsByTagName("family");
			for (int i = 0; i < childNodes.getLength(); i++) {
				Element familyElement = (Element) childNodes.item(i);
				Family family = buildFamily(familyElement);
				families.add(family);
			}
		

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return families;
	}

	private Family buildFamily(Element element) {
		Family family = new Family();
		family.setFather(new Father(getElementTextContent(getSingleChild(element, "father"), "name"),
				getElementTextContent(getSingleChild(element, "father"), "surname"),
				Integer.parseInt(getElementTextContent(getSingleChild(element, "father"), "age")),
				getSingleChild(element, "military").getTagName()));

		family.setMother(new Mother(getElementTextContent(getSingleChild(element, "mother"), "name"),
				getElementTextContent(getSingleChild(element, "mother"), "surname"),
				Integer.parseInt(getElementTextContent(getSingleChild(element, "mother"), "age"))));

		family.setChildren(getChildren(element));

		return family;
	}

	// получение дочернего элемента
	private Element getSingleChild(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}

	// получение текстового содержимого тега
	private String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent().trim();
		return text;
	}

	private Children getChildren(Element element) {
		Children children = new Children();
		NodeList childs = element.getElementsByTagName("child");
		for (int i = 0; i < childs.getLength(); i++) {
			Element child=(Element)childs.item(i);
			children.addChild(new Child(getElementTextContent(child, "name"),
					getElementTextContent(child, "surname"), Integer.parseInt(getElementTextContent(child, "age")),
					getElementTextContent(child, "gender")));
		}
		return children;
	}

}
