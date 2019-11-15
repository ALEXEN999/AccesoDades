package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;

public class ObjectFileToCSV {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectFileToCSV objectFileToCSV = new ObjectFileToCSV();

        ArrayList<User> listaUsers = new ArrayList<>();
        objectFileToCSV.loadUsers(listaUsers);
        objectFileToCSV.writeUsersToCSV(listaUsers);
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
        public void writeUsersToCSV(ArrayList<User> listaUsers) throws IOException {
            FileWriter fileOutputStream = new FileWriter("users2.csv");
            BufferedWriter outputStream = new BufferedWriter(fileOutputStream);

            outputStream.write("Username , Firstname , Lastname");
            outputStream.newLine();

                for (User u:listaUsers) {
                    outputStream.write(u.getUsername() + "," + u.getFirstname() + "," + u.getLastname());
                    outputStream.newLine();
                }
                outputStream.close();

            System.out.println(listaUsers);
        }



    }

