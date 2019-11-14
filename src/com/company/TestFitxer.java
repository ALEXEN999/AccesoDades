package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestFitxer {
    public static void main(String[] args) throws IOException {
        Scanner path = new Scanner(System.in);
        System.out.println("Introduce la ruta:");
        File ruta = new File(path.nextLine()+"Fichero.xml");

        System.out.println("Nombre completo del archivo: "+ruta.getName());
        System.out.println("Path del archivo: "+ruta.getParent());
        System.out.println("Ruta completa del archivo: "+ruta.getAbsolutePath());

        ruta.createNewFile();
        System.out.println("Existe el archivo "+ruta.getName()+"?");

        if (ruta.exists() == true){
            System.out.println("El archivo "+ruta.getName()+" existe");

        } else{
            System.out.println("El archivo "+ruta.getName()+" no existe");
        }
    }
}
