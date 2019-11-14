package com.company;

import java.io.*;

public class CopyFilesBin {
    public static void main(String[] args) throws IOException {
        FileInputStream fileImage = new FileInputStream("cat.jpg");
        FileOutputStream fileOutputImage = new FileOutputStream("catCopia.jpg");

        DataInputStream inputStream = new DataInputStream(fileImage);
        DataOutputStream outputStream = new DataOutputStream(fileOutputImage);

        byte[] bytes = new byte[1024];
        int in_put = inputStream.read(bytes);
        while (in_put > 0) {
            outputStream.write(bytes, 0, in_put);
            in_put=inputStream.read(bytes);
        }
        inputStream.close();
        fileImage.close();
        outputStream.close();
        fileOutputImage.close();
    }
}
