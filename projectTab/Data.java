package projectTab;

import java.io.File;
import java.util.Scanner;
import java.io.*;

public class Data {

    static File file = new File("Data.dat");
    static File nameAndPassword = new File("User.dat");
    static String[][] data = new String[30][30];

    static int row = 0;
    static int column = 0;

    public static String[][] outputData (){

        try{
            file.createNewFile();
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()){

                String line = scan.nextLine();
                String[] parts = line.split(",");

                for(String part : parts){
                    data[row][column] = part;
                    column++;
                }

                row++;

                column = 0;

            }

        }catch(Exception ignored){}

        return data;
    }

    public static int countLineOnAFile (){

        int count = 0;

        try{
            Scanner scan = new Scanner(nameAndPassword);

            while(scan.hasNextLine()){
                scan.nextLine();
                count++;
            }

            scan.close();

        }catch(Exception ignored){}

        return count;
    }

    public static void inputUserAndPassword (String username, String password){

        try{
            boolean checkIfStored = true;

            FileWriter writer = new FileWriter(nameAndPassword, true);

            if(username.startsWith("admin")) {

                writer.write("0" + "," + countLineOnAFile() + "," + username.substring(5) + "," + password + "\n");
                checkIfStored = false;

            }else if (username.startsWith("registar")) {

                writer.write("1" + "," + countLineOnAFile() + "," + username.substring(8) + "," + password + "\n");
                checkIfStored = false;

            }
            if(checkIfStored) writer.write("2" + "," + countLineOnAFile() + "," + username + "," + password + "\n");

            writer.close();

        }catch(Exception ignored){}

    }

    public static void inputNameAndLastname (String name, String lastname){
        try{
            FileWriter writer = new FileWriter(file, true);

            writer.write(name + "," + lastname + "," + " " + "," + " " + "," + " " + "," + " " + ","
                        + " " + "," + " " + "," + " " + "," + " " + "," + " " + "," + " " + "," + " " + "," + " " + "\n");

            writer.close();
        }catch (Exception ignored){}
    }

    public static boolean isExistUser(String username){

        try{
            Scanner scan = new Scanner(nameAndPassword);

            while (scan.hasNextLine()){

                String data = scan.nextLine();
                String[] parts = data.split(",");

                if(parts[2].equals(username)) return false;
            }

        }catch(Exception ignored){}

        return true;

    }

    public static boolean isExist (String username, String password){

        try{
            Scanner scan = new Scanner(nameAndPassword);

            while (scan.hasNextLine()){

                String data = scan.nextLine();
                String[] parts = data.split(",");

                if(parts[2].equals(username) && parts[3].equals(password)) return true;
            }

        }catch(Exception ignored){}

        return false;
    }
}
