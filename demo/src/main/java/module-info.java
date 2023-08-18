module com.kirillmozharov.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.kirillmozharov.demo to javafx.fxml;
    exports com.kirillmozharov.demo;
    exports com.kirillmozharov.demo.controllers;
    exports com.kirillmozharov.demo.model to com.fasterxml.jackson.databind;
    opens com.kirillmozharov.demo.controllers to javafx.fxml;
}