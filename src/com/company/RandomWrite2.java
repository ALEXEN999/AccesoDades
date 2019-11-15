package com.company;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLOutput;

public class RandomWrite2 {
    public static void main(String[] args) throws IOException {

        File file= new File("fileRandom.txt");
        file.delete();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        StringBuffer buffer;
        String [] nomDep = {"Admins","Recurs","Biolog"};

        for (int i = 0; i < nomDep.length; i++) {
            int position = (i + 1)* 10;
            randomAccessFile.writeInt(position);
            buffer = new StringBuffer(String.valueOf(nomDep[i]));
            buffer.setLength(10);

            randomAccessFile.writeChars(buffer.toString());
        }

        randomAccessFile.close();
        }


    }

