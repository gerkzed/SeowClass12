package Unit3_3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankGUI extends JFrame {

	private static JLabel Savings = new JLabel("Savings Account: $" + Bank.User.getSaving());
	
	private static JLabel Chequings = new JLabel("Chequing Account: $" + Bank.User.getChequing());
	
	private static JLabel WithSavings = new JLabel("Free withdrawls left: " + Bank.User.getWithSaving());
	
	private static JLabel WithChequings = new JLabel("Number of cheque withdrawls: " + Bank.User.getWithChequing());
	
	public BankGUI() {
		
		setFrame();

		JButton ChqButton = new JButton("CHEQUING");
		ChqButton.setFont(new Font("Arial", Font.BOLD, 14));
		ChqButton.setBounds(50, 200, 175, 100);
		ChqButton.addActionListener(new ActionListener() {
			
			/* 
			 * If Chequing account is selected
			 */
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Chequing chq = new Chequing();
				
				chq.setVisible(true);
				
			}
		});
		
		JButton SavButton = new JButton("SAVING");
		SavButton.setFont(new Font("Arial", Font.BOLD, 14));
		SavButton.setBounds(275, 200, 175, 100);
		SavButton.addActionListener(new ActionListener() {
			
			/*
			 * If Saving account is selected
			 */
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Saving sav = new Saving();
				
				sav.setVisible(true);

			}
		});
		
		JLabel SelectAccount = new JLabel("SELECT AN OPTION");
		SelectAccount.setFont(new Font("Arial", Font.BOLD, 16));
		SelectAccount.setHorizontalAlignment(SwingConstants.CENTER);
		SelectAccount.setBounds(0, 0, 500, 100);
		
		Savings.setFont(new Font("Arial", Font.BOLD, 16));
		Savings.setHorizontalAlignment(SwingConstants.CENTER);
		Savings.setBounds(0, 40, 500, 100);
		
		Chequings.setFont(new Font("Arial", Font.BOLD, 16));
		Chequings.setHorizontalAlignment(SwingConstants.CENTER);
		Chequings.setBounds(0, 60, 500, 100);
		
		WithSavings.setFont(new Font("Arial", Font.BOLD, 16));
		WithSavings.setHorizontalAlignment(SwingConstants.CENTER);
		WithSavings.setBounds(0, 80, 500, 100);
		
		WithChequings.setFont(new Font("Arial", Font.BOLD, 16));
		WithChequings.setHorizontalAlignment(SwingConstants.CENTER);
		WithChequings.setBounds(0, 100, 500, 100);

		getContentPane().add(ChqButton);
		getContentPane().add(SavButton);
		getContentPane().add(SelectAccount);
		getContentPane().add(Savings);
		getContentPane().add(Chequings);
		getContentPane().add(WithSavings);
		getContentPane().add(WithChequings);
		
		
	}

	private void setFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Finance Manager");
		
		setSize(500, 400);
		
		setLayout(null);
		
		setResizable(false);
		
	}

	public static void update() {
		
		Savings.setText("Savings Account: $" + Bank.User.getSaving());
		
		Chequings.setText("Chequing Account: $" + Bank.User.getChequing());
		
		WithSavings.setText("Free withdrawls left: " + Bank.User.getWithSaving());
		
		WithChequings.setText("Number of cheque withdrawls: " + Bank.User.getWithChequing());
		
	}
	
}
