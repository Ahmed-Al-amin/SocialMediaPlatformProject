package org.example.main.socialplatform.Contollers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.main.socialplatform.ConsleApp.User;

import java.io.IOException;

public class PostController {
    User user = null;
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
    private Button editProfileButton;



    @FXML
    private Button seeProfileButton;


    public void setUser(User user)
    {
        this.user = user;

    }

    public void Logout(ActionEvent a) throws IOException {
        parent = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
        stage = (Stage) ((Node)a.getSource()).getScene().getWindow();

        scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();
    }


}
