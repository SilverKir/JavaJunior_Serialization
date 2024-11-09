package Task1;

import java.io.*;

public class Serialize {
    public void serialObj(Object o, String file)  {
        try {FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             objectOutputStream.writeObject(o);
             objectOutputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object deSerialObj(String file)  {
        Object result=new Object();
        try {FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            result= objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

}
