package org.example.main.socialplatform;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.main.socialplatform.ConsleApp.*;
import org.example.main.socialplatform.Models.DataTransfer;
import org.example.main.socialplatform.Models.Model;

import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<User> Users = new ArrayList<>();
    public static ArrayList<Post> Posts = new ArrayList<>();
    public static ArrayList<Comment> comments = new ArrayList<>();
    public static ArrayList<Comment> postcomments = new ArrayList<>();
    public static ArrayList<Post> userPosts = new ArrayList<>();
    public static ArrayList<Friendship> Friendships = new ArrayList<>();
    public static ArrayList<Friendship> FriendshipsAccepted = new ArrayList<>();
    public static ArrayList<Friendship> FriendshipsPending = new ArrayList<>();
    public static ArrayList<User> UserFriendAccepted = new ArrayList<>();
    public static ArrayList<User> UserFriendRequest = new ArrayList<>();
    public static ArrayList<Likes> likes = new ArrayList<>();
    public static ArrayList<String> Likesusers = new ArrayList<>();

    //public static ArrayList<User> UserFriendSending = new ArrayList<>();


    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Social media Platform");

        Image icon = new Image(getClass().getResource("/Photos/facebook.png").toExternalForm());
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            Exit(primaryStage);
        });
    }


    public void Exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to Exit");
        alert.setContentText("Are you sure you want to Exit");
        if (alert.showAndWait().get() == ButtonType.OK)
        {
            System.exit(1);
        }

    }

    public static void StartPrograme ()
    {
        DataTransfer.getAllUsers();
        DataTransfer.getAllPosts();
        DataTransfer.getAllComments();
        DataTransfer.getAllFriends();
        DataTransfer.getAllLikes();
        DataTransfer.Organizing();
    }
    public static void main(String[] args) {
          Main.StartPrograme();
          launch(args);

    }
    }

