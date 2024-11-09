package Task2;


public class Main {
    public static void main(String[] args)  {
        Serialize serialize =new Serialize();
        People people = new People("Иван", 20, 4.4);
        System.out.println("Объект до сериализации:");
        System.out.println(people);
        serialize.saveObjectToFile(people, "serBin.bin");
        serialize.saveObjectToFile(people, "serJson.json");
        serialize.saveObjectToFile(people, "serXml.xml");

        People peopleBin = serialize.loadObjectFromFile(People.class,"serBin.bin");
        People peopleJson = serialize.loadObjectFromFile(People.class,"serJson.json");
        People peopleXml = serialize.loadObjectFromFile(People.class,"serXml.xml");

        System.out.println("Объект после сериализации:");
        System.out.printf("Bin: %s \n Json: %s\n Xml: %s\n",peopleBin,peopleJson,peopleXml);
    }
}
