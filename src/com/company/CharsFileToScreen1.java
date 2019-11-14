package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharsFileToScreen1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Seleciona el directorio donde esta el fichero alphabeta.txt:");
        String directorio = in.nextLine();
        Scanner sc = new Scanner(new File(directorio+"alphabeta.txt"));
        while(sc.hasNextLine()) {
            System.out.print(sc.nextLine().toUpperCase()+" ");
        }
        sc.close();
    }
}
