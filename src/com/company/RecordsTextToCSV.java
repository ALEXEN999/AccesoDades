package com.company;

import java.io.*;
import java.util.Scanner;

public class RecordsTextToCSV {

    private static String [] nombre = new String[3];
    private static String [] apellidos = new String[3];
    private static String [] edad = new String[3];
    public static void main(String[] args) throws IOException {
         RecordsTextToCSV recordsTextToCSV = new RecordsTextToCSV();
        FileReader fileReader = new FileReader("/home/dam2a/IdeaProjects/AccesoDades/src/info.txt");
        BufferedReader inputStream = new BufferedReader(fileReader);
         recordsTextToCSV.llegeixFitxer(inputStream);
         recordsTextToCSV.mostraPerPantalla();
    }


    void llegeixFitxer (BufferedReader inputStream) throws IOException {

        Boolean eof = false;
        int count= 0;
        while (!eof) {
            String line = inputStream.readLine();
            if (line==null){
                eof=true;
            }else {
                nombre[count] = inputStream.readLine();
                apellidos[count] = inputStream.readLine();
                edad[count] = inputStream.readLine();
                line = inputStream.readLine();
            }
        }
        inputStream.close();
    }



    void mostraPerPantalla () throws IOException {
        FileWriter fileWriter = new FileWriter("/home/dam2a/IdeaProjects/AccesoDades/src/info.csv");
        BufferedWriter outputstream = new BufferedWriter(fileWriter);
        Scanner sc = new Scanner(new File("/home/dam2a/IdeaProjects/AccesoDades/src/info.txt"));
        int count = 0;
        String SEP [] = sc.next().split(",");
        System.out.println("nombre, cognom, edat");
        for (int i = 0; i < nombre.length; i++) {
            System.out.print(nombre[i]+",");

            count++;
            if (count == 3){
                System.out.println("");
                count = 0;
            }
        }
        outputstream.close();
        fileWriter.close();
    }
    void escriuSortidaCSV() throws IOException {
        FileWriter fileWriter = new FileWriter("/home/dam2a/loto/info.csv");
        BufferedWriter outputstream = new BufferedWriter(fileWriter);

        for (int i = 0; i < nombre.length; i++) {
            outputstream.write(nombre[i]+"\n");
        }
        outputstream.close();
        fileWriter.close();
    }
}
