package org.example.main.socialplatform.Contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.main.socialplatform.ConsleApp.Friendship;
import org.example.main.socialplatform.ConsleApp.Post;
import org.example.main.socialplatform.ConsleApp.User;
import org.example.main.socialplatform.Main;
import org.example.main.socialplatform.Models.DataTransfer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.main.socialplatform.Main.StartPrograme;
import static org.example.main.socialplatform.Main.userPosts;

public class FriendController {
    public TextField SearchField;
    public Button SearchButton;

    public Label SearchPlace;
    public AnchorPane SearchPane;
    public Button SearchAgainButton;
    public TextField addField;
    public Button addButton;
    public Label addLabel;
    public Label RequestLabel;
    public Label FriendListLabel;
    public TextField AcceptField;
    User user;
    private Stage stage;
    private Scene scene;
    private Parent parent;
    public void setUser(User user)
    {
        this.user = user;
        this.reset();
    }
    /**************************************************Search Friend************************************************/
    public void Search(ActionEvent a)
    {


        String name = SearchField.getText();
        if (!(name.isEmpty())){
            String str = "";
            for (User searchuser: Main.Users)
            {
                if (searchuser.getName().contains(name))
                {
                    str += searchuser.getName() + "\n";
                    str += searchuser.getUserName() ;
                    str += "\n---------------\n";
                    //System.out.println(str);
                }
            }
            if (str.equals(""))
            {
                SearchPlace.setText("There is no users");
            }
            else
            {
                SearchPlace.setText(str);
            }

        }

    }
    /*****************************************************Add Friend *************************************************/
    public void AddFriend (ActionEvent a) {
        String user2 = addField.getText();
        User user22 = null;
        boolean flage = false;
        for (User usersearch : Main.Users)
        {
            if (usersearch.getUserName().equals(user2))
            {
                user22 = usersearch;
                flage = true;
                break;
            }

        }
        if (flage) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            String formattedTime = timeFormatter.format(now);
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = dateFormatter.format(now);
            String FriendTime = formattedTime + "  " + formattedDate;

            Friendship friend = new Friendship(user, user22, "Pending", FriendTime);
            Main.Friendships.add(friend);
            user22.AddFriendRequest(user);
            DataTransfer.WriteFriendsData(user.getUserName(), user22.getUserName(), FriendTime, "Pending");
            DataTransfer.Organizing();
            this.friendRequest();
        }
    }
    int index = 0;
    public void AcceptFriend()
    {
        String user2 = AcceptField.getText();
        boolean flage = false;
        User user22 = null;
        for (User usersearch : Main.Users)
        {
            if (usersearch.getUserName().equals(user2))
            {
                flage = true;
                break;
            }

        }
        if (flage){
        boolean flage2 = false;
        Main.UserFriendRequest = user.getFriendsRequest();

        for (User userSearch : Main.UserFriendRequest)
        {
            if (user2.equals(userSearch.getUserName()))
            {
                user22 = userSearch;
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                String formattedTime = timeFormatter.format(now);
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String formattedDate = dateFormatter.format(now);
                String FriendTime = formattedTime + "  " + formattedDate;
                user.AddFriend(userSearch);
                userSearch.AddFriend(user);
                user.getFriendsRequest().remove(user22);
                DataTransfer.UpdateFriends(user.getUserName(), "Accepted", FriendTime);
                flage2 = true;
                break;
            }
        }
        if (flage2)
        {
            Main.UserFriendRequest.remove(user22);
            user.getFriendsRequest().remove(user22);
        }
        //this.friendsview();
        //this.friendRequest();
            this.reset();
        }
    }

    public void reset()
    {
        RequestLabel.setText("");
        FriendListLabel.setText("");
        this.friendsview();
        this.friendRequest();

    }


    public void friendRequest()
    {
        Main.UserFriendRequest = user.getFriendsRequest();
        String STR = "";
        for (User user : Main.UserFriendRequest) {
            STR += user.getName() + "\n";
            STR += user.getUserName();
            STR += "\n--------------------------------------------------\n";
        if (STR.equals(""))
            RequestLabel.setText("No requests");
        else
            RequestLabel.setText(STR);
    }
    }

    public void friendsview ()
    {
        Main.UserFriendAccepted = user.getFriends();
        String STR = "";
        for (User user : Main.UserFriendAccepted) {
            STR += user.getName() + "\n";
            STR += user.getUserName();
            STR += "\n--------------------------------------------------\n";
        }
        if (STR.equals(""))
            FriendListLabel.setText("No Friends");
        else
            FriendListLabel.setText(STR);
    }











    /*********************************************Switching Scenes**********************************/

    public void Addpost (ActionEvent a) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Post.fxml"));
        parent = loader.load();

        PostController post = loader.getController();
        post.setUser(user);
        //parent = FXMLLoader.load(getClass().getResource("/FXML/Post.fxml"));
        stage = (Stage) ((Node)a.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }
    public void EditProfile (ActionEvent a) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/EditProfile.fxml"));
        parent = loader.load();

        EditProfileController Edit = loader.getController();
        Edit.setUser(user);
        //parent = FXMLLoader.load(getClass().getResource("/FXML/EditProfile.fxml"));
        stage = (Stage) ((Node)a.getSource()).getScene().getWindow();

        scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();
    }
    public void Dashboard (ActionEvent a) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Dashboard.fxml"));
        parent = loader.load();
        DashboardController dash = loader.getController();
        dash.setUser(user);

        //parent = FXMLLoader.load(getClass().getResource("/FXML/Dashboard.fxml"));
        stage = (Stage) ((Node)a.getSource()).getScene().getWindow();

        scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();
    }
    public void Logout(ActionEvent a) throws IOException {
        parent = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
        stage = (Stage) ((Node)a.getSource()).getScene().getWindow();

        scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();
    }

}
