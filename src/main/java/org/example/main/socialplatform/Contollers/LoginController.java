package org.example.main.socialplatform.Contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.main.socialplatform.ConsleApp.User;
import org.example.main.socialplatform.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public Button LoginButton;
    public Button CreateAccountButton;
    private Stage stage;
    private Scene scene;
    private Parent parent;



    /***************************************************Signup Controller*************************************/




    public void SignupScene(ActionEvent a) throws IOException {
        parent = FXMLLoader.load(getClass().getResource("/FXML/Signup.fxml"));
        stage = (Stage) ((Node)a.getSource()).getScene().getWindow();

        scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();
    }

    /*************************************Login***********************************************/

    @FXML
    private TextField Usernamefield;
    @FXML
    private PasswordField PasswordField;

    @FXML
    private Label InvalidLabel;

    public void Login(ActionEvent actionEvent) throws IOException {
        User user = null;
        String username = Usernamefield.getText();
        String password = PasswordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            InvalidLabel.setText("Username or password is empty");
            InvalidLabel.setVisible(true);

        } else {
            for (User userSearch : Main.Users) {
                if ((userSearch.getUserName().equals(username) || userSearch.getEmail().equals(username) || userSearch.getPhoneNumber().equals(username))
                        && userSearch.getPassword().equals(password)) {
                    InvalidLabel.setVisible(false);
                    user = userSearch;
                    System.out.println(userSearch.getName());
                    DashboardController post = new DashboardController();
                    post.setUser(userSearch);
                    parent = FXMLLoader.load(getClass().getResource("/FXML/Dashboard.fxml"));
                    stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                    scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.show();
                }
            }
            if (user == null)
            {
                InvalidLabel.setText("Invalid username or password");
                InvalidLabel.setVisible(true);
            }
        }


    /*********************************************Create account label************************************/


}

    public void Editing2(MouseEvent mouseEvent) {
        CreateAccountButton.setTextFill(Color.BLACK);
        CreateAccountButton.setUnderline(false);

    }

    public void Editing1(MouseEvent mouseEvent) {
        CreateAccountButton.setTextFill(Color.rgb(100,100,255));
        CreateAccountButton.setUnderline(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
