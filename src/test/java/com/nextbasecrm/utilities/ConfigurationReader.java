package com.nextbasecrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1.Create the object of Properties();
    private static Properties properties = new Properties();// properties is private,because you can't reach
    // variable from outside of class Encapsulation

    static {//static block accept static only and out object is static,and
        // when class is load it will run once and before everything else


        try {//2. We need to open the file in java memory: FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            //3-Load the properties object using FileInputStream object
            properties.load(file);

            //4 close the file
            file.close();

        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class");
            e.printStackTrace();
        }
    }
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }


}
