package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    int id;
    String password;
    String name;
    String post;

    public User(int id, String password, String name){
        this.id = id;
        this.password = password;
        this.name = name;
    }


    public int get_id(){
        return this.id;
    }

    public String get_password(){
        return this.password;
    }

    public String get_name(){
        return this.name;
    }

    public void set_post(String post){
        this.post = post;
    }
    public String get_post(){
        return this.post;
    }

    public Boolean name_matcher() throws RegexException{
            String name_regex = "[A-Z]{1}+[A-Za-z]{2,}";
            Pattern pattern = Pattern.compile(name_regex);
            Matcher matcher = pattern.matcher(this.name);
            if(!matcher.matches()){
                throw new RegexException("Invalid name");
            }
            return true;

    }

    public Boolean id_matcher() throws RegexException{
        String id_regex = "[0-9]{1,2}";
            Pattern pattern = Pattern.compile(id_regex);
            Matcher matcher = pattern.matcher(this.id+"");
            if(!matcher.matches()){
                throw new RegexException("Invalid id");
            }
            return true;

    }

    public Boolean password_matcher() throws RegexException{
            String password_regex = "(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(.{6,})";
            Pattern pattern = Pattern.compile(password_regex);
            Matcher matcher = pattern.matcher(this.password);
            if(!matcher.matches()){
                throw new RegexException("Invalid password");
            }
            return true;
    }

    public Boolean post_matcher() throws RegexException{

        String post_regex = ".*#.*";
        Pattern pattern = Pattern.compile(post_regex);
        Matcher matcher = pattern.matcher(this.post);
        if(!matcher.matches()){
            throw new RegexException("Invalid post");
        }
        return true;
    }

    public Boolean analyse() throws Notallowedexception{

        SentimentAnalyser s1 = new SentimentAnalyser(this.post);
        s1.analyse();
        return true;
    }


}
