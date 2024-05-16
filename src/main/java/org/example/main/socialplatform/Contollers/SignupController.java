package org.example.main.socialplatform.Contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.main.socialplatform.ConsleApp.User;
import org.example.main.socialplatform.Main;
import org.example.main.socialplatform.Models.DataTransfer;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ResourceBundle;


public class SignupController implements Initializable {

    @FXML
    public Button uploadButton;
    public ImageView ProfilePicture;
    /**************************************************Login Controller**********************************************/
    private Parent  parent ;
    private Stage stage;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //uploadButton.setOnAction(e -> uploadProfilePicture());
    }


    public void LoginScene(ActionEvent a) throws IOException {

        parent = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
        stage = (Stage) ((Node)a.getSource()).getScene().getWindow();

        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    /****************************************************Signup*****************************************************/

    @FXML
    TextField NameField;
    @FXML
    TextField Usernamefield;
    @FXML
    TextField PasswordField;
    @FXML
    TextField ConfirmPasswordField;
    @FXML
    TextField EmailField;
    @FXML
    TextField phoneNumberField;
    @FXML
    TextField ageField;
    @FXML
    Label nameLabel;
    @FXML
    Label usernameLabel;
    @FXML
    Label passwordLabel;
    @FXML
    Label confirmPasswordLabel;
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



    public void Signup(ActionEvent a) throws IOException {

        /****************************************name handling*******************************************/
        String name = NameField.getText().trim();
        boolean flage0 = false;
        String namePattern = "[!@#$%^&*()+=/]";
        if (name.isEmpty())
        {
            nameLabel.setVisible(true);
            nameLabel.setText("Name is empty");
        }
        else if (name.matches(".*" + namePattern + ".*"))
        {
            nameLabel.setVisible(true);
            nameLabel.setText("you can't use this symbol in your name");
        }
        else if (name.length() < 8)
        {
            nameLabel.setVisible(true);
            nameLabel.setText("your name is too small");
        }
        else if (name.length() > 45)
        {
            nameLabel.setVisible(true);
            nameLabel.setText("your name is too long");

        }
        else
        {
            flage0 = true;
            nameLabel.setVisible(false);
        }

        /*********************************************username handling***********************************/

        String username = Usernamefield.getText().trim();
        String usernmaePattern = "[!@#$%^&*()+=/ ]";
        boolean flage1 = false;
        if (username.isEmpty()){
            usernameLabel.setVisible(true);
            usernameLabel.setText("Username is empty");
        }
        else if (username.matches(".*" + usernmaePattern + ".*"))
        {
            usernameLabel.setVisible(true);
            usernameLabel.setText("username must contain only a-z A-Z 0-9 _");
        }
        else if (username.length() < 8)
        {
            usernameLabel.setVisible(true);
            usernameLabel.setText("Username is too small please Try another one");
        }
        else if (username.length() > 75)
        {
            usernameLabel.setVisible(true);
            usernameLabel.setText("your password is too long");

        }
        else if (!UniqueUsers(username)){
            usernameLabel.setVisible(true);
            usernameLabel.setText("Username is already exist please Try another one");

        }
        else {
            flage1 = true;
            usernameLabel.setVisible(false);
        }

        /*************************************************password handling**************************************/

        String password = PasswordField.getText().trim();
        boolean flage2 = false;
        if (password.isEmpty()){
            passwordLabel.setVisible(true);
            passwordLabel.setText("password is empty");
        }
        else if (password.matches(".*" + " " + ".*"))
        {
            passwordLabel.setVisible(true);
            passwordLabel.setText("password can't contain spaces");
        }
        else if (password.length() < 8)
        {
            passwordLabel.setVisible(true);
            passwordLabel.setText("password is too small please Try another one");
        }
        else if (password.length() > 75)
        {
            passwordLabel.setVisible(true);
            passwordLabel.setText("your password is too long");

        }
        else {
            flage2 = true;
            passwordLabel.setVisible(false);
        }

        String confirmPassword = ConfirmPasswordField.getText();
        boolean flage3 = false;
        if (confirmPassword.isEmpty())
        {
            confirmPasswordLabel.setVisible(true);
            confirmPasswordLabel.setText("Confirm password is empty");
        }
        else if (!(password.equals(confirmPassword))  && flage2)
        {
            confirmPasswordLabel.setVisible(true);
            confirmPasswordLabel.setText("Confirm password must match password");
        }
        else {
            confirmPasswordLabel.setVisible(false);
            flage3 = true;
        }
        /******************************************************Email handling**********************************************/

        String email = EmailField.getText().trim();
        String EmailPattern = "[!#$%^&*()+=/ ]";
        boolean flage4 = false;

        if (email.isEmpty()){
            emailLabel.setVisible(true);
            emailLabel.setText("Email is empty");
        }
        else if (email.matches(".*" + EmailPattern + ".*"))
        {
            emailLabel.setVisible(true);
            emailLabel.setText("Email must contain only a-z A-Z 0-9 _");
        }
        else if (email.length() < 8)
        {
            emailLabel.setVisible(true);
            emailLabel.setText("Email is too small please Try another one");
        }
        else if (email.length() > 100)
        {
            emailLabel.setVisible(true);
            emailLabel.setText("your Email is too long");

        }
        else if (!(email.endsWith("@gmail.com"))){
            emailLabel.setVisible(true);
            emailLabel.setText("Your Email must end with @gmail.com");

        }
        else if (!UniqueUsers(email)){
            emailLabel.setVisible(true);
            emailLabel.setText("Email is already exist please Try another one");

        }
        else {
            flage4 = true;
            emailLabel.setVisible(false);
        }
        /*********************************************phone number handling************************************************/

        String phonenumber = phoneNumberField.getText().trim();
        String numberPattern = "[0-9]";
        boolean flage5 = false;
        if (phonenumber.isEmpty()){
            phoneLabel.setVisible(true);
            phoneLabel.setText("Phone number is empty");
        }
        else if (!(phonenumber.matches(".*" + numberPattern + ".*")))
        {
            phoneLabel.setVisible(true);
            phoneLabel.setText("Phone numbers must contain only numbers");
        }
        else if (phonenumber.length() != 11)
        {
            phoneLabel.setVisible(true);
            phoneLabel.setText("Phone number must contain 11 digits");
        }
        else if (!(phonenumber.startsWith("01")) )
        {
            phoneLabel.setVisible(true);
            phoneLabel.setText("Phone number must start with 01");
        }
        else if (!UniqueUsers(phonenumber)){
            phoneLabel.setVisible(true);
            phoneLabel.setText("Phone number is already exist please Try another one");

        }
        else {
            flage5 = true;
            phoneLabel.setVisible(false);
        }
        /*******************************************************Age handling *********************************************/
        String ageStr = ageField.getText().trim();
        int age = 0;
        boolean flage6 = false;
        if (ageStr.isEmpty()){
            ageLabel.setVisible(true);
            ageLabel.setText("Age is empty");
        }
        else if (!(ageStr.matches(".*" + numberPattern + ".*")))
        {
            ageLabel.setVisible(true);
            ageLabel.setText("Age must contain only numbers");
        }
        else if (Integer.parseInt(ageStr) > 100 || Integer.parseInt(ageStr) == 0|| Integer.parseInt(ageStr) < 8)
        {
            ageLabel.setVisible(true);
            ageLabel.setText("Age is not available");
        }
        else {
            age = Integer.parseInt(ageStr);
            flage6 = true;
            ageLabel.setVisible(false);
        }
        /***********************************************Gender handling****************************************************/

        String gender = "";
        boolean flage7 = false;
        if (maleButton.isSelected())
        {
            genderlabel.setVisible(false);
            flage7 = true;
            gender = "Male";
        }
        else if (femaleButton.isSelected())
        {
            genderlabel.setVisible(false);
            flage7 = true;
            gender = "Female";
        }
        if (!flage7)
        {
            genderlabel.setVisible(true);
            genderlabel.setText("choose the gender");
        }


        if (flage0 && flage1 && flage2 && flage3 && flage4 && flage5 && flage6 && flage7)
        {
            /**************************************************send the data*******************************************/

            User user = new User(name, username, password, age, gender, phonenumber, email);
            Main.Users.add(user);
            int Id = user.getUserID();
            DataTransfer.WriteUserData(name,username,password,email,phonenumber,gender,age,Id);

            /*************************************************Switch the scene*****************************************/
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/StartSignup.fxml"));
            parent = loader.load();

            StartSignupController Start = loader.getController();
            Start.setUser(user);
            //parent = FXMLLoader.load(getClass().getResource("/FXML/StartSignup.fxml"));
            stage = (Stage) ((Node)a.getSource()).getScene().getWindow();
            scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        }

    }
    /*********************************************************************************************************************/
    @FXML
    Button LoginBackButton;

    public void Editing1() throws IOException {
        LoginBackButton.setTextFill(Color.rgb(100,100,255));
        LoginBackButton.setUnderline(true);


    }
    public void Editing2() throws IOException {
        LoginBackButton.setTextFill(Color.BLACK);
        LoginBackButton.setUnderline(false);

    }
    public SignupController() throws IOException {
    }


    public static boolean UniqueUsers (String Username){
        if (Username.contains("@")){
        for (User user: Main.Users){
            if(user.getEmail().equals(Username)){
                return false;
            }
        }}
        else if (Username.startsWith("01")){
            for (User user: Main.Users){
                if(user.getPhoneNumber().equals(Username)){
                    return false;
                }
            }}
        else {
            for (User user: Main.Users){
                if(user.getUserName().equals(Username)){
                    return false;
                }
            }}

        return true;
    }

    @FXML
    public void uploadAndSavePhoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image");
        fileChooser.setInitialDirectory(new File("C:"));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPEG Image", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG Image", "*.png"),
                new FileChooser.ExtensionFilter("All Image files", "*.jpg", "*.png")
        );

        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            // Display the selected image on the ImageView
            Image image = new Image(selectedFile.toURI().toString());
            ProfilePicture.setImage(image);

            if (true) {
                converting(selectedFile);
                saveImage(selectedFile);

            }
        } else {
            System.out.println("No image file selected.");
        }
    }

    private void saveImage(File imageFile) {

        try {
            File destinationFile = new File("C:\\Users\\Ahmed Al-Amin\\OneDrive\\Desktop\\OOP Project\\Social media platform\\src\\main\\resources\\Photos", imageFile.getName());
            Files.copy(imageFile.toPath(), destinationFile.toPath());
            System.out.println("Image saved successfully to: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving image: " + e.getMessage());
        }
    }
    public void converting (File imageFile)
    {
    byte[] imageBytes;
  try {
        FileInputStream inputStream = new FileInputStream(imageFile);
        long imageLength = imageFile.length();
        imageBytes = new byte[(int) imageLength];
        int bytesRead = inputStream.read(imageBytes);

        if (bytesRead != imageLength) {
            throw new IOException("Couldn't fully read image file");
        }

        inputStream.close();
    } catch (IOException e) {
        System.out.println("Error reading image file: " + e.getMessage());
    }
}
}

