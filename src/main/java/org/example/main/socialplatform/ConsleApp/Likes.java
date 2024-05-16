package org.example.main.socialplatform.ConsleApp;

import java.util.ArrayList;

public class Likes {
    private int count ;
    private int postId;
    private ArrayList<String> users = new ArrayList<>();


    public Likes (int postId)
    {
        this.count=0;
        this.postId = postId;
    }
    /************************************************************************************************************/
    public int getPostId()
    {
        return this.postId;
    }
    public ArrayList<java.lang.String> getusers()
    {
        return users;
    }
    public int getCount()
    {
        return count;
    }
    public void Adduser(String user)
    {
        users.add(user);
    }

}
