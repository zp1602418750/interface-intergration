package com.tiza.dcms.inf.utils.dflzm;

import java.io.*;

public class ReadWriteDataUtil {
    public static void writeDataToFile(String fileName,Object data){

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName+".txt"))) {
            outputStream.writeObject(data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Object readDataFromFile(String fileName){
        try (ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName+".txt")))){
            Object o = inputStream.readObject();
            return o;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
