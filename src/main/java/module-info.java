module org.example.main.socialplatform {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires de.jensd.fx.glyphs.fontawesome;



    opens org.example.main.socialplatform to javafx.fxml;
    opens org.example.main.socialplatform.Contollers to javafx.fxml;
    exports org.example.main.socialplatform;
    exports org.example.main.socialplatform.Contollers;
    exports org.example.main.socialplatform.Models;
}