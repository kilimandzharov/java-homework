package com.kirillmozharov.calculatorfx.controllers;

import com.kirillmozharov.calculatorfx.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainController {
    @FXML
    public TextField number_1;

    @FXML
    public TextField number_2;

    @FXML
    public Label operator;

    @FXML
    public TextField result;

    @FXML
    public void buttonPlus(ActionEvent actionEvent) {
        resetResult();

        operator.setText("+");

        try {
            int num1 = Integer.parseInt(this.number_1.getText());
            int num2 = Integer.parseInt(this.number_2.getText());

            int res = num1 + num2;

            System.out.println(res);

            result.setText(String.valueOf(res));

            System.out.println(result.getText());
        } catch (NumberFormatException e) {
            App.showAlert("Error!", "Incorrect format number", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void buttonMinus(ActionEvent actionEvent) {
        resetResult();

        operator.setText("-");

        try {
            int num1 = Integer.parseInt(this.number_1.getText());
            int num2 = Integer.parseInt(this.number_2.getText());

            int res = num1 - num2;

            result.setText(String.valueOf(res));
        } catch (NumberFormatException e) {
            App.showAlert("Error!", "Incorrect format number", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void buttonDivide(ActionEvent actionEvent) {
        resetResult();

        operator.setText("/");

        try {
            int num1 = Integer.parseInt(this.number_1.getText());
            int num2 = Integer.parseInt(this.number_2.getText());

            int res = num1 / num2;

            result.setText(String.valueOf(res));
        } catch (NumberFormatException e) {
            App.showAlert("Error!", "Incorrect format number", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void buttonMulti(ActionEvent actionEvent) {
        resetResult();

        operator.setText("*");

        try {
            int num1 = Integer.parseInt(this.number_1.getText());
            int num2 = Integer.parseInt(this.number_2.getText());

            int res = num1 * num2;

            result.setText(String.valueOf(res));
        } catch (NumberFormatException e) {
            App.showAlert("Error!", "Incorrect format number", Alert.AlertType.ERROR);
        }
    }

    private void resetResult() {
        if (!result.getText().equals("0")) {
            result.setText("0");
        }
    }

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
