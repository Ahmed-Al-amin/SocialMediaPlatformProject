package org.example.main.socialplatform.ConsleApp;

//Done
public class Reply extends Author {

    /***********************************************Attributes*******************************************/
    private static int Id=0;

    private int replyId;

    /*********************************************Constructor**********************************************/

    public Reply(String content) {
        replyId=Id;
        Id++;
        this.content=content;
    }


    /******************************************************Methods******************************************/
    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getId() {
        return replyId;}

    @Override
    public void addReact() {
        numberOfReacts++;
    }

    @Override
    public int getReacts() {
        return numberOfReacts;
    }

}

