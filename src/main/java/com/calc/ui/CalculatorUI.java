/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package com.calc.ui;

import com.calc.service.CalculatorService;
import com.calc.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

@Component
public class CalculatorUI extends JFrame implements ActionListener {

    @Autowired
    private final CalculatorService calculatorService;

    private final JTextField display;
    private final StringBuilder currentInput = new StringBuilder();

    public CalculatorUI(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;

        setTitle(Constants.APP_NAME);
        setSize(Constants.DISPLAY_WIDTH_NUMBER, Constants.DISPLAY_HEIGHT_NUMBER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField(Constants.ZERO);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(Constants.DISPLAY_ROWS_NUMBER, Constants.DISPLAY_COLUMNS_NUMBER));

        String[] buttons = {
                Constants.OPERATION_ADD, Constants.OPERATION_MINUS, Constants.OPERATION_MULTIPLY,
                Constants.OPERATION_DIVIDE, Constants.CLEAR, Constants.EQUALS,
                Constants.SEVEN, Constants.EIGHT, Constants.NINE,
                Constants.FOUR, Constants.FIVE, Constants.SIX,
                Constants.ONE, Constants.TWO, Constants.THREE,
                Constants.ZERO, "^"};

        for (String btnText : buttons) {
            JButton button = new JButton(btnText);
            button.setSize(5, 5);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Objects.requireNonNull(e);
        String command = e.getActionCommand();
        char newChar = command.charAt(0);

        switch (command) {
            case Constants.EQUALS -> {
                try {
                    int result = calculatorService.calculate(currentInput.toString());
                    display.setText(String.valueOf(result));
                    currentInput.setLength(Constants.BUFFER_ZERO);
                } catch (Exception ex) {
                    display.setText(Constants.DISPLAY_TEXT_ERROR);
                    currentInput.setLength(Constants.BUFFER_ZERO);
                }
            }
            case Constants.CLEAR -> {
                currentInput.setLength(Constants.BUFFER_ZERO);
                display.setText(Constants.ZERO);
            }
            default -> {
                if (currentInput.isEmpty()) {
                    if (Character.isDigit(newChar) || newChar == '-') {
                        currentInput.append(newChar);
                        display.setText(currentInput.toString());
                    }
                    return;
                }
                currentInput.append(newChar);
                display.setText(currentInput.toString());
            }
        }
    }

}
