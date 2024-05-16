This project implements a social media platform application using JavaFX for the user interface and SQLite for the database.

Features:

    User registration with profile picture upload (stored as BLOB)
    User login (potentially with email and password)
    Basic user profile management (name, email)
    (Optional) Additional features like creating posts, comments, friend connections, etc.
    
Getting Started:

Working Environment and Setup in IntelliJ IDEA


Prerequisites:

    Java JDK 17 or higher (https://www.oracle.com/java/technologies/downloads/)
    Apache Maven (https://maven.apache.org/download.cgi)
    Download and install IntelliJ IDEA Community Edition (https://www.jetbrains.com/idea/)
    
Project Setup:

  1-Import Project:
  
    Clone the project repository: git clone (https://github.com/Ahmed-Al-amin/SocialMediaPlatformProject)
    Navigate to the project directory: SocialMediaPlatformProject
    Download it.
    Open IntelliJ IDEA.
    Click "File" -> "Open Project".
    Navigate to the directory containing your social media platform project.
    Select the project root folder and click "Open".
    
  2-Verify Maven Configuration:

    Go to "File" -> "Settings" (or "Preferences" on macOS).
    Search for "Maven" in the settings bar.
    Under "Maven", ensure the "Local repository" path points to your existing Maven repository directory (usually ~/.m2/repository on Linux/macOS or C:\Users\<username>\.m2\repository on Windows).
    Click "OK" to save settings.
    
 3-The application creates a SQLite database:

        file named "Database.db" upon first run.
        You can modify the database schema (tables and columns) by editing the relevant Java classes.

Running the Application:

  1-Run Maven Build:

    Open the built-in terminal window (usually at the bottom of the IDE).
    In the terminal, navigate to your project root directory using the cd command (e.g., cd social-media-platform).
    Run the command mvn clean javafx:run to clean the project and launch the application using Maven.
    
  2-Alternatively (using IntelliJ features):
    
    Right-click on the Main class (usually under src/main/java/com/your.package.name) in the Project pane.
    Select "Run 'Main.main()'".
    
Additional Tips:

      1-Project Structure:
        IntelliJ IDEA helps organize your project. Familiarize yourself with the project structure in the Project pane (e.g., src/main/java for source code, src/main/resources for resources).
      
      2-Code Completion and Navigation:
        Utilize IntelliJ IDEA's code completion features (Ctrl+Space) to suggest relevant classes, methods, and keywords.
        Use navigation shortcuts (e.g., Alt+Click) to jump between related code elements.
        
      3-Debugging:
        Set breakpoints in your code (click next to line numbers) to pause execution at specific points.
        Utilize the debugger features (step through code, inspect variables) to identify and fix errors.
        
      4-Refactoring:
        IntelliJ IDEA offers code refactoring tools (right-click on code elements) to improve code organization and readability.


This is a basic framework for a social media platform.
You can extend the functionality by adding features like posts, comments, friend connections, etc.
Refer to the Java source code for details on existing functionalities and potential modification points.


