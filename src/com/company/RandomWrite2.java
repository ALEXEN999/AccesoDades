package com.company;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLOutput;

public class RandomWrite2 {
    public static void main(String[] args) throws IOException {
            RandomWrite2 randomWrite2 = new RandomWrite2();
            randomWrite2.randomWrite();
            randomWrite2.loadRandom();
        }
        public void loadRandom () throws IOException {
            File file= new File("fileRandom.txt");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

            int idDep, position;
            char nomDep [] = new char[10], aux;

            position  = 0;

            try {
                for (;;){
                    randomAccessFile.seek(position);
                    idDep = randomAccessFile.readInt();
                    for (int i = 0; i < nomDep.length; i++) {
                        aux = randomAccessFile.readChar();
                        nomDep[i] = aux;
                    }
                    String nomDepS = new String(nomDep);
                    idDep = randomAccessFile.readInt();
                    System.out.println("Id Departamento: "+ idDep+"Nom Departament: "+nomDepS);
                    position = position +24;
                    if (randomAccessFile.getFilePointer() == randomAccessFile.length())break;
                }
            }catch (java.io.EOFException exc){
                randomAccessFile.close();
            }

        }
        public  void randomWrite() throws IOException {
            File file= new File("fileRandom.txt");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            StringBuffer buffer = null;
            int idDep = 9;
            String nomDep = "De Gea";

            long position = (idDep + 1)* 10;
            randomAccessFile.seek(position);
            randomAccessFile.writeInt(idDep);
            buffer = new StringBuffer(nomDep);
            buffer.setLength(10);

            randomAccessFile.writeInt(idDep);
            randomAccessFile.writeChars(buffer.toString());
            randomAccessFile.close();
        }
    }

