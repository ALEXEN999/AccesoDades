package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CharsToFile1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("En que directorio quieres crear el archivo?");
        String directorio = in.nextLine();
        File fileChar = new File(directorio+"alphabeta.txt");
        PrintWriter pwInput = new PrintWriter(fileChar);
        for(char c = 'a'; c <= 'z'; ++c){
            pwInput.println(c + " ");
    }

        pwInput.close();
    }
}
