package Unit3_3;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;

public class Saving extends JFrame {

	public Saving() {

		setFrame();

		JPanel panelDeposit = new JPanel();
		JPanel panelWithdraw = new JPanel();

		panelDeposit.setLayout(new FlowLayout());
		panelWithdraw.setLayout(new FlowLayout());

		JLabel depositSavLbl = new JLabel("Deposit Amount: $");
		JLabel withdrawSavLbl = new JLabel("Withdraw Amount: $");

		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		format.setMaximumFractionDigits(2);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0.0);
		formatter.setMaximum(10000000.0);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);

		JFormattedTextField depositSav = new JFormattedTextField(formatter);
		depositSav.setColumns(10);
		depositSav.setValue(0.0);

		JFormattedTextField withdrawSav = new JFormattedTextField(formatter);
		withdrawSav.setColumns(10);
		withdrawSav.setValue(0.0);

		depositSavLbl.setLabelFor(depositSav);
		withdrawSavLbl.setLabelFor(withdrawSav);

		depositSav.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				double value = Double.valueOf((Double) depositSav.getValue());

				History.Deposit(value, "depsav");
				
				depositSav.setValue(0.0);
				
				BankGUI.update();

			}

		});

		withdrawSav.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				double value = Double.valueOf((Double) withdrawSav.getValue());

				History.Withdraw(value, "witsav");
				
				withdrawSav.setValue(0.0);
				
				BankGUI.update();

			}

		});

		panelDeposit.add(depositSavLbl);
		panelDeposit.add(depositSav);

		panelWithdraw.add(withdrawSavLbl);
		panelWithdraw.add(withdrawSav);

		getContentPane().add(panelDeposit);
		getContentPane().add(panelWithdraw);

	}

	private void setFrame() {

		setTitle("Finance Manager");

		setSize(500, 400);

		setLayout(new GridLayout(2, 0));

		setResizable(false);

	}

}
