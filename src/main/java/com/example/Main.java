package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static Boolean name_matcher(String name){
            String name_regex = "[A-Z]{1}+[A-Za-z]{2,}";
            Pattern pattern = Pattern.compile(name_regex);
            Matcher matcher = pattern.matcher(name);
            if(matcher.matches()){
                return true;
            }
            return false;

    }

    public static Boolean id_matcher(int id){
        String id_regex = "[0-9]{1,2}";
            Pattern pattern = Pattern.compile(id_regex);
            Matcher matcher = pattern.matcher(id+"");
            if(matcher.matches()){
                return true;
            }
            return false;

    }

    public static Boolean password_matcher(String password){
            String password_regex = "(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(.{6,})";
            Pattern pattern = Pattern.compile(password_regex);
            Matcher matcher = pattern.matcher(password);
            if(matcher.matches()){
                return true;
            }
            return false;
    }

    public static Boolean post_matcher(String post){
        String post_regex = ".*#.*";
        Pattern pattern = Pattern.compile(post_regex);
        Matcher matcher = pattern.matcher(post);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User u1 = new User(1, "Him@123","Himanshu" );
        User u2 = new User(2,"John@234","John");
        User u3 = new User(3, "Alex%456", "Alex");

        HashMap<String, User> user_list = new HashMap<>();
        user_list.put(u1.get_name(),u1);
        user_list.put(u2.get_name(),u2);
        user_list.put(u3.get_name(),u3);

        System.out.println("Welcome to post analyzer program!");
        User curr;
        
        
        while(true){
           System.out.println("Please enter your name");
           String name;
           while(true){
            name = scanner.nextLine();
            if(name_matcher(name)){
                break;
            }
            System.out.println("Please enter a valid first name:- ");
           }

           System.out.println("Please enter your id");
           int id;
           while(true){
            id = scanner.nextInt();
            if(id_matcher(id)){
                break;
            }
            System.out.println("Please enter a valid id:- ");
           }

           System.out.println("Please enter your password");
           String password;
           while(true){
            password = scanner.nextLine();
            if(password_matcher(password)){
               break;
            }
            System.out.println("Please enter a valid password:- ");
           }

           if(user_list.containsKey(name)){
            User temp = user_list.get(name);
           if(temp.get_id()==id && temp.get_password().equals(password)){
               curr = temp;
               System.out.println("User authenticated");
               break;
           }
        }
            System.out.println("Invalid user details....Please try again!");
       
        }

      
    System.out.println("Please enter the post");
    String post;
    while(true){
        post = scanner.nextLine();
        if(post_matcher(post)){
            curr.set_post(post);
            System.out.println("Post has been added");
            break;
        }
        System.out.println("Invalid post format....Plese try again");
   }

     try {
        curr.analyse();
    } catch (Notallowedexception e) {
        
        System.out.println(e.getMessage());
    }
     
   }
}
