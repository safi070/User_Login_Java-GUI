package com.example.user_login_gui;
// Name:   M.Safi-Ur-Rehman
// Reg No: SP24-BSE-083
import java.io.*;
import java.lang.reflect.Field;

public class LoginData {
    String name;
    String password;
    File file;


    public static void fileData(){
        //pre entered user name and password
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("login"))) {
            bufferedWriter.write("Safi 1234\n" +
                    "Ali 2345\n" +
                    "Ahmed 4567");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public static void readFromFile(String user, String password ) throws FileNotFoundException {
//        FileReader read = new FileReader("login");
//
//
//
//    }

    public static String validateUser( String userName,String password) throws FileNotFoundException {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("login"))){
            String userDetails="";
            while((userDetails=bufferedReader.readLine())!=null){
                String user[]= userDetails.split(" ");

                if(user[0].equals(userName)&& user[1].equals(password)) {
                    return userName;
                }
//                else {
//                    System.out.println("not found");
//                    //  System.out.println(user[1]);
//                }
            }
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }


        return "No User has such User name and Password";
    }


    public static void writeIntoFile(){

    }

//    public static void main(String[] args) {
//        fileData();
//    }
}
