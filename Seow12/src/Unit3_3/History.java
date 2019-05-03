package Unit3_3;

import java.io.*;
import java.util.*;
import java.text.*;

public class History {

	public static void Deposit(double money, String trans) {
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		if (trans.equals("depsav")) {
			
			Bank.User.setSaving(Double.parseDouble(df.format(Bank.User.getSaving() + money)));
			
			update();
			
			history("depsav", money);
			
		}
		
		else {
			
			Bank.User.setChequing(Double.parseDouble(df.format(Bank.User.getChequing() + money)));
			
			update();
			
			history("depchq", money);
			
		}

	}

	public static void Withdraw(double money, String trans) {

		DecimalFormat df = new DecimalFormat("#.##");
		
		try {

			if (trans.equals("witsav")) {

				if (Bank.User.enoughMoneySavings(money)) {

					if (Bank.User.getWithSaving() > 0) {
						
						Bank.User.setWithSaving(Bank.User.getWithSaving() - 1);

						Bank.User.setSaving(Double.parseDouble(df.format(Bank.User.getSaving() - money)));

					}
					
					else {
						
						money += 1;

						Bank.User.setSaving(Double.parseDouble(df.format(Bank.User.getSaving() - money)));
						
					}
					
					update();
					
					history("witsav", money);

				}

				else {
					
					throw new IllegalArgumentException("Savings");

				}

			}

			else {
				
				if (Bank.User.enoughMoneyChequing(money)) {

					if (Bank.User.getWithChequing() < 10) {

						money += 0.5;
						
						Bank.User.setWithChequing(Bank.User.getWithChequing() + 1);

						Bank.User.setChequing(Double.parseDouble(df.format(Bank.User.getChequing() - money)));

					}
					
					else {
						
						Bank.User.setWithChequing(Bank.User.getWithChequing() + 1);

						Bank.User.setChequing(Double.parseDouble(df.format(Bank.User.getChequing() - money)));
						
					}
					
					update();
					
					history("witchq", money);

				}
				
				else {
					
					throw new IllegalArgumentException("Chequing");

				}

			}

		}

		catch (IllegalArgumentException e) {
			
			InsufficientFunds insf = new InsufficientFunds();
			
			insf.setVisible(true);

		}

	}

	public static void update() {
		
		try {
			
			PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(Bank.fileAccount)));
			
			pr.println(Bank.User.toFile());
			
			pr.close();
			
		}
		
		catch(Exception e) {
			
			System.out.println("Error finding Banking file");
			
			System.exit(0);
			
		}
		
	}

	public static void history(String trans, double money) {
		
		PrintWriter pr;

		try {

			pr = new PrintWriter(new BufferedWriter(new FileWriter(Bank.fileLog, true)));

			String pattern = "yyyy-MM-dd";

			SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);

			String date = simpleDate.format(new Date());
			
			if (trans.equals("witsav")) {
				
				pr.println("Withdrew $" + money  + " from the Savings account on " + date + ".   Remaining total: $" + Bank.User.getSaving());
				
				pr.close();
				
			}
			
			else if(trans.equals("witchq")) {
				
				pr.println("Withdrew $" + money  + " from the Chequing account on " + date + ".   Remaining total: $" + Bank.User.getChequing());
				
				pr.close();
				
			}
			
			else if(trans.equals("depsav")) {
				
				pr.println("Deposited $" + money  + " to the Savings account on " + date + ".   New total: $" + Bank.User.getSaving());
				
				pr.close();
				
			}
			
			else {
				
				pr.println("Deposited $" + money  + " to the Chequing account on " + date + ".   New total: $" + Bank.User.getChequing());
				
				pr.close();
				
			}

		}
		
		catch (Exception e) {
			
			System.out.println("Problem reading transaction log file");
			
			System.exit(0);
			
		}
		
		
		

	}

}
