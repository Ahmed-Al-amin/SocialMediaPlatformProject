package org.example.main.socialplatform.ConsleApp;

import java.util.ArrayList;
import java.util.List;

//Done
public class Comment extends Author {

    /********************************************Attributes**************************************************/
    private static int Id=0;
    private int commentId;
    private List<Reply> userReplies;

    /************************************************Constructor***********************************************/

    public Comment(String content) {
        this.numberOfReacts = 0;
        commentId = Id;
        Id++;
        this.userReplies = new ArrayList<>();
        this.content =content;

    }
    /******************************************************Setters and Getters***********************************/

    public int getId(){
        return commentId;
    }

    public List<Reply> getUserReplies(){
        return userReplies;
    }

    public Reply getReply(int replyId){
        return getUserReplies().get(replyId);
    }

    @Override
    public int getReacts() {
        return numberOfReacts;
    }

    /**********************************************Methods******************************************************/

    public void addReply(Reply newReply){
        userReplies.add(newReply);
    }


    @Override
    public void addReact() {
        numberOfReacts++;
    }

    public void editReply(int replyId,String newContent){
        getReply(replyId).setContent(newContent);
        System.out.println("Reply edited");
    }

    public void deleteReply(int replyId){
        getUserReplies().remove(getReply(replyId));
        System.out.println("Reply deleted");
    }



}