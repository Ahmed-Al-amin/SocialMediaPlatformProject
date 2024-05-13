package org.example.main.socialplatform.Contollers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.main.socialplatform.ConsleApp.User;

import java.io.IOException;

public class StartSignupController {
    User user;
    private Stage stage;
    private Scene scene;
    private Parent parent;
    public void setUser(User user)
    {
        this.user = user;

    }

    @FXML
    AnchorPane SearchFriendLabel;

    public void SearchFriend (MouseEvent a) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/SearchFriend.fxml"));
        parent = loader.load();

        SearchFriend friend = loader.getController();
        friend.setUser(user);

        //parent = FXMLLoader.load(getClass().getResource("/FXML/SearchFriend.fxml"));
        stage = (Stage) ((Node)a.getSource()).getScene().getWindow();

        scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    AnchorPane AddPostLabel;
    public void AddPost (MouseEvent a) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Post.fxml"));
        parent = loader.load();

        PostController post = loader.getController();
        post.setUser(user);
        //parent = FXMLLoader.load(getClass().getResource("/FXML/Dashboard.fxml"));
        stage = (Stage) ((Node)a.getSource()).getScene().getWindow();

        scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    AnchorPane EditProfileLabel;

    public void EditProfile (MouseEvent a) throws IOException {
        parent = FXMLLoader.load(getClass().getResource("/FXML/EditProfile.fxml"));
        stage = (Stage) ((Node)a.getSource()).getScene().getWindow();

        scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();

    }


}
