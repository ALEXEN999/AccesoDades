package com.company;

import java.io.*;

public class CopyDirFISFOS {
    public static void main(String[] args) throws IOException {

        File directorioOrigen = new File(".idea");
        File directorioDestino = new File("/home/dam2a/IdeaProjects/AccesoDades/");

        String [] ficheros = directorioOrigen.list();

        for (int i = 0; i < ficheros.length; i++) {

            FileInputStream fileInputStream = new FileInputStream(directorioOrigen+"/"+ficheros[i]);
            DataInputStream inputStream = new DataInputStream(fileInputStream);

            FileOutputStream fileOutputStream = new FileOutputStream(directorioDestino+"/"+ficheros[i]);
            DataOutputStream outputStream = new DataOutputStream(fileOutputStream);

            byte[] bytes = new byte[1024];
            int in_put = inputStream.read(bytes);
            while (in_put > 0) {
                outputStream.write(bytes, 0, in_put);
                in_put=inputStream.read(bytes);
            }
            inputStream.close();
            fileInputStream.close();
            outputStream.close();
            fileOutputStream.close();
        }


    }
}
