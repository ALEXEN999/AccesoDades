package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;

public class ObjectFileToCSV {
    public static void main(String[] args) {
        ArrayList<User> listaUsers = new ArrayList<>();

    }

    private void loadUsers(ArrayList<User> listaUsers) throws IOException {

        FileInputStream fileInputReader = new FileInputStream("users.bin");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputReader);
        String line = inputStream.readLine();
        int count = 0;
        boolean eof = false;
        while (!eof){
            if (line==null){
                eof= true;
            }else{
                String[] usuario = line.split(",");
                User user = new User(usuario[0],usuario[1], usuario[2], usuario[3], usuario[4]);
                listaUsers.add(user);
            }
            line = inputStream.readLine();
            count++;
        }
        fileInputReader.close();
        inputStream.close();

    }
}
