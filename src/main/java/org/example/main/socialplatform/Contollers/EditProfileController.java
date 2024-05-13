package org.example.main.socialplatform.Contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.main.socialplatform.ConsleApp.User;

import java.io.IOException;

import static org.example.main.socialplatform.Contollers.SignupController.UniqueUsers;

public class EditProfileController {
    private Stage stage;
    private Scene scene;
    private Parent parent;
    User user;
    public void setUser(User user)
    {

        this.user = user;
        this.viewData();

    }
    @FXML
    TextField NameField;

    @FXML
    TextField EmailField;
    @FXML
    TextField phoneNumberField;
    @FXML
    TextField ageField;
    @FXML
    Label nameLabel;

    @FXML
    Label emailLabel;
    @FXML
    Label phoneLabel;
    @FXML
    Label ageLabel;
    @FXML
    Label genderlabel;
    @FXML
    RadioButton maleButton;
    @FXML
    RadioButton femaleButton;
    @FXML
    Label UsernameLabe;
    @FXML
    TextField bioField;


    public void viewData()
    {
        NameField.setText(user.getName());
        EmailField.setText(user.getEmail());
        phoneNumberField.setText(user.getPhoneNumber());
        ageField.setText(String.valueOf(user.getAge()));
        genderlabel.setText(user.getGender());
        UsernameLabe.setText(user.getUserName());


    }
    public void EditProfile(ActionEvent a) throws IOException {

        /****************************************name handling*******************************************/
        String name = NameField.getText().trim();
        boolean flage0 = false;
        String namePattern = "[!@#$%^&*()+=/]";
        if (name.isEmpty()) {
            nameLabel.setVisible(true);
            nameLabel.setText("Name is empty");
        } else if (name.matches(".*" + namePattern + ".*")) {
            nameLabel.setVisible(true);
            nameLabel.setText("you can't use this symbol in your name");
        } else if (name.length() < 8) {
            nameLabel.setVisible(true);
            nameLabel.setText("your name is too small");
        } else if (name.length() > 45) {
            nameLabel.setVisible(true);
            nameLabel.setText("your name is too long");

        } else {
            flage0 = true;
            nameLabel.setVisible(false);
        }

        /******************************************************Email handling**********************************************/

        String email = EmailField.getText().trim();
        String EmailPattern = "[!#$%^&*()+=/ ]";
        boolean flage4 = false;

        if (email.isEmpty()) {
            emailLabel.setVisible(true);
            emailLabel.setText("Email is empty");
        } else if (email.matches(".*" + EmailPattern + ".*")) {
            emailLabel.setVisible(true);
            emailLabel.setText("Email must contain only a-z A-Z 0-9 _");
        } else if (email.length() < 8) {
            emailLabel.setVisible(true);
            emailLabel.setText("Email is too small please Try another one");
        } else if (email.length() > 100) {
            emailLabel.setVisible(true);
            emailLabel.setText("your Email is too long");

        } else if (!(email.endsWith("@gmail.com"))) {
            emailLabel.setVisible(true);
            emailLabel.setText("Your Email must end with @gmail.com");

        } else if ((!UniqueUsers(email)) && !(email.equals(user.getEmail()))) {
            emailLabel.setVisible(true);
            emailLabel.setText("Email is already exist please Try another one");

        } else {
            flage4 = true;
            emailLabel.setVisible(false);
        }
        /*********************************************phone number handling************************************************/

        String phonenumber = phoneNumberField.getText().trim();
        String numberPattern = "[0-9]";
        boolean flage5 = false;
        if (phonenumber.isEmpty()) {
            phoneLabel.setVisible(true);
            phoneLabel.setText("Phone number is empty");
        } else if (!(phonenumber.matches(".*" + numberPattern + ".*"))) {
            phoneLabel.setVisible(true);
            phoneLabel.setText("Phone numbers must contain only numbers");
        } else if (phonenumber.length() != 11) {
            phoneLabel.setVisible(true);
            phoneLabel.setText("Phone number must contain 11 digits");
        } else if (!(phonenumber.startsWith("01"))) {
            phoneLabel.setVisible(true);
            phoneLabel.setText("Phone number must start with 01");
        } else if (!UniqueUsers(phonenumber) && !(phonenumber.equals(user.getPhoneNumber()))) {
            phoneLabel.setVisible(true);
            phoneLabel.setText("Phone number is already exist please Try another one");

        } else {
            flage5 = true;
            phoneLabel.setVisible(false);
        }
        /*******************************************************Age handling ******************************************/

        String ageStr = ageField.getText().trim();
        int age = 0;
        boolean flage6 = false;
        if (ageStr.isEmpty()) {
            ageLabel.setVisible(true);
            ageLabel.setText("Age is empty");
        } else if (!(ageStr.matches(".*" + numberPattern + ".*"))) {
            ageLabel.setVisible(true);
            ageLabel.setText("Age must contain only numbers");
        } else if (Integer.parseInt(ageStr) > 100 || Integer.parseInt(ageStr) == 0 || Integer.parseInt(ageStr) < 8) {
            ageLabel.setVisible(true);
            ageLabel.setText("Age is not available");
        } else {
            age = Integer.parseInt(ageStr);
            flage6 = true;
            ageLabel.setVisible(false);
        }
        /***********************************************Gender handling****************************************************/

        String gender = "";
        boolean flage7 = true;
        if (maleButton.isSelected()) {
            genderlabel.setVisible(false);
            flage7 = true;
            gender = "Male";
        } else if (femaleButton.isSelected()) {
            genderlabel.setVisible(false);
            flage7 = true;
            gender = "Female";
        }
        /***************************************bio******************************************************************/
        String bio ;
        bio = bioField.getText();
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
    public void FriendList (ActionEvent a) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Friends.fxml"));
        parent = loader.load();
        SearchFriend friend = loader.getController();
        friend.setUser(user);

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
}
