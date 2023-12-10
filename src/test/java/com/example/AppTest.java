package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Executing this before all");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("All tests done!");
    }

    
    @Test
    public void test_for_user_name(){
        User u1 = new User(2, "Him@123", "Himanshu"); 
        try {
            assertTrue(u1.name_matcher());
        } catch (RegexException e) {
            
            System.out.println(e.getMessage());
        }
        User u2 = new User(2, "Him@123", "himanshu"); 
        try {
            assertTrue(u2.name_matcher());
            fail("Testcase should fail here");
        } catch (RegexException e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void test_for_user_id(){
        User u1 = new User(2, "Him@123", "Himanshu"); 
        try {
            assertTrue(u1.id_matcher());
        } catch (RegexException e) {
            
            System.out.println(e.getMessage());
        }
        User u2 = new User(455, "Him@123", "Himanshu"); 
        try {
            assertTrue(u2.id_matcher());
            fail("Testcase should fail here");
        } catch (RegexException e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void test_for_user_password(){
        User u1 = new User(2, "Him@123", "Himanshu"); 
        try {
            assertTrue(u1.password_matcher());
        } catch (RegexException e) {
            
            System.out.println(e.getMessage());
        }
        User u2 = new User(4, "him@123", "Himanshu"); 
        try {
            assertTrue(u2.password_matcher());
            fail("Testcase should fail here");
        } catch (RegexException e) {
            
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test_for_user_post(){
        User u1 = new User(2, "Him@123", "Himanshu");
        u1.set_post("#Hello"); 
        try {
            assertTrue(u1.post_matcher());
        } catch (RegexException e) {
            
            System.out.println(e.getMessage());
        }
        User u2 = new User(4, "Him@123", "Himanshu"); 
        u2.set_post("Hello world");
        try {
            assertTrue(u2.post_matcher());
            fail("Testcase should fail here");
        } catch (RegexException e) {
            
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test_for_sentiment(){
        User u1 = new User(2, "Him@123", "Himanshu");
        u1.set_post("#Growth"); 
        try {
            assertTrue(u1.analyse());
        } catch (Notallowedexception e) {
            
            System.out.println(e.getMessage());
        }
        User u2 = new User(4, "Him@123", "Himanshu"); 
        u2.set_post("#Happy");
        try {
            assertTrue(u2.analyse());
            fail("Testcase should fail here");
        } catch (Notallowedexception e) {
            
            System.out.println(e.getMessage());
        }
    }
}
