package org.example.main.socialplatform.ConsleApp;

import java.sql.Timestamp;


//Done
public abstract class Author {
    /********************************************Attributes*****************************************/
    protected int Id;
    protected User author;
    protected String content;
    protected Timestamp timestamp;
    protected int numberOfReacts=0;

    /************************************************Constructors**************************************/


    public Author(int id) {
        this.Id = id;
    }

    public Author(){}

    /***********************************************Setters and Getters***************************************/


    public int getId() {

        return Id;
    }

    public void setCntReacts(int cntReacts) {
        this.numberOfReacts = cntReacts;
    }
    public Timestamp getTimestamp() {

        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {

        this.timestamp = timestamp;
    }

    public void setAuthor(User author) {

        this.author = author;
    }
    public User getAuthor() {

        return author;
    }
    public void setContent(String content) {

        this.content = content;
    }
    public String getContent(){
        return content;}


    /****************************************Methods**********************************/

    public void displayContent() {
        System.out.println(content);
    }

    /**************************************************Abstract Methods******************************/
    public abstract void addReact();

    public abstract int getReacts();
}
