package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class EmpleatsSAX extends DefaultHandler {
    boolean busername = false;
    boolean bNom= false;
    boolean bCognom = false;
    boolean bEmail = false;
    boolean bPass = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
         if (qName.equalsIgnoreCase("Username")){
            busername = true;
        }else if (qName.equalsIgnoreCase("Nom")){
            bNom = true;

        }else if (qName.equalsIgnoreCase("Cognom")){
            bCognom = true;

        }else if (qName.equalsIgnoreCase("Email")){
            bEmail = true;

        }else if (qName.equalsIgnoreCase("Password")){
            bPass = true;

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equalsIgnoreCase("Empleado")){
            System.out.println("End Element : "+qName);
            System.out.println("");

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (busername){
            System.out.println("Username : "+new String(ch,start,length));
            busername = false;
        } else if (bNom){
            System.out.println("Nom : "+new String(ch,start,length));
            bNom = false;
        } else if (bCognom){
            System.out.println("Cognom : "+new String(ch,start,length));
            bCognom = false;
        } else if (bEmail){
            System.out.println("Email : "+new String(ch,start,length));
            bEmail = false;
        } else if (bPass){
            System.out.println("Password : "+new String(ch,start,length));
            bPass = false;
        }
    }
}

class SAXParser2 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("Usuarios.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
            EmpleatsSAX alumnesSAX = new EmpleatsSAX();
            saxParser.parse(inputFile,alumnesSAX);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
