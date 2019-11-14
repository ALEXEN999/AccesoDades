package com.company;

import java.io.*;
import java.util.Scanner;

public class CopyFilesFRFW {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Seleciona la ruta completa del fichero, ejem: /home/dam2a/alphabeta.txt:");

        File file = new File(in.nextLine());

        FileReader fileReaderOrigen = new FileReader(file);
        System.out.println("Seleciona la ruta completa donde guardará el nuevo fichero, ejem: /home/dam2a/copia.txt:");

        FileWriter fileWriterDestino = new FileWriter(in.nextLine());

        BufferedReader inputStream = new BufferedReader(fileReaderOrigen);
        BufferedWriter outputStream = new BufferedWriter(fileWriterDestino);

        Boolean eof = false;

        if (file.exists()){
            while (!eof){
                String line = inputStream.readLine();

                if (line==null){
                    eof=true;
                } else {
                    outputStream.write(line);
                }
            }
        } else {
            System.out.println("El archivo introducido no existe!");
        }
        inputStream.close();
        outputStream.close();


    }
}
