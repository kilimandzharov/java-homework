module com.kirillmozharov.tables {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires javax.mail.api;


    opens com.kirillmozharov.tables to javafx.fxml;
    opens com.kirillmozharov.tables.controllers to javafx.fxml;
    opens com.kirillmozharov.model to com.fasterxml.jackson.databind, javafx.base;
    exports com.kirillmozharov.tables;
}