package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ShowTreballadors {
    public static void main(String[] args) throws IOException {
        File file= new File("fileRandom.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("users.bin"));
        HashMap<Integer, String> departamentos = new HashMap<>();

        int idDep;
        char nomDep [] = new char[10], aux;


        while (randomAccessFile.getFilePointer() != randomAccessFile.length()) {
            idDep = randomAccessFile.readInt();
            String nomDepS = "";
            for (int i = 0; i < nomDep.length; i++) {
                aux = randomAccessFile.readChar();
                nomDep[i] = aux;
                if (aux != 0) nomDepS+= aux;
            }
            departamentos.put(idDep, nomDepS);
        }
        randomAccessFile.close();
        try {
            while (true){
                User user = (User) objectInputStream.readObject();
                System.out.println("Nombre: " + user.getFirstname() + "; Nombre departamento: " + departamentos.get(user.getIddepartamento()));
            }
        }
        catch (EOFException ef){}
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
