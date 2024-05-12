package org.example.main.socialplatform.Contollers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.main.socialplatform.ConsleApp.User;

import java.io.IOException;

public class DashboardController {
    User user;
    private Stage stage;
    private Scene scene;
    private Parent parent;

    @FXML
    private Button AddPostButton;

    @FXML
    private Button LogoutButton;

    @FXML
    private Button SearchButton;

    @FXML
    private Button SeelistButton;

    @FXML
    private AnchorPane addPostPane;

    @FXML
    private Button editProfileButton;

    @FXML
    private VBox viewPostBox;
    @FXML
    private Button SeePostsButton;

    public void setUser(User user)
    {
        this.user = user;

    }
    int i = 0;
    public  void addPost(ActionEvent a){
        addPostPane.setVisible(true);
        viewPostBox.setVisible(false);
        AddPostButton.setVisible(false);
        SeePostsButton.setVisible(true);



    }
    public  void seePosts(ActionEvent a){
        addPostPane.setVisible(false);
        viewPostBox.setVisible(true);
        SeePostsButton.setVisible(false);
        AddPostButton.setVisible(true);



    }

    public void Logout(ActionEvent a) throws IOException {
        parent = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
        stage = (Stage) ((Node)a.getSource()).getScene().getWindow();

        scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();
    }


}
