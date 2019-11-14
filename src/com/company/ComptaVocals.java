package com.company;

import java.io.*;

public class ComptaVocals {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("/home/dam2a/loto/palabras.txt");
        BufferedReader inputStream = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter("/home/dam2a/loto/palabras.csv");
        BufferedWriter outputStream = new BufferedWriter(fileWriter);
        int caracter;
        caracter = inputStream.read();
        outputStream.write("a,e,i,o,u"+"\n");

        int [] vocales = new int[5];


        while(caracter != -1) {
            //Hacer algo con el carácter leído
                caracter=(char)caracter;
            if (caracter==('a')){
                vocales[0]+= 1;
            }else if (caracter==('e')){
                vocales[1]+= 1;
            }else if (caracter==('i')){
                vocales[2]+= 1;
            }else if (caracter==('o')){
                vocales[3]+= 1;
            }else if (caracter==('u')){
                vocales[4]+= 1;
            }
            caracter = inputStream.read();
        }


            outputStream.write(String.valueOf(vocales[0])+","+String.valueOf(vocales[1])+","+String.valueOf(vocales[2])+","+String.valueOf(vocales[3])+","+String.valueOf(vocales[4]));

        inputStream.close();
        fileReader.close();
        outputStream.close();
        fileWriter.close();

    }
}
