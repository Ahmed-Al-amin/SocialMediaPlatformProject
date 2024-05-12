package org.example.main.socialplatform.ConsleApp;

import org.example.main.socialplatform.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

//Done
public class UserLogin {

    /************************************************Attributes**************************************************/
    private static String username;
    private static String password;
    private static String Email;
    private static String phoneNumber;
    private static User user;

    static Scanner in = new Scanner(System.in);

    /*******************************************LogIn******************************************************/
    public static User LogIn() {
        User user;
        String FirstInput;
        System.out.println("Login page");
        System.out.println("Enter Email or PhoneNumber or username  : ");
        FirstInput = in.next();
        if (FirstInput.equals("0")) {

        }

        while (FirstInput.isEmpty()) {
            System.out.println("Email or PhoneNumber or Username is Empty please Try again : ");
            System.out.println("Enter Email or PhoneNumber :");
            FirstInput = in.next();
            if (FirstInput.equals("0")) {
                Starts();
            }
        }
        if (password.equals("0")) {
            Starts();
        }
        while (password.isEmpty()) {
            System.out.println("Password is Empty please Try again : ");
            System.out.println("Enter Password :");
            password = in.next();
            if (password.equals("0")) {
                Starts();
            }
        }
        if (!ValidateLogin(FirstInput, password)) {
            System.out.println("Username or Password is not correct please Try again : ");
            LogIn();
        }
        // new Feed(Feed.GetUserData(username));
        //return Feed.GetUserData(username);
        return null;
    }

    public static boolean ValidateLogin(String Username, String Password) {
        for (User user : Main.Users) {
            if ((user.getUserName().equals(Username) || user.getEmail().equals(Username) || user.getPhoneNumber().equals(Username))
                    && user.getPassword().equals(Password)) {
                return true;
            }
        }
        return false;
    }
/*****************************************************SinUp**************************************************/

public static User SignUp() {
    BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

    System.out.println("/t Welcome To our Facebook");
    System.out.println("Enter Username at least 8 chars):");
    username = in.next();
    while (username.length() < 8){
        System.out.println("Username is Empty please Try again : ");
        System.out.println("Enter Username :");
        username = in.next();
    }
//    while (!UniqueUsers(username)){
//        System.out.println("Username is already exist please Try another one : ");
//        System.out.println("Enter Username :");
//        username = in.next();
//    }

    System.out.println("Enter Password :");
    password = in.next();

    while (password.length()<8){
        System.out.println("Password is Empty please Try again : ");
        System.out.println("Enter Password :");
        password = in.next();
    }
    user = new User(username, password);
    System.out.println("SignUp Successful");
    System.out.println("Now you need to enter some information");
    System.out.println("Enter your name:");

    String name = new String();
    try {
        name = reader.readLine();
    } catch (IOException e) {
        System.out.println("Error reading input: " + e.getMessage());
    }

    while (name.isEmpty()){
        System.out.println("name is Empty please Try again : ");
        System.out.println("Enter your name :");
        try {
            name = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
    System.out.println("Enter gender :");
    String gender=in.next();
    while ((!(gender.toLowerCase()).equals("female")) && (!(gender.toLowerCase()).equals("male"))){
        System.out.println("gender is not valid please Try again : ");
        System.out.println("Enter gender :");
        gender = in.next();
    }
    String phonenumber=new String();
    while (true) {
        System.out.println("Please enter your phone number : ");
        String input = in.next();

        if (!input.matches("[0-9]+")) {
            System.out.println("Phone number should contain digits only. Please try again.");

        } else if (input.length()<11) {
            System.out.println("Phone Number is not valid please Try again :( ");

        } else {
            phonenumber = input;
            break;
        }
    }

    System.out.println("Enter E_mail :");
    String email = in.next();
    while (email.isEmpty() || email.contains(" ") || !email.contains("@") || email.length()<10){
        System.out.println("E_mail is Empty please Try again : ");
        System.out.println("Enter E_mail :");
        email = in.next();
    }
    int age = 0;
    Boolean validateInput = false;
    while (!validateInput) {
        try {
            age = in.nextInt();
            validateInput = true;
        } catch (InputMismatchException e) {
            System.out.println("invalid age, Please try again");
            System.out.println("Try again :");
            in.nextLine();

        }
    }
        user.setName(name);
        user.setPhoneNumber(phonenumber);
        user.setEmail(email);
        //user.setBirthdate(dateOfBirth);
        user.setAge(age);
        Main.Users.add(user);
        System.out.println("Wish you enjoy our platform :)");
        //new Feed(user);
        return user;
    }


    /********************************************************Start the Programme*******************************/
    public static void Starts()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("******************* Welcome To our Social Media Platform **********************");
        System.out.println("Enter a choice :");
        System.out.println("1- To Login");
        System.out.println("2- To Signup");

        int choice = 0;
        Boolean validateInput = false;
        while (!validateInput) {
            try {
                choice = in.nextInt();
                validateInput = true;
            } catch (InputMismatchException e) {
                System.out.println("invalid choice, Please try again");
                System.out.println("Try another choice :");
                in.nextLine();

            }
        }
        switch (choice) {
            case 1:
                user = LogIn();
                break;
            case 2:
                user = SignUp();
                break;
            default:
                System.out.println("Invalid Choice please try again : ");

        }
    }
}