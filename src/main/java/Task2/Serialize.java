package Task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.List;

public class Serialize {

    public void saveObjectToFile(Object object, String fileName) {
        if (fileName.endsWith(".json")) {
            serialObjJson(object, fileName);
        } else if (fileName.endsWith(".xml")) {
            serialObjXml(object, fileName);
        } else serialObjBin(object, fileName);
    }


    public void serialObjBin(Object o, String file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(o);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void serialObjJson(Object o, String file) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(file), o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void serialObjXml(Object o, String file) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(file), o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public <T> T loadObjectFromFile(Class<T> clazz, String fileName) {

        if (fileName.endsWith(".json")) {
            return deSerialObjJson(clazz, fileName);
        } else if (fileName.endsWith(".xml")) {
            return deSerialObjXml(clazz, fileName);
        } else return deSerialObjBin(clazz, fileName);
    }

    public <T> T deSerialObjBin(Class<T> clazz, String file) {
        Object result = new Object();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            result = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz.cast(result);
    }

    private <T> T deSerialObjJson(Class<T> clazz, String file) {
        Object result = new Object();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            result = objectMapper.readValue(new File(file), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clazz.cast(result);
    }

    private <T> T deSerialObjXml(Class<T> clazz, String file) {
        Object result = new Object();
        try {
            XmlMapper xmlMapper = new XmlMapper();
            result = xmlMapper.readValue(new File(file), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clazz.cast(result);
    }

}
