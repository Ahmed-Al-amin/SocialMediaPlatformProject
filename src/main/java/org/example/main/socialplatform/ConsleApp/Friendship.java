package org.example.main.socialplatform.ConsleApp;

import org.example.main.socialplatform.Main;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Friendship {
    private User User1, User2;

    private String FriendshipStatus;

    private String FriendsSince;

    /*******************************************Constructors************************************************/


    public Friendship(User User1, User User2, String status, String time) {
        this.User1 = User1;
        this.User2 = User2;
        this.FriendshipStatus = status;
        this.FriendsSince = time;
    }


    /***************************************Setters and Getters************************************************/

    public User getUser1() {
        return User1;
    }

    public User getUser2() {
        return User2;
    }

    public String getFriendsSince() {
        return FriendsSince;
    }

    public void setFriendshipStatus(String FriendshipStatus) {
        this.FriendshipStatus = FriendshipStatus;
    }

    public String getFriendshipStatus() {
        return FriendshipStatus;
    }
}

    /**************************************************Methods*****************************************/
/*
    public static Friendship getFriendship(User First_User, User Second_User) {
        int ID1 = First_User.getUserID();
        int ID2 = Second_User.getUserID();
        for (Friendship friendship : Main.Friendships) {
            if ((friendship.User1.getUserID() == ID1 || friendship.User1.getUserID() == ID2) && (friendship.User2.getUserID() == ID1 || friendship.User2.getUserID() == ID2)) {
                return friendship;
            }
        }
        return null;
    }
    public static Friendship Remove_Friendship(User First_User, User Second_User) {
        int ID1 = First_User.getUserID();
        int ID2 = Second_User.getUserID();
        for (Friendship friendship : Main.Friendships) {
            if ((friendship.User1.getUserID() == ID1 || friendship.User1.getUserID() == ID2)
                    && (friendship.User2.getUserID() == ID1 || friendship.User2.getUserID() == ID2))
                Main.Friendships.remove(friendship);
        }
        return null;
    }

    public void acceptFriendRequest(User Sender) {
        FriendshipStatus = "Accepted";
        System.out.println("You accepted friend request from " + Sender.getUserName() +" \nNow you are Friends" );
        User1.AddFriend(User2);
        User2.AddFriend(User1);
        Friendship f = new Friendship(User1, User2);
        Main.Friendships.add(f);
    }
*/

