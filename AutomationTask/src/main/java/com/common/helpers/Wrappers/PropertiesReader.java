package com.common.helpers.Wrappers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static Properties properties = new Properties();

    public static Properties readPropertiesFile(String fileName) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(fileName);
            properties.load(fis);//convert into key and value
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public static String getProperty(String key) {
        try {
            return properties.getProperty(key);
        } catch (Exception e) {
            return "Property not found";
        }
    }

    /*static String filePath = "src/main/resources/facebookConfig.properties";


    static {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        try {
            properties.load(fileInputStream); //convert into key and value
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key) {
        try {
            return properties.getProperty(key);
        } catch (Exception e) {
            return "Property not found";
        }
    }*/

}
