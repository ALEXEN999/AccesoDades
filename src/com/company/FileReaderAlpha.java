package com.company;

import java.io.*;
import java.util.Scanner;

public class FileReaderAlpha {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Seleciona el directorio donde esta el fichero alphabeta.txt:");
        String directorio = in.nextLine();
        boolean eof = false;
        FileReader file = new FileReader(directorio+"alphabeta.txt");
        BufferedReader inputStream = new BufferedReader(file);

        while (!eof){
            String line = inputStream.readLine();
            if (line==null){
                eof=true;
            } else {
                System.out.print(line.toUpperCase()+" ");
            }
        }inputStream.close();

    }
}
