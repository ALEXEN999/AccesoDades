package com.company;

import java.io.*;
import java.util.Scanner;

public class CharsFileReader {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Seleciona la ruta completa del fichero, ejem: /home/dam2a/alphabeta.txt:");
        String ruta1 = in.nextLine();
        FileReader file1 = new FileReader(ruta1);
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleciona el directorio donde quieres guardar el fichero alphabeta2.txt:");
        String ruta2 = sc.nextLine();
        FileWriter file2 = new FileWriter(ruta2+"alphabeta2.txt");
        boolean eof = false;

        BufferedReader inputStream = new BufferedReader(file1);
        BufferedWriter outputStream = new BufferedWriter(file2);

        while (!eof){
            String line = inputStream.readLine();
            if (line==null){
                eof=true;
            }else {
                    outputStream.write(line.toLowerCase()+" ");
                }
            }
        inputStream.close();
        outputStream.close();
        }
    }

