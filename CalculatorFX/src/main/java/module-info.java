module com.kirillmozharov.calculatorfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires exp4j;

    opens com.kirillmozharov.calculatorfx to javafx.fxml;
    exports com.kirillmozharov.calculatorfx;
    exports com.kirillmozharov.calculatorfx.controllers;
    opens com.kirillmozharov.calculatorfx.controllers to javafx.fxml;
}