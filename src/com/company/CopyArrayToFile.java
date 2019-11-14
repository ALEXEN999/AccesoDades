package com.company;

import java.io.*;

public class CopyArrayToFile {

    public static void main(String[] args) throws IOException {
        CopyArrayToFile copyArrayToFile = new CopyArrayToFile();

        copyArrayToFile.copytofile();
        copyArrayToFile.printxscreen();
    }

    void printxscreen () throws IOException {
        FileReader fileReader =new FileReader("/home/dam2a/loto/palabras.txt");
        BufferedReader inputStream = new BufferedReader(fileReader);
        Boolean eof = false;
        while (!eof) {
            String line = inputStream.readLine();
            if (line==null){
                eof=true;
            }else {
                System.out.println(line);
            }
        }
        inputStream.close();
        fileReader.close();
    }
    void copytofile() throws IOException {
        String [] palabras = {"hola","perro","adios","gato"};
        FileWriter fileWriter = new FileWriter("/home/dam2a/loto/palabras.txt");
        BufferedWriter outputstream = new BufferedWriter(fileWriter);

        for (int i = 0; i < palabras.length; i++) {
            outputstream.write(palabras[i]+"\n");
        }
        outputstream.close();
        fileWriter.close();
    }
}
