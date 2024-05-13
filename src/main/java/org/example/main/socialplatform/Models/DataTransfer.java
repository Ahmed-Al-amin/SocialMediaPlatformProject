package org.example.main.socialplatform.Models;

import org.example.main.socialplatform.ConsleApp.Comment;
import org.example.main.socialplatform.ConsleApp.Post;
import org.example.main.socialplatform.ConsleApp.User;
import org.example.main.socialplatform.Main;

import java.sql.*;

public class DataTransfer {
    //Connection connection = db.getConnection();
    ConnectDB db = new ConnectDB();

    /******************************************Creating Table*****************************************/
    public static void CreateUsersTable() {
        String url = "jdbc:sqlite:Database.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Create a new table with the specified columns
            String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
                    + "    name TEXT,\n"
                    + "    username TEXT,\n"
                    + "    password TEXT,\n"
                    + "    phoneNumber TEXT,\n"
                    + "    email TEXT,\n"
                    + "    age INTEGER,\n"
                    + "    gender TEXT,\n"
                    + "    bio TEXT,\n"
                    + "    userId INTEGER PRIMARY KEY\n"
                    + ");";

            // Execute the SQL query to create the table
            stmt.execute(sql);

            System.out.println("Table created successfully.");

        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    public static void CreateCommentTable() {
        String url = "jdbc:sqlite:Database.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Create a new table with the specified columns
            String sql = "CREATE TABLE IF NOT EXISTS Comments (\n"
                    + "    name TEXT,\n"
                    + "    content TEXT,\n"
                    + "    time TEXT,\n"
                    + "    PostId INTEGER PRIMARY KEY\n"
                    + ");";

            // Execute the SQL query to create the table
            stmt.execute(sql);

            System.out.println("comment Table created successfully.");

        } catch (SQLException e) {
            System.err.println("Error creating comment table: " + e.getMessage());
        }
    }
    public static void CreateFriendTable() {
        String url = "jdbc:sqlite:Database.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Create a new table with the specified columns
            String sql = "CREATE TABLE IF NOT EXISTS Friends (\n"
                    + "    username1 TEXT,\n"
                    + "    username2 TEXT,\n"
                    + "    Status TEXT,\n"
                    + ");";

            // Execute the SQL query to create the table
            stmt.execute(sql);

            System.out.println("comment Table created successfully.");

        } catch (SQLException e) {
            System.err.println("Error creating comment table: " + e.getMessage());
        }
    }
    public static void CreatePostTable() {
            String url = "jdbc:sqlite:Database.db";

            try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {

                // Create a new table with the specified columns
                String sql = "CREATE TABLE IF NOT EXISTS Posts (\n"
                        + "    username TEXT,\n"
                        + "    content TEXT,\n"
                        + "    time TEXT,\n"
                        + "    numberOfLikes INTEGER,\n"
                        + "    numberOfComments INTEGER,\n"
                        + "    PostId INTEGER PRIMARY KEY\n"
                        + ");";

                // Execute the SQL query to create the table
                stmt.execute(sql);

                System.out.println("Post Table created successfully.");

            } catch (SQLException e) {
                System.err.println("Error creating table: " + e.getMessage());
            }
        }

    /************************************************Write Data******************************************/
    public static void WriteUserData(String name, String username, String password, String Email, String phonenumber, String Gender, int age, int userId) {
        DataTransfer.CreateUsersTable();
        String url = "jdbc:sqlite:Database.db";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement("INSERT OR REPLACE INTO Users (name, username, password, phoneNumber, email, age, gender, userId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            pstmt.setString(1, name);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setString(4, phonenumber);
            pstmt.setString(5, Email);
            pstmt.setInt(6, age);
            pstmt.setString(7, Gender);
            pstmt.setInt(8, userId);

            // Execute the prepared statement to insert data or replace if userId exists
            pstmt.executeUpdate();
            System.out.println("User Data written successfully");

        } catch (SQLException e) {
            System.out.println("Error writing user data: " + e.getMessage());
        }
    }
    public static void WritePostData(String username,String content,String time,int noOflikes,int noOfComments,int postId) {
        DataTransfer.CreatePostTable();
        String url = "jdbc:sqlite:Database.db";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement("INSERT OR REPLACE INTO Posts (username, content, time, numberOfLikes, numberOfComments, PostId) VALUES (?, ?, ?, ?, ?, ?)")) {

            pstmt.setString(1, username);
            pstmt.setString(2, content);
            pstmt.setString(3, time);
            pstmt.setInt(4,noOflikes );
            pstmt.setInt(5, noOfComments);
            pstmt.setInt(6, postId);

            // Execute the prepared statement to insert data or replace if userId exists
            pstmt.executeUpdate();
            System.out.println("Post Data written successfully");

        } catch (SQLException e) {
            System.out.println("Error writing post data: " + e.getMessage());
        }
    }
    public static void WriteCommentData(String name,String content,String time,int postId) {
        //DataTransfer.CreateCommentTable();
        String url = "jdbc:sqlite:Database.db";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement("INSERT OR REPLACE INTO Comments  (name, content, time, PostId) VALUES (?, ?, ?, ?)")) {

            pstmt.setString(1, name);
            pstmt.setString(2, content);
            pstmt.setString(3, time);
            pstmt.setInt(4, postId);

            // Execute the prepared statement to insert data or replace if userId exists
            pstmt.executeUpdate();
            System.out.println("Comment Data written successfully");

        } catch (SQLException e) {
            System.out.println("Error writing Comment data: " + e.getMessage());
        }
    }
    /*****************************************Get data from the database*********************************/
    public static void getAllUsers()
    {
        String url = "jdbc:sqlite:Database.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Users")) {

            while (rs.next()) {
                String name = rs.getString("name");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String phonenumber = rs.getString("phoneNumber");
                int age = rs.getInt("age");
                int userId = rs.getInt("userId");

                User user = new User(name,username,password,age,gender,phonenumber,email);
                Main.Users.add(user);
                System.out.println("Success in read all users");
            }
        }  catch (SQLException e) {
            System.out.println("Error reading users from the database: " + e.getMessage());
        }

    }
    public static void getAllPosts()
    {
        String url = "jdbc:sqlite:Database.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Posts")) {

            while (rs.next()) {
                String content = rs.getString("content");
                String username = rs.getString("username");
                String time = rs.getString("time");
                int numberoflikes = rs.getInt("numberOfLikes");
                int postId = rs.getInt("PostId");
                int numberofcomments = rs.getInt("numberOfComments");

                Post post = new Post(content, username,time,numberofcomments,numberoflikes,postId);
                Main.Posts.add(post);
                System.out.println("Success in read all posts");
            }
        }  catch (SQLException e) {
            System.out.println("Error reading users from the database: " + e.getMessage());
        }

    }
    public  static void getAllComments()
    {
        String url = "jdbc:sqlite:Database.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Comments")) {

            while (rs.next()) {
                String content = rs.getString("content");
                String username = rs.getString("username");
                String time = rs.getString("time");
                int postId = rs.getInt("PostId");

                Comment comment = new Comment(content,username,time,postId);
                Main.comments.add(comment);
                System.out.println("Success in read all comments");
            }
        }  catch (SQLException e) {
            System.out.println("Error reading comments from the database: " + e.getMessage());
        }

    }
    /************************************************Organizing data************************************/
    public static void Organizing()
    {
        for (Comment coment : Main.comments){
            for (Post post : Main.Posts)
            {
                if (coment.getPostId() == post.getId())
                {
                    post.addComment(coment);
                }
            }
        }
        for (Post post : Main.Posts){
            for (User usersearch : Main.Users)
            {
                if (usersearch.getUserName().equals(post.getAuthor()))
                {
                    usersearch.addPost(post);
                }
            }
        }

    }
    /****************************************************Update the database******************************/
    public static void Updateusers()
    {
        String url = "jdbc:sqlite:Database.db";
        int userId = 1;

        try (Connection conn = DriverManager.getConnection(url)) {
            String updateSql = "UPDATE Users SET bio = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateSql);

            //pstmt.setString(1, newBio);
            pstmt.setInt(2, userId);

            pstmt.executeUpdate();
            System.out.println("User bio updated successfully!");
        } catch (SQLException e) {
            System.err.println("Error updating user bio: " + e.getMessage());

        }
    }
}



