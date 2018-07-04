package by.htp.xml.parser.sax;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.xml.entity.Families;
import by.htp.xml.parser.FamilyParser;

public class FamilySaxParser implements FamilyParser {
	public Families parseFamilyDoc(String path) {

		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			FamilySaxHandler families = new FamilySaxHandler();
			reader.setContentHandler(families);
			reader.parse(path);
		} catch (SAXException | IOException e) {

			e.printStackTrace();
		}

		return null;
	}

}
