package com.company;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class AlumnesDOM1 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            //Root element
            Element rootElement = doc.createElement("Alumnes");
            doc.appendChild(rootElement);

            //grau element
            Element alumne = doc.createElement("Alumne");
            rootElement.appendChild(alumne);
            //settings attribute to element
            Attr attr = doc.createAttribute("Edat");
            attr.setValue("16");
            alumne.setAttributeNode(attr);

            //name elements
            Element dni = doc.createElement("DNI");
            dni.appendChild(doc.createTextNode("Alejandro"));
            alumne.appendChild(dni);

            //name elements
            Element name = doc.createElement("Nom");
            name.appendChild(doc.createTextNode("Alejandro"));
            alumne.appendChild(name);

            Element cognom = doc.createElement("PrimerCognom");
            cognom.appendChild(doc.createTextNode("Pereira"));
            alumne.appendChild(cognom);

            Element cognom2 = doc.createElement("SegonCognom");
            cognom2.appendChild(doc.createTextNode("Fuentes"));
            alumne.appendChild(cognom2);

            Element ciutat = doc.createElement("Ciutat");
            ciutat.appendChild(doc.createTextNode("Santa Coloma de Gramenet"));
            alumne.appendChild(ciutat);

            Element assignatures = doc.createElement("Assignatures");
            assignatures.appendChild(doc.createTextNode("Base de Datos"));
            alumne.appendChild(assignatures);

            //Write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult Result = new StreamResult(new File("Alumnos.xml"));
            transformer.transform(source,Result);
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source,consoleResult);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
