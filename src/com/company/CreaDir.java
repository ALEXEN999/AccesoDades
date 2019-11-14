package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreaDir {
    public static void main(String[] args) throws IOException {
        Scanner path = new Scanner(System.in);
        System.out.println("Seleciona una ruta:");
        File ruta = new File(path.nextLine());
        ruta.mkdirs();
        System.out.println("Escribe el nombre del nuevo directorio:");
        File directorio = new File(ruta+"/"+path.nextLine());
        directorio.mkdirs();

        System.out.println("Existe el directorio "+directorio.getName()+"?");
        System.out.println("");

        if (directorio.exists() == true){
            System.out.println("EXISTE");
            System.out.println(directorio);
        } else{
            System.out.println("El directorio "+directorio.getName()+" no existe");
        }


    }
}
