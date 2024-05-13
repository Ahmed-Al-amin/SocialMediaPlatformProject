package org.example.main.socialplatform.ConsleApp;

import java.util.ArrayList;
import java.util.List;

//Done
public class Comment extends Author {

    /********************************************Attributes**************************************************/
    private static int Id=0;
    private int commentId;
    private int postId;


    /************************************************Constructor***********************************************/

    public Comment(String content) {
        this.numberOfReacts = 0;
        commentId = Id;
        Id++;
        this.content =content;

    }
    public Comment (String content, String name,String time,int postid )
    {
        this.content = content;
        this.timestamp = time;
        this.author = name;
        this.postId = postid;
    }
    /******************************************************Setters and Getters***********************************/

    public int getId(){
        return commentId;
    }
    public int getPostId(){
        return postId;
    }
    public void SetPostId(int postId ){
        this.postId = postId;
    }




    @Override
    public int getReacts() {
        return numberOfReacts;
    }

    /**********************************************Methods******************************************************/



    @Override
    public void addReact() {
        numberOfReacts++;
    }






}