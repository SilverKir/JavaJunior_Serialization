package Task1;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        Serialize serialize =new Serialize();
        Student student= new Student("Иван", 19, 4.4);
        System.out.println("Объект до сериализации:");
        System.out.println(student);
        serialize.serialObj(student, "ser.bin");

        Student student1 = (Student) serialize.deSerialObj("ser.bin");
        System.out.println("Объект после сериализации:");
        System.out.println(student1);

    }
}
