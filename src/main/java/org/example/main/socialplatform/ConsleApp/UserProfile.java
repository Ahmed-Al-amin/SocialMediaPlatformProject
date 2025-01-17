package org.example.main.socialplatform.ConsleApp;

import java.util.Scanner;

public class UserProfile {
    static Scanner in = new Scanner(System.in);
    static User user;
    //Feed feed;
    public UserProfile(User user) {
        this.user = user;
        viewDashboard();
    }

    public void viewDashboard() {
        System.out.println("1-View Your Profile");
        System.out.println("2-Update Your Profile");
        System.out.println("3-view my post");
        System.out.println("4-Back To Your Feed");
        boolean InvalidChoice = true;
        while (InvalidChoice = true) {
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    viewProfile();
                    break;
                case 2:
                    updateProfile();
                    break;
                case 3:
                    //Feed.view_my_posts(user);
                    break;
                case 4:
                    //backToFeed();
                    break;
                default:
                    System.out.println("Invalid choice, try again: ");
                    break;
            }
        }
    }

    public void viewProfile() {
        System.out.println("Profile:");
        System.out.println("UserName " + user.getUserName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Gender: " + user.getGender());
        System.out.println("age: " + user.getAge());
        //System.out.println("Date of birth: " + user.getBirthdateString());
        System.out.println("Phone Number: " + user.getPhoneNumber());
        System.out.println("1- Return back to dashboard");
        System.out.println("2- Return back to feed");
        boolean InvalidChoice = true;
        while (InvalidChoice = true) {
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    viewDashboard();
                    break;
                case 2:
                    //backToFeed();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    InvalidChoice = true;
            }
        }
    }
    public void updateProfile() {
        System.out.println("1- Update Your UserName");
        System.out.println("2- Change Your Password");
        System.out.println("3- Return To Dashboard");
        boolean InvalidChoice = true;
        while (InvalidChoice = true) {
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    updateUserName();
                    break;
                case 2:
                    changePassword();
                    break;
                case 3:
                    viewDashboard();
                    break;
                default:
                    System.out.println("Invalid Choice, try again: ");
                    break;
            }
        }
    }
    public void updateUserName() {
        boolean InvalidChoice = true;
        System.out.println("Current User Name: " + user.getUserName());
        System.out.println("Enter your New Name: ");
        user.setUserName(in.next());
        while (user.getUserName().length() < 8) {
            System.out.println("Username Should be More Than 8 Characters, Try Again: ");
            System.out.println("Enter Username :");
            user.setUserName(in.next());
        }
        System.out.println("Username is updated successfully :)");
        System.out.println("Your new username is " + user.getUserName());
        System.out.println("1- Return back to dashboard");
        System.out.println("2- Return back to feed");
        System.out.println("3- View your profile");
        while (InvalidChoice = true) {
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    viewDashboard();
                    break;
                case 2:
                    //backToFeed();
                    break;
                case 3:
                    viewProfile();
                    break;
                default:
                    System.out.println("Invalid Choice, Try Again: ");
            }
        }
    }

    public void changePassword() {
        String oldPassword;
        String NewPassword;
        System.out.println("Enter your current password: ");
        oldPassword = in.next();
        while (!user.getPassword().equals(oldPassword)) {
            System.out.println("Wrong Password, Please try again: ");
            oldPassword = in.next();
        }
        System.out.println("Enter your New password: ");
        NewPassword = in.next();
        while (NewPassword.length() < 8){
            System.out.println("Password Should be More Than 8 Characters, Try Again: ");
            NewPassword = in.next();
        }
        user.setPassword(NewPassword);
        System.out.println("password updated successfully");
        viewDashboard();
    }

    void ViewPostsOfMe() {
        System.out.println ("Posts");
        for (Post Posts : user.getAllPosts())
        {
            System.out.println(Posts);
        }
    }
    public void editPost(Post post){
        String edittedContent= in.next();
        post.setContent(edittedContent);
    }

//    public void backToFeed() {
//        feed = new Feed(user);
//    }
}
