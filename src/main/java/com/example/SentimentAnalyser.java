package com.example;
public class SentimentAnalyser{
    String post;

    public SentimentAnalyser(String post){
        this.post = post;
    }

    public String analyse() throws Notallowedexception{

        if(this.post.contains("Kill")){
            throw new Notallowedexception("Post contains not restricted words");
        }
        else if(this.post.contains("Accident") || this.post.contains("Hospital")){
            return "Negative";
        }
        else if(this.post.contains("Motivation") || this.post.contains("Growth")){
            return "Positive";
        }
        else{
            return "Neutral";
        }
    }
    
}