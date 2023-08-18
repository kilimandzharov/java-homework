package com.kirillmozharov.demo.controllers;

import com.kirillmozharov.demo.App;
import com.kirillmozharov.demo.model.User;
import com.kirillmozharov.demo.repository.Repository;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {
    private Repository repository;
    public AnchorPane comboBoxUser;
    public ComboBox<User> comboBox;
    public ListView<User> listViewUsers;

    public void initialize() throws IOException {
        Repository repository = new Repository("https://jsonplaceholder.typicode.com/users");
        this.repository = repository;
        this.comboBox.setItems(FXCollections.observableList(repository.getUsers()));
    }

    public void buttonSave(ActionEvent actionEvent) {
        User user = comboBox.getSelectionModel().getSelectedItem();
        if(user == null){
            App.showAlert("Ошибка", "Выберите Пользователя", Alert.AlertType.INFORMATION);
            return;
        }
        this.repository.add(user);
        this.listViewUsers.getItems().add(user);
    }

    public void onButtonDelete(ActionEvent actionEvent) {
        User selectedUser = this.listViewUsers.getSelectionModel().getSelectedItem();
        if(selectedUser == null){
            App.showAlert("Ошибка", "Выберите Пользователя", Alert.AlertType.INFORMATION);
            return;
        }
        this.repository.remove(selectedUser);
        this.listViewUsers.getItems().remove(selectedUser);
    }

    public void onButtonShow(ActionEvent actionEvent) {
        User selectedUser = this.listViewUsers.getSelectionModel().getSelectedItem();
        if(selectedUser == null){
            App.showAlert("Ошибка", "Выберите Пользователя", Alert.AlertType.INFORMATION);
            return;
        }
        App.showAlert("Информация о пользователе",selectedUser.toString(),Alert.AlertType.INFORMATION);
    }


}
