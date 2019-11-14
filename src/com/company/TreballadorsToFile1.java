package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.SplittableRandom;

public class TreballadorsToFile1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String nom;
        String cognom;
        String salari;
        String casat;
        String directorio;
        boolean valor = true;
        String pregunta = "";


        System.out.println("En que directorio quieres guardar el fichero?");
        directorio = in.nextLine();
        System.out.println("");

        File file = new File(directorio+"treballadors.txt");
        PrintWriter pwInput = new PrintWriter(file);

        for (int i = 0; valor==true ; i++) {


            System.out.println("Nom:");
            nom = in.nextLine();
            System.out.println("Cognom:");
            cognom = in.nextLine();
            System.out.println("Salari:");
            salari = in.nextLine();
            System.out.println("Casat:");
            casat = in.nextLine();
            System.out.println("------------");
            System.out.println("Quieres seguir añadiendo trabajadores? N/y:");
            pregunta = in.nextLine();
//            pwInput.println("Treballador "+i+": Nom: "+nom+", Cognom: "+cognom+", Salari: "+salari+", Casat: "+casat);

            pwInput.print(nom+","+cognom+","+salari+","+casat+",");
            if (!pregunta.equals("Y") && !pregunta.equals("y")){
                valor = false;
                pwInput.close();

            }

        }


    }
}
