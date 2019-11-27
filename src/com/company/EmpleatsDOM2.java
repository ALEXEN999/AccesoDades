package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class EmpleatsDOM2 {
    public static void main(String[] args) {
        try {
            File file = new File("Usuarios.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: ");
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Empleado");
            System.out.println("----------------------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element : ");
                System.out.println(nNode.getNodeName());
                if (nNode.getNodeType()== Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    System.out.println("id : "+eElement.getAttribute("id"));
                    System.out.println();
                    NodeList userNameList = eElement.getElementsByTagName("Username");

                    for (int count = 0; count < userNameList.getLength(); count++) {
                        Node node1 = userNameList.item(count);
                        if (node1.getNodeType() == node1.ELEMENT_NODE){
                            Element user = (Element) node1;
                            System.out.println("Username : "+user.getTextContent());
                            System.out.println("Nom : "+user.getTextContent());


                            System.out.println(user.getAttribute("type"));
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
