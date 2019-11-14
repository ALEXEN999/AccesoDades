package com.company;

import java.io.File;
import java.util.Scanner;

public class MostraFitxers {
    public static void main(String[] args) {
        Scanner path = new Scanner(System.in);
        System.out.println("Introduce el path:");
        File ruta = new File (path.nextLine());

        if (ruta.exists()) {
            for (File file : ruta.listFiles()) {
                if (file.isFile()) System.out.println(file.getName());
            }
        }
    }


}
