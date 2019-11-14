package com.company;

import java.awt.image.VolatileImage;
import java.io.*;
import java.util.ArrayList;

public class ObjectStreamExample {
     Person person = new Person();
     PersonEx personEx = new PersonEx();
    PersonEx personEx2 = new PersonEx();
    PersonEx personEx3 = new PersonEx();

    public static class PersonEx extends Person implements Serializable {
        private String name = null;
        private int age = 0;

        public void setAge(int age) {this.age = age;}

        public void setName(String name) {this.name = name;}

        public int getAge() {return age;}

        public String getName() {return name;}
    }
    public static class Person implements Serializable{
        private String name = null;
        private int age = 0;

        public void setAge(int age) {this.age = age;}

        public void setName(String name) {this.name = name;}

        public int getAge() {return age;}

        public String getName() {return name;}
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectStreamExample objectStreamExample = new ObjectStreamExample();
        objectStreamExample.intoDades();
        objectStreamExample.mostrarDades();

    }

    void intoDades () throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.bin"));

        personEx.setName("Joan Anton");
        personEx.setAge(53);

        personEx2.setName("María");
        personEx2.setAge(21);

        personEx3.setName("Alex");
        personEx3.setAge(18);


        objectOutputStream.writeObject(personEx);
        objectOutputStream.writeObject(personEx2);
        objectOutputStream.writeObject(personEx3);

        objectOutputStream.close();
    }
    void mostrarDades() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.bin"));
        ArrayList<String>listaPersonas = new ArrayList<>();
        String nombre = "";
        String edad = "";
        PersonEx personread = (PersonEx) objectInputStream.readObject();

        try {
            while (personread!= null) {
                nombre = personread.name;
                edad = String.valueOf(personread.age);

                listaPersonas.add(nombre);
                listaPersonas.add(edad);
                personread = (PersonEx) objectInputStream.readObject();
            }
        }catch (java.io.EOFException exc){
            objectInputStream.close();
        }

        for (int i = 0; i < listaPersonas.size() ; i++) {
            System.out.println(listaPersonas.get(i));

        }


    }
}
