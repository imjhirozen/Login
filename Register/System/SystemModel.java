package Register.System;

import java.io.File;
import java.io.FileWriter;
import java.util.*;


public class SystemModel {
    static File file = new File("test.dat");
    static String delimiter = ",";

    public static void inputData(String name, String password) {
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file, true);

            writer.write(name + "," + password + "\n ");

            writer.close();

        } catch (Exception e) {
        }
    }

    public static String getData(String name, String password) {
        try {
            file.createNewFile();
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String data = scan.next();
                String part[] = data.split(delimiter);

                if (part[0].equals(name) && part[1].equals(password)) {
                    return part[0];
                }

            }

        } catch (Exception e) {}
        return null;
    }

    public static boolean isExist(String name, String password){
        try {
            file.createNewFile();
            Scanner scan = new Scanner(file);

            while(scan.hasNextLine()){
                String data = scan.next();
                String[] part = data.split(delimiter);

                if(part[0].equals(name) && part[1].equals(password)) {
                    return true;
                }
            }
        }catch(Exception e){}
        return false;
    }
}
