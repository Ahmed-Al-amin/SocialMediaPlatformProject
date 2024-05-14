package org.example.main.socialplatform.Contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.example.main.socialplatform.ConsleApp.Post;
import org.example.main.socialplatform.ConsleApp.User;
import org.example.main.socialplatform.Main;
import org.example.main.socialplatform.Models.DataTransfer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.main.socialplatform.Main.Posts;
import static org.example.main.socialplatform.Main.userPosts;
import static org.example.main.socialplatform.Models.DataTransfer.WritePostData;
//import static org.example.main.socialplatform.Main.userPosts;

public class PostController {
    public TextArea PostcontentLabel;
    public Label oldPostsLoabel;
    User user;
    private Stage stage;
    private Scene scene;
    private Parent parent;
    public void setUser(User user)
    {
        this.user = user;
        System.out.println(user.getUserName());
        this.oldPosts();
    }
    public void oldPosts()
    {
        userPosts = user.getAllPosts();
        String STR = "";
        for (Post postSearch : userPosts) {
            STR += postSearch.getContent();
            STR += "\n";
            STR += postSearch.getTimestamp();
            STR += "\n--------------------------------------------------\n";
        }
        oldPostsLoabel.setText(STR);
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
    public void EditProfile (ActionEvent a) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/EditProfile.fxml"));
        parent = loader.load();
        EditProfileController profile = loader.getController();//DashboardController post = new DashboardController();
        profile.setUser(user);

        //parent = FXMLLoader.load(getClass().getResource("/FXML/EditProfile.fxml"));
        stage = (Stage) ((Node)a.getSource()).getScene().getWindow();

        scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();
    }
    public void Friends (ActionEvent a) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Friends.fxml"));
        parent = loader.load();

        FriendController Friend = loader.getController();
        Friend.setUser(user);
        //parent = FXMLLoader.load(getClass().getResource("/FXML/Friends.fxml"));
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

    public void AddPost(ActionEvent a)
    {
        String content = PostcontentLabel.getText();
        LocalDateTime now = LocalDateTime.now();


        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = timeFormatter.format(now);


        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dateFormatter.format(now);

        String postTime = formattedTime + "  " + formattedDate;
        //System.out.println(formattedTime + " " + formattedDate);

        Post post = new Post(content,postTime);
        post.setAuthor(user.getUserName());
        post.setAuthorname(user.getName());
        Posts.add(post);
        user.addPost(post);

        WritePostData(user.getName(),user.getUserName(),post.getContent(),postTime,0,0,post.getPostId());

    }
}
