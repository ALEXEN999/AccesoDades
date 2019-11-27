package com.company;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class EmpleatsDOM1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

    EmpleatsDOM1 empleatsDOM1 = new EmpleatsDOM1();

    ArrayList<User> listaUsers = new ArrayList<>();
        empleatsDOM1.loadUsers(listaUsers);
        empleatsDOM1.writeUsersToXML(listaUsers);
}

    private void loadUsers(ArrayList<User> listaUsers) throws IOException, ClassNotFoundException {

        FileInputStream fileInputReader = new FileInputStream("users.bin");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputReader);

        User userRead = (User) inputStream.readObject();

        try {
            while (userRead!= null) {

                listaUsers.add(userRead);

                userRead = (User) inputStream.readObject();

            }
        }catch (java.io.EOFException exc){

            inputStream.close();
        }


    }
    public void writeUsersToXML(ArrayList<User> listaUsers) throws IOException {


        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            //Root element
            Element rootElement = doc.createElement("Empleados");
            doc.appendChild(rootElement);
            for (User u:listaUsers) {


                //grau element
                Element empleado = doc.createElement("Empleado");
                rootElement.appendChild(empleado);
                //settings attribute to element
                Attr attr = doc.createAttribute("id");
                attr.setValue( String.valueOf(u.getIddepartamento()));
                empleado.setAttributeNode(attr);

                //firstname elements
                Element username = doc.createElement("Username");
                username.appendChild(doc.createTextNode(u.getUsername()));
                empleado.appendChild(username);

                //firstname elements
                Element firstname = doc.createElement("Nom");
                firstname.appendChild(doc.createTextNode(u.getFirstname()));
                empleado.appendChild(firstname);

                Element cognom = doc.createElement("Cognom");
                cognom.appendChild(doc.createTextNode(u.getLastname()));
                empleado.appendChild(cognom);

                Element email = doc.createElement("Email");
                email.appendChild(doc.createTextNode(u.getEmail()));
                empleado.appendChild(email);

                Element password = doc.createElement("Password");
                password.appendChild(doc.createTextNode(u.getPassword()));
                empleado.appendChild(password);

                //Write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult Result = new StreamResult(new File("Usuarios.xml"));
                transformer.transform(source, Result);
                StreamResult consoleResult = new StreamResult(System.out);
                transformer.transform(source, consoleResult);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
