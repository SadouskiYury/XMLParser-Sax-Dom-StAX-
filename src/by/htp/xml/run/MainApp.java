package by.htp.xml.run;

import by.htp.xml.entity.Families;
import by.htp.xml.parser.FamilyParser;
import by.htp.xml.parser.dom.FamilyDomParser;
import by.htp.xml.parser.sax.FamilySaxParser;
import by.htp.xml.parser.stax.FamilyStAXParser;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("SAX_________________");
		FamilySaxParser familyParserSax = new FamilySaxParser();
		familyParserSax.parseFamilyDoc("source/FamilyFile.xml");

		System.out.println("DOM____________________");
		FamilyParser familyParserDom = new FamilyDomParser();
		Families Dom = familyParserDom.parseFamilyDoc("source/FamilyFile.xml");
		Dom.showFamilies();
		

		System.out.println("StAX_________________");
		FamilyStAXParser familyStAXParser = new FamilyStAXParser();
		Families StAx = familyStAXParser.parseFamily("source/FamilyFile.xml");
		StAx.showFamilies();

	}
}