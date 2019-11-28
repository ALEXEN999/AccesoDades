package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class AlumnesSAX extends DefaultHandler {
    boolean bNom= false;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equalsIgnoreCase("Alumne")){
            String edad = attributes.getValue("Edat");
            System.out.println("Edat : "+edad);
        } else if (qName.equalsIgnoreCase("Nom")){
            bNom = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equalsIgnoreCase("Alumne")){
            System.out.println("End Element : "+qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (bNom){
            System.out.println("Nom : "+new String(ch,start,length));
            bNom = false;
        }
    }
}

class SAXParser{
    public static void main(String[] args) {
        try {
            File inputFile = new File("Alumnos.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
            AlumnesSAX alumnesSAX = new AlumnesSAX();
            saxParser.parse(inputFile,alumnesSAX);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

