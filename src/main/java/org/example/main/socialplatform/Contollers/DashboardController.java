package org.example.main.socialplatform.Contollers;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.main.socialplatform.ConsleApp.Comment;
import org.example.main.socialplatform.ConsleApp.Likes;
import org.example.main.socialplatform.ConsleApp.Post;
import org.example.main.socialplatform.ConsleApp.User;
import org.example.main.socialplatform.Main;
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
    public Button LastPostButton;
    public Button NextPostButton;
    public VBox Nextpost;
    public VBox Lastpost;
    public Label CommentsnumberLabel;
    public Button LikeButton;
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
        try{
        LikesLabel.setText(String.valueOf(Posts.getFirst().getReacts()));}
        catch (Exception a)
        {
            System.out.println(a.getMessage());
        }

    }
    public void HandelLikeButton()
    {
        LikesLabel.setText(String.valueOf(Posts.get(i).getReacts()));
        Likesusers = DataTransfer.GetUsernamesByPostId(i);
        boolean flage = true;
        for (String us : Likesusers)
        {
            if (us.equals(user.getUserName()))
            {
                LikeButton.setStyle("-fx-background-color: blue;");
                flage = false;
                break;
            }

        }
        if (flage){
            LikeButton.setStyle("-fx-background-color: rgb(200,200,200);");
        }
    }
    public void HandelAddLike()
    {
        LikeButton.setStyle("-fx-background-color: blue;");
        LikesLabel.setText(String.valueOf(Posts.get(i).getReacts()));

    }
    public void HandelDeleteLike()
    {
        LikeButton.setStyle("-fx-background-color: rgb(200,200,200);");
        LikesLabel.setText(String.valueOf(Posts.get(i).getReacts()));

    }
    public void addlike(ActionEvent a)
    {
        if (Posts.get(i).getReacts() == 0) {
            Posts.get(i).addReact();
            Likes mn = new Likes(i);
            mn.Adduser(user.getUserName());
            likes.add(mn);
            DataTransfer.WriteLikesData(user.getUserName(), i);
            this.HandelAddLike();
        }
        else {
            Likesusers = DataTransfer.GetUsernamesByPostId(i);
            boolean flage = true;
            for (String us : Likesusers)
            {
                if (us.equals(user.getUserName()))
                {
                    Posts.get(i).DeleteReact();
                    DataTransfer.DeleteLike(user.getUserName(),i);
                    this.HandelDeleteLike();
                    flage = false;
                    break;
                }
            }
            if (flage){
                Posts.get(i).addReact();
                DataTransfer.WriteLikesData(user.getUserName(),i);
                this.HandelAddLike();
            }
        }
    }
    static int i = 0 ;

    public void handelComments()
    {

        AllCommentsLabel.setText("");
        postcomments = Posts.get(i).getAllComments();
        CommentsnumberLabel.setText(String.valueOf(postcomments.size()));
        String STR = "";
        for (Comment commentSearch : postcomments) {
            STR += commentSearch.getAuthor() + "\n";
            STR += commentSearch.getTimestamp() + "\n";
            STR += commentSearch.getContent();
            STR += "\n--------------------------------------------------\n";
        }
        AllCommentsLabel.setText(STR);
    }
    /******************************************View posts**********************************************************/
    public void viewFirstpost()
    {

        if (Posts.size() > 0){
            i = 0;
        postNameLabe.setText(Posts.getFirst().getAuthorname());
        postContentLabel.setText(Posts.getFirst().getContent());
        PostDateLabe.setText(Posts.getFirst().getTimestamp());
            if (Posts.get(i).getAuthor().equals(user.getUserName()))
            {
                SuggestedLabel.setText("Your post");
            }

            else{
                boolean flage = false;
                for (User userSearch : user.getFriends())
                    if (userSearch.getUserName().equals(Posts.get(i).getAuthor()))
                    {
                        flage = true;}
                if (flage)
                    SuggestedLabel.setText("your friend post");
                else
                    SuggestedLabel.setText("Suggested");
            }
        LikesLabel.setText(String.valueOf(Posts.getFirst().getReacts()));
        CommentsnumberLabel.setText(String.valueOf(Posts.getFirst().getNumberOfComments()));
            this.handelComments();
            this.HandelLikeButton();
            }
       else
        {
            postContentLabel.setText("there is no posts");
        }

    }
    public void viewLastpost()
    {
        if (Posts.size() > 0){
            i = Posts.size() - 1;
            postNameLabe.setText(Posts.get(i).getAuthorname());
            postContentLabel.setText(Posts.get(i).getContent());

            PostDateLabe.setText(Posts.get(i).getTimestamp());
            if (Posts.get(i).getAuthor().equals(user.getUserName()))
            {
                SuggestedLabel.setText("Your post");
            }

            else{
                boolean flage = false;
                for (User userSearch : user.getFriends())
                    if (userSearch.getUserName().equals(Posts.get(i).getAuthor()))
                    {
                        flage = true;}
                if (flage)
                    SuggestedLabel.setText("your friend post");
                else
                    SuggestedLabel.setText("Suggested");
            }
            LikesLabel.setText(String.valueOf(Posts.get(i).getReacts()));
            CommentsnumberLabel.setText(String.valueOf(Posts.get(i).getNumberOfComments()));
            this.HandelLikeButton();
            this.handelComments();
    }
    }
    public void viewLastposts(Event a)
    {
        if (i > 0){
            i--;
            postNameLabe.setText(Posts.get(i).getAuthorname());
            postContentLabel.setText(Posts.get(i).getContent());
            PostDateLabe.setText(Posts.get(i).getTimestamp());
            if (Posts.get(i).getAuthor().equals(user.getUserName()))
            {
                SuggestedLabel.setText("Your post");
            }

            else{
                boolean flage = false;
                for (User userSearch : user.getFriends())
                    if (userSearch.getUserName().equals(Posts.get(i).getAuthor()))
                    {
                        flage = true;}
                if (flage)
                    SuggestedLabel.setText("your friend post");
                else
                    SuggestedLabel.setText("Suggested");
            }
            LikesLabel.setText(String.valueOf(Posts.get(i).getReacts()));
            CommentsnumberLabel.setText(String.valueOf(Posts.get(i).getNumberOfComments()));
            this.HandelLikeButton();
            //System.out.println(i);
            this.handelComments();
        }
        else {
            this.viewLastpost();
        }



    }
    public void viewNextposts(Event a) throws IOException {
        if (i < Posts.size()-1){
            i++;
            postNameLabe.setText(Posts.get(i).getAuthorname());
            postContentLabel.setText(Posts.get(i).getContent());
            PostDateLabe.setText(Posts.get(i).getTimestamp());
            if (Posts.get(i).getAuthor().equals(user.getUserName()))
            {
                SuggestedLabel.setText("Your post");
            }

            else{
                boolean flage = false;
                for (User userSearch : user.getFriends())
                    if (userSearch.getUserName().equals(Posts.get(i).getAuthor()))
                    {
                        flage = true;}
                if (flage)
                    SuggestedLabel.setText("your friend post");
                else
                    SuggestedLabel.setText("Suggested");
            }
            LikesLabel.setText(String.valueOf(Posts.get(i).getReacts()));
            CommentsnumberLabel.setText(String.valueOf(Posts.get(i).getNumberOfComments()));
            this.HandelLikeButton();
            //System.out.println(i);
            this.handelComments();
        }
        else {
            this.viewFirstpost();
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
        DataTransfer.WriteCommentData(user.getName(),Comment,commentTime,i);
        this.handelComments();
    }
//    public void addLike (ActionEvent a)
//    {
//
//        for (Likes likes : Main.likes)
//        {
//            if (user.getUserName().equals(likes.getusers()))
//            {
//
//            }
//        }
//    }
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


}
