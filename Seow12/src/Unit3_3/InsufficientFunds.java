package Unit3_3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class InsufficientFunds extends JFrame {

	public InsufficientFunds() {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setBounds(100, 100, 337, 198);

		JLabel lblInsufficientFunds = new JLabel("NSF ERROR");
		
		lblInsufficientFunds.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblInsufficientFunds.setFont(new Font("Arial", Font.BOLD, 16));
		
		lblInsufficientFunds.setBounds(66, 62, 174, 14);
		
		getContentPane().add(lblInsufficientFunds);

	}

}
