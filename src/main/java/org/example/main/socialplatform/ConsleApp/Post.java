package org.example.main.socialplatform.ConsleApp;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Post extends Author {
    /*********************************************Attributes*********************************************/
    public static int Id = 0;
    public int postId;
    private String Authorname;

    //private ArrayList<User> Mentioned = new ArrayList<User>();
    private final ArrayList<Comment> comments = new ArrayList<Comment>();
    private int numberOfComments;

    Scanner in = new Scanner(System.in);


/***********************************************Constructors***********************************************/
public Post() {
    postId=Id;
    Id++;

}
public Post(String content, String date) {
    super.content = content;
    super.timestamp = date;
    postId=Id;
    Id++;

}
public Post(String name,String content, String username, String time, int postid)
{
    this.Authorname = name;
    this.content=content;
    this.author = username;
    this.timestamp = time;
    this.postId = Id;
    Id++;

}

/*************************************************Setters and Getters**************************************/
    @Override
    public int getId() {
        return postId;
    }

    public int getReacts() {
        return numberOfReacts;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }


    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public String getAuthorname() {
        return Authorname;
    }

    public void setAuthorname(String authorname) {
        Authorname = authorname;
    }

    /*******************************************************Methods******************************************/

    public void addReact() {

        numberOfReacts++;
    }
    public void DeleteReact() {

        numberOfReacts--;
    }

//    public ArrayList<User> getAllMentionedUsers() {
//
//        return Mentioned;
//    }
    public ArrayList<Comment> getAllComments() {

        return comments;
    }

    public Comment getOneComment(int commentId) {

        return getAllComments().get(commentId);
    }
//    public void addMentionedUsers(User user){
//
//        Mentioned.add(user);
//    }
    public void addComment(Comment comment){

        comments.add(comment);
    }
/***********************************************************/






}




