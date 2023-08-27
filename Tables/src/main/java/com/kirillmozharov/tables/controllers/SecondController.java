package com.kirillmozharov.tables.controllers;

import com.kirillmozharov.model.MailSender;
import com.kirillmozharov.model.User;
import com.kirillmozharov.repository.SendUserIdRepository;
import com.kirillmozharov.tables.App;
import com.kirillmozharov.util.Constants;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SecondController implements ControllerData<User> {
    private User user;
    public TextField theme;
    public TextArea content;

    public void buttonClose(ActionEvent actionEvent) {
        MailSender mailSender = new MailSender("mozharov_2002@mail.ru", Constants.MAIL_PASSWORD, this.user.getEmail());
        if (this.theme.getText().equals("")) {
            App.showAlert("Ошибка", "Введите тему письма", Alert.AlertType.ERROR);
            return;
        }
        if (this.content.getText().equals("")) {
            App.showAlert("Ошибка", "Введите письмо", Alert.AlertType.ERROR);
            return;
        }
        mailSender.send(this.theme.getText(), this.content.getText());
        this.user.setSend(true);
        App.showAlert("Успех", "Письмо успешно отправлено", Alert.AlertType.INFORMATION);
        App.closeWindow(actionEvent);
    }

    @Override
    public void initData(User value) {
        this.user = value;
    }
}
