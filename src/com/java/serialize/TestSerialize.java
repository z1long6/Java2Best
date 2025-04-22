package com.java.serialize;

import java.io.*;

public class TestSerialize {
    public enum Sex{
        MALE,FEMALE
    }

    public static class Person implements Serializable {

        @Serial
        private static final long serialVersionUID = 2L;

        String name;
        transient int age;
        Sex sex;
        public Person(String name, int age, Sex sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        @Override
        public String toString() {
            return "Person{"+this.name+","+this.age+","+this.sex+"}";
         }
    }

    public static void serialize(Person person, String filepath){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))){
            oos.writeObject(person);
            System.out.println("Serialized Person object is saved in " + filepath);
        }catch (FileNotFoundException fnfe){
            System.out.println("File not found");
        }catch (IOException exception){
            System.out.println("IO exception");
        }
    }

    public static void deserialize(String filepath){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))){
            Person obj = (Person) ois.readObject();
            System.out.println(obj.age);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO exception");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        final String filepath = "src/com/java/serialize/save";
        Person person = new Person("LiSan", 18, Sex.FEMALE);
        serialize(person, filepath);
        deserialize(filepath);
    }
}
