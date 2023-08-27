package com.kirillmozharov.tables.controllers;

import com.kirillmozharov.model.User;
import com.kirillmozharov.repository.InitializeUsersRepository;
import com.kirillmozharov.tables.App;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.util.Callback;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class MainController implements ControllerData<User> {

    @FXML
    public TableView<User> tableView;

    private InitializeUsersRepository initializeUsersRepository;

    public InitializeUsersRepository getInitializeUsersRepository() {
        return initializeUsersRepository;
    }

    @FXML
    void initialize() {
        TableColumn<User, String> firstNameCol = new TableColumn<>("Имя");
        TableColumn<User, String> emailCol = new TableColumn<>("Почта");
        TableColumn<User, Integer> ageCol = new TableColumn<>("Возраст");
        TableColumn<User, String> countryCol = new TableColumn<>("Страна");
        TableColumn<User, Boolean> isSendCol = new TableColumn<>("Отправлено");
        TableColumn<User, LocalDateTime> dateCol = new TableColumn<>("Дата регистрации");
        TableColumn<User, String> actionCol = new TableColumn<>("Отправить");

        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateOfRegistration"));

        Callback<TableColumn<User, Boolean>, TableCell<User, Boolean>> cellFactory =
                new Callback<>() {
                    @Override
                    public TableCell call(final TableColumn<User, Boolean> param) {
                        final TableCell<User, Boolean> cell = new TableCell<>() {
                            CheckBox btn = new CheckBox("ds");

                            {
                                btn.setDisable(true);
                                btn.setStyle("-fx-opacity: 1;");
                            }

                            @Override
                            public void updateItem(Boolean item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setSelected(tableView.getItems().get(getIndex()).isSend());
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        Callback<TableColumn<User, String>, TableCell<User, String>> buttonCellFactory =
                new Callback<>() {
                    @Override
                    public TableCell call(final TableColumn<User, String> param) {
                        final TableCell<User, String> cell = new TableCell<>() {
                            final Button btn = new Button("Отправить");

                            {
                                btn.getStyleClass().add("primary");
                            }

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {
                                        User person = getTableView().getItems().get(getIndex());
                                        try {
                                            App.openWindow("second.fxml", "Написать письмо", person);
                                        } catch (IOException exception) {
                                            App.showAlert("Ошибка", "Этому пользователю нельзя написать письмо", Alert.AlertType.ERROR);
                                        }
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        isSendCol.setCellFactory(cellFactory);
        isSendCol.setEditable(false);

        actionCol.setCellFactory(buttonCellFactory);

        this.tableView.getColumns().setAll(firstNameCol, emailCol, ageCol, countryCol, isSendCol, actionCol);
    }

    @FXML
    public void menuButtonOpen(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter2);
        File file = fileChooser.showOpenDialog(null);
        try {
            if (file != null) {
                this.initializeUsersRepository =  new InitializeUsersRepository(file);
                tableView.setItems(FXCollections.observableArrayList(initializeUsersRepository.getUsers()));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            App.showAlert("Ошибка", "Файл не может быть открыт в приложении", Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initData(User value) {
        this.initializeUsersRepository.getSendUserIdRepository().getSendList().add(value.getId());
        this.initializeUsersRepository.getSendUserIdRepository().save();
    }
}
