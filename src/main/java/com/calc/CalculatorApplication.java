/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package com.calc;

import com.calc.service.CalculatorService;
import com.calc.ui.CalculatorUI;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		try {
			CalculatorService calculatorService = new CalculatorService();
			SwingUtilities.invokeLater(() -> {
				CalculatorUI calculatorUI = new CalculatorUI(calculatorService);
				calculatorUI.setVisible(true);
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
