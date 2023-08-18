package com.kirillmozharov.calculatorfx.controllers;

import com.kirillmozharov.calculatorfx.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainController {

    @FXML
    public TextField result;

    public void buttonDigit(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String number = button.getText();
        String currentText = this.result.getText();
        this.result.setText(currentText.concat(number));
    }

    public void buttonEquals(ActionEvent actionEvent) {
        try {
            Expression expression = new ExpressionBuilder(this.result.getText()).build();
            double result = expression.evaluate();
            this.result.setText(Double.toString(result));
        } catch (RuntimeException e) {
            App.showAlert("Ошибка!!", "Введите корректное вычисление", Alert.AlertType.ERROR);
            this.result.setText("");
        }
    }

    public void buttonClear(ActionEvent actionEvent) {
        this.result.setText("");
    }
}
