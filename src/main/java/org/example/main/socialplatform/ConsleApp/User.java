package org.example.main.socialplatform.ConsleApp;

import java.util.ArrayList;
import java.util.Date;


//Done
public class User {

    /*********************************************Attributes****************************************/
    private String name;
    private int UserId;
    private String bio;
    private String userName;
    //private Date Birthdate;
    private Date accountCreationDate;
    private String password;
    private int age;
    private String phoneNumber;
    private String Email;
    private static int numberOfUsers = 0;

    private String gender;

    private ArrayList<User> Friends = new ArrayList <User>();

    private ArrayList<Post> Posts = new ArrayList<Post>();
    private ArrayList<Friendship> relations = new ArrayList<Friendship>();



    /*************************************************Constructors**************************************/
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
        numberOfUsers++;

    }
    public User(String userName, String password, String Email){
        UserId=numberOfUsers;
        numberOfUsers++;
        this.userName = userName;
        this.password = password;
        this.Email = Email;

    }

    public User(String name, String userName, String password, int age, String gender, String phoneNumber, String email) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.Email = email;
        this.gender = gender;
        UserId = numberOfUsers;
        numberOfUsers++;
    }

    /****************************************************Setters and Getters**************************************/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserID() {
        return this.UserId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
    public String getGender() {

        return gender;
    }
    public void setGender(String gender) {

        this.gender = gender;
    }

/***********************************************Methods**********************************************/
    public ArrayList<Post> getAllPosts() {

        return Posts;
    }
    public Post getOnePost(int postId) {

        return getAllPosts().get(postId);
    }
    public void addPost(Post post) {

        Posts.add(post) ;
    }
    public ArrayList<User>getFriends() {
        return Friends;
    }
    public void RemoveFriend(User Friend_User){

        Friends.remove(Friend_User);
    }


    public void AddFriend(User NewFriend) {

        Friends.add(NewFriend);
    }

    /*public String getBirthdateString() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(getBirthdate());
        return formattedDate;
    }*/
}