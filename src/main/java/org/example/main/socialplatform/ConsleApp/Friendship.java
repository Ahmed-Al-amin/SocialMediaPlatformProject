package org.example.main.socialplatform.ConsleApp;

import org.example.main.socialplatform.Main;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Friendship {
    private User User1, User2;

    private String FriendshipStatus;
    private int Friend1Role, Friend2Role;
    ArrayList<Post> MutualPosts = new ArrayList<>();
    Timestamp FriendsSince;

    /*******************************************Constructors************************************************/


    public Friendship(User User1, User User2) {
        this.User1 = User1;
        this.User2 = User2;
        FriendshipStatus = "Pending";
    }

    public Friendship(User User1, User User2, int Friend1_Role, int Friend2_Role, String Friendship_status, Timestamp FriendsSince) {
        this.User1 = User1;
        this.User2 = User2;
        this.Friend1Role = Friend1_Role;
        this.Friend2Role = Friend2_Role;
        this.FriendshipStatus = Friendship_status;
        this.FriendsSince = FriendsSince;
        if (Friendship_status.equals("Accepted"))
        {
            this.User1.AddFriend(this.User2);
            this.User2.AddFriend(this.User1);
        }
    }

/***************************************Setters and Getters************************************************/

    public User getUser1() {
        return User1;
    }

    public User getUser2() {
        return User2;
    }
    public Timestamp getFriendsSince() {
        return FriendsSince;
    }
    public void setFriendshipStatus(String FriendshipStatus) {
        this.FriendshipStatus = FriendshipStatus;
    }

    public String getFriendshipStatus() {
        return FriendshipStatus;
    }

    public ArrayList<Post> getMutualPosts() {
        return MutualPosts;
    }

    public int getFriend1Role() {
        return Friend1Role;
    }

    public int getFriend2Role() {
        return Friend2Role;
    }

    public void setFriendship_Role(int friendRole, User user) {
        if (user == this.User1)
            Friend1Role = friendRole;
        if (user == this.User2)
            Friend2Role = friendRole;
    }

    public void addMutualPost(Post post){
        MutualPosts.add(post);
    }

    /**************************************************Methods*****************************************/

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

    public boolean see_role(User user){
        if (user == User1)
        {
            if (Friend1Role == 1)
                return true;
            return false;
        }
        else if (Friend2Role == 1)
            return true;
        return false;
    }

    public void acceptFriendRequest(User Sender) {
        FriendshipStatus = "Accepted";
        System.out.println("You accepted friend request from " + Sender.getUserName() +" \nNow you are Friends" );
        User1.AddFriend(User2);
        User2.AddFriend(User1);
        Friendship f = new Friendship(User1, User2);
        Main.Friendships.add(f);
    }

    public void declineFriendRequest(User Sender) {
        FriendshipStatus = "Declined";
        System.out.println("You declined friend request from " + Sender.getUserName());
    }

    public long GetRelationTimeInDays (){
        Timestamp t=Timestamp.valueOf(LocalDateTime.now());
        long x=t.getTime()-FriendsSince.getTime();
        x=x/86400000;
        return x;
    }
}
