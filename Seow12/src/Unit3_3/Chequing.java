package Unit3_3;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;

public class Chequing extends JFrame {

	public Chequing() {

		setFrame();

		JPanel panelDeposit = new JPanel();
		JPanel panelWithdraw = new JPanel();

		panelDeposit.setLayout(new FlowLayout());
		panelWithdraw.setLayout(new FlowLayout());

		JLabel depositChqLbl = new JLabel("Deposit Amount: $");
		JLabel withdrawChqLbl = new JLabel("Withdraw Amount: $");

		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		format.setMaximumFractionDigits(2);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0.0);
		formatter.setMaximum(10000000.0);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);

		JFormattedTextField depositChq = new JFormattedTextField(formatter);
		depositChq.setColumns(10);
		depositChq.setValue(0.0);

		JFormattedTextField withdrawChq = new JFormattedTextField(formatter);
		withdrawChq.setColumns(10);
		withdrawChq.setValue(0.0);

		depositChqLbl.setLabelFor(depositChq);
		withdrawChqLbl.setLabelFor(withdrawChq);

		depositChq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				double value = Double.valueOf((Double) depositChq.getValue());

				History.Deposit(value, "depchq");
				
				depositChq.setValue(0.0);
				
				BankGUI.update();

			}

		});

		withdrawChq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				double value = Double.valueOf((Double) withdrawChq.getValue());

				History.Withdraw(value, "witchq");
				
				withdrawChq.setValue(0.0);
				
				BankGUI.update();

			}

		});

		panelDeposit.add(depositChqLbl);
		panelDeposit.add(depositChq);

		panelWithdraw.add(withdrawChqLbl);
		panelWithdraw.add(withdrawChq);

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
