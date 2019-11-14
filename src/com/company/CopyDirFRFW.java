package com.company;

import java.io.*;
import java.util.Scanner;

public class CopyDirFRFW {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce el directorio que quieras mostrar:");

        File directorioOrigen = new File(in.nextLine());

        String [] ficheros = directorioOrigen.list();

        for (int i = 0; i < ficheros.length ; i++) {

            FileReader fileReaderOrigen = new FileReader(directorioOrigen+"/"+ficheros[i]);
            System.out.println("Introduce donde lo quieres guardar:");

            FileWriter fileWriterDestino = new FileWriter(in.nextLine()+"/"+ficheros[i]);

            BufferedReader inputStream = new BufferedReader(fileReaderOrigen);
            BufferedWriter outputStream = new BufferedWriter(fileWriterDestino);

            Boolean eof = false;
            while (!eof){
                String line = inputStream.readLine();

                if (line==null){
                    eof=true;
                } else {
                    outputStream.write(line);
                }
            }
            inputStream.close();
            outputStream.close();
        }

    }
}