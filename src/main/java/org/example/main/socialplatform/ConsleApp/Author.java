package org.example.main.socialplatform.ConsleApp;

import java.sql.Date;
import java.sql.Timestamp;


//Done
public abstract class Author {
    /********************************************Attributes*****************************************/
    protected int Id;
    protected String  author;
    protected String content;
    protected String timestamp;
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
    public String getTimestamp() {

        return timestamp;
    }
    public void setTimestamp(String timestamp) {

        this.timestamp = timestamp;
    }

    public void setAuthor(String author) {

        this.author = author;
    }
    public String getAuthor() {

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
