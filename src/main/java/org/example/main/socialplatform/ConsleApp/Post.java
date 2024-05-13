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

    private ArrayList<User> Mentioned = new ArrayList<User>();
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
public Post(String content, String username, String time,int noOfcomments, int noOflikes, int postid)
{
    this.content=content;
    this.author = username;
    this.timestamp = time;
    this.numberOfComments = noOfcomments;
    this.numberOfReacts = noOflikes;
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
    /*******************************************************Methods******************************************/

    public void addReact() {

        numberOfReacts++;
    }

    public ArrayList<User> getAllMentionedUsers() {

        return Mentioned;
    }
    public ArrayList<Comment> getAllComments() {

        return comments;
    }

    public Comment getOneComment(int commentId) {

        return getAllComments().get(commentId);
    }
    public void addMentionedUsers(User user){

        Mentioned.add(user);
    }
    public void addComment(Comment comment){

        comments.add(comment);
    }
/***********************************************************/

public void setPostPrivacy(Post post) {
    System.out.println("Enter a choice : ");
    System.out.println("1- For public");
    System.out.println("2- For private");
    boolean validate = false;
    int choice = 0;
    while (!validate) {
        try {
            choice = in.nextInt();
            validate = true;
        } catch (InputMismatchException e) {
            System.out.println("invaild choice try again");
            System.out.println("Enter a choice :");
            in.nextLine();
        }
    }



    }
}




