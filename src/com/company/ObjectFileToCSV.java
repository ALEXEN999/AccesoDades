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
        String username;
        String firstname;
        String lastname;
        String email;
        String password;

        User userRead = (User) inputStream.readObject();

        try {
            while (userRead!= null) {

                String[] usuario = String.valueOf(userRead).split(",");
                User user = new User(usuario[0],usuario[1], usuario[2], usuario[3], usuario[4]);
                listaUsers.add(user);

                userRead = (User) inputStream.readObject();

            }
        }catch (java.io.EOFException exc){
            inputStream.close();
        }





        }
        public void writeUsersToCSV(ArrayList<User> listaUsers) throws IOException {
            FileWriter fileOutputStream = new FileWriter("users2.csv");
            BufferedWriter outputStream = new BufferedWriter(fileOutputStream);

            try {
                for (User u:listaUsers) {
                    outputStream.write(String.valueOf(u));
                    System.out.println(String.valueOf(u));
                }

            } catch (java.io.EOFException exc){
                fileOutputStream.close();
                outputStream.close();
            }
        }



    }

