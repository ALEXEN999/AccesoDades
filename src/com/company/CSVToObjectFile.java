package com.company;

import java.io.*;
import java.util.ArrayList;

public class CSVToObjectFile{

    private static CSVToObjectFile csvToObjectFile = new CSVToObjectFile();

    public static void main(String[] args) throws IOException {
        ArrayList<User> listaUsers = new ArrayList<>();

        csvToObjectFile.loadUsers(listaUsers);
        csvToObjectFile.writeUsers(listaUsers);
    }
    private void loadUsers(ArrayList<User> listaUsers) throws IOException {

        FileReader fileReader = new FileReader("Usuarios.csv");
        BufferedReader inputStream = new BufferedReader(fileReader);
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
        fileReader.close();
        inputStream.close();

    }
    public void writeUsers(ArrayList listaUsers) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("users.bin");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        for (Object u:listaUsers) {
            outputStream.writeObject(u);
            System.out.println(u);
        }
        fileOutputStream.close();
        outputStream.close();
    }
}
