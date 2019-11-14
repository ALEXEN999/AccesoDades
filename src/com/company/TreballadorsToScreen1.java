package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreballadorsToScreen1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Seleciona el directorio donde esta el fichero treballadors.txt:");
        String directorio = in.nextLine();
        Scanner sc = new Scanner(new File(directorio+"treballadors.txt"));//.useDelimiter(",")/;
        int id = 0;
        int word=0;
        String[] parts = sc.next().split(",");
        for (int j = 0; word !=parts.length ; j++) {
            id++;
            System.out.println("Treballador "+id);

            for (int i = 0; i <= 3; i++) {
                System.out.println(parts[word] + " ");
                word++;
            }

        }
        sc.close();
    }
}
