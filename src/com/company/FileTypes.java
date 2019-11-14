package com.company;

import jdk.nashorn.api.tree.WhileLoopTree;

import java.io.*;

public class FileTypes {
    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("FileTypes.txt");

        DataOutputStream outputStream = new DataOutputStream(fileOutputStream);

        outputStream.writeByte(36);
        outputStream.writeBoolean(true);
        outputStream.writeChar('a');
        outputStream.writeDouble(54);
        outputStream.writeFloat(9.9f);
        outputStream.writeInt(90);
        outputStream.writeUTF("hola");


        FileReader fileReader = new FileReader("FileTypes.txt");
        BufferedReader inputStreamB = new BufferedReader(fileReader);

        FileInputStream fileInputStream = new FileInputStream("FileTypes.txt");
        DataInputStream inputStreamD = new DataInputStream(fileInputStream);

        byte[] bytes = new byte[1024];

        String line = inputStreamB.readLine();

        System.out.println(line);

        System.out.println(inputStreamD.readByte());
        System.out.println(inputStreamD.readBoolean());
        System.out.println(inputStreamD.readChar());
        System.out.println(inputStreamD.readDouble());
        System.out.println(inputStreamD.readFloat());
        System.out.println(inputStreamD.readInt());
        System.out.println(inputStreamD.readUTF());


        outputStream.close();
        inputStreamB.close();
        inputStreamD.close();
        fileInputStream.close();






    }
}
