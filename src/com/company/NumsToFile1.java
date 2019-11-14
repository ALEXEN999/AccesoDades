package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NumsToFile1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("En que directorio quieres crear el archivo?");
        String directorio = in.nextLine();
        File fileNum = new File(directorio+"Num11001200.txt");

        PrintWriter pwInput = new PrintWriter(fileNum);

        for (int i = 1100; i <=1200 ; i++) {
            pwInput.println(i);
        }
        pwInput.close();
    }
}
