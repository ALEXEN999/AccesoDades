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
                    NodeList firstNameList = eElement.getElementsByTagName("Nom");
                    NodeList lastNameList = eElement.getElementsByTagName("Cognom");
                    NodeList emailList = eElement.getElementsByTagName("Email");
                    NodeList passList = eElement.getElementsByTagName("Password");



                    for (int count = 0; count < userNameList.getLength(); count++) {
                        Node node1 = userNameList.item(count);
                        Node node2 = firstNameList.item(count);
                        Node node3 = lastNameList.item(count);
                        Node node4 = emailList.item(count);
                        Node node5 = passList.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE){
                            Element user = (Element) node1;
                            Element firstName = (Element) node2;
                            Element lastName = (Element) node3;
                            Element email = (Element) node4;
                            Element pass = (Element) node5;

                            System.out.println("Username : "+user.getTextContent());
                            System.out.println("Nom : "+firstName.getTextContent());
                            System.out.println("Cognom : "+lastName.getTextContent());
                            System.out.println("Email : "+email.getTextContent());
                            System.out.println("Pass : "+pass.getTextContent());


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
