package org.example.main.socialplatform.Contollers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.main.socialplatform.ConsleApp.Comment;
import org.example.main.socialplatform.ConsleApp.Post;
import org.example.main.socialplatform.ConsleApp.User;
import org.example.main.socialplatform.Models.DataTransfer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.main.socialplatform.Main.*;

public class DashboardController {
    public Label postNameLabe;
    public Label PostDateLabe;
    public Label SuggestedLabel;
    public Label postContentLabel;
    public ImageView perviosPostLabel;
    public ImageView nextPostLabel;
    public Label CommentsLabel;
    public Label LikesLabel;
    public Button commentButton;
    public Label AllCommentsLabel;
    public TextField CommentField;
    public Button WriteCommentButton;
    User user;
    private Stage stage;
    private Scene scene;
    private Parent parent;


    @FXML
    private Button FriendsButton;



    public void setUser(User user)
    {
        this.user = user;
        this.viewFirstpost();


    }
    static int i = 0;

    public void handelComments()
    {
        postcomments = user.getAllPosts().get(i).getAllComments();
        String STR = "";
        for (Comment commentSearch : postcomments) {
            STR += commentSearch.getContent();
            STR += "\n";
            STR += commentSearch.getTimestamp();
            STR += "\n--------------------------------------------------\n";
        }
        AllCommentsLabel.setText(STR);
    }
    /******************************************View posts**********************************************************/
    public void viewFirstpost()
    {

        try{
        postNameLabe.setText(Posts.getFirst().getAuthor());
        postContentLabel.setText(Posts.getFirst().getContent());
        PostDateLabe.setText(Posts.getFirst().getTimestamp());
        SuggestedLabel.setText("Suggested");
        LikesLabel.setText(String.valueOf(Posts.getFirst().getReacts()));
        CommentsLabel.setText(String.valueOf(Posts.getFirst().getNumberOfComments()));
            this.handelComments();}
        catch (Exception a)
        {
            postContentLabel.setText("there is no posts");
        }

    }
    public void viewLastposts(MouseEvent a)
    {
        try {
            postNameLabe.setText(Posts.get(i).getAuthor());
            postContentLabel.setText(Posts.get(i).getContent());
            PostDateLabe.setText(Posts.get(i).getTimestamp());
            SuggestedLabel.setText("Suggested");
            LikesLabel.setText(String.valueOf(Posts.get(i).getReacts()));
            CommentsLabel.setText(String.valueOf(Posts.get(i).getNumberOfComments()));
            this.handelComments();
            i--;
        }
        catch (Exception c)
        {
            i = 0;
        }


    }
    public void viewNextposts(MouseEvent a) throws IOException {
        try{

            postNameLabe.setText(Posts.get(i).getAuthor());
            postContentLabel.setText(Posts.get(i).getContent());
            PostDateLabe.setText(Posts.get(i).getTimestamp());
            SuggestedLabel.setText("Suggested");
            LikesLabel.setText(String.valueOf(Posts.get(i).getReacts()));
            CommentsLabel.setText(String.valueOf(Posts.get(i).getNumberOfComments()));
            this.handelComments();
            i++;
        }
        catch (IndexOutOfBoundsException b){
            i=0;
    }
    }
    /*******************************************Add comments******************************************************/
    public void addComment (ActionEvent a)
    {
        String Comment = CommentField.getText();
        LocalDateTime now = LocalDateTime.now();


        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = timeFormatter.format(now);


        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dateFormatter.format(now);

        String commentTime = formattedTime + "  " + formattedDate;
        //System.out.println(formattedTime + " " + formattedDate);
        Comment coment = new Comment(Comment);
        coment.setTimestamp(commentTime);
        coment.setAuthor(user.getName());
        Posts.get(i).addComment(coment);
        DataTransfer.WriteCommentData(user.getName(),Comment,commentTime,Posts.get(i).getPostId());
    }
    /*******************************************Switch Scenes*****************************************************/
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
    public void FriendList (ActionEvent a) throws IOException {
        parent = FXMLLoader.load(getClass().getResource("/FXML/Friends.fxml"));
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
