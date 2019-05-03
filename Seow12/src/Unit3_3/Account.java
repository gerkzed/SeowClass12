package Unit3_3;

public class Account {

	private double Chequing;

	private double Saving;

	private int withChequing;

	private int withSaving;

	public Account() {

		this.Saving = 0;

		this.Chequing = 0;
		
		this.withSaving = 3;

		this.withChequing = 0;

	}

	public Account(double s, double c, int ws, int wc) {

		this.Saving = s;
		
		this.Chequing = c;

		this.withSaving = ws;

		this.withChequing = wc;

	}

	public double getChequing() {

		return Chequing;

	}

	public void setChequing(double c) {

		this.Chequing = c;

	}

	public double getSaving() {

		return Saving;

	}

	public void setSaving(double s) {

		this.Saving = s;

	}

	public int getWithSaving() {

		return withSaving;

	}

	public void setWithSaving(int ws) {

		this.withSaving = ws;

	}

	public int getWithChequing() {

		return withChequing;

	}

	public void setWithChequing(int wc) {

		this.withChequing = wc;

	}

	public String toFile() {

		return getSaving() + "/" + getChequing() + "/" + getWithSaving() + "/" + getWithChequing();

	}

	public boolean enoughMoneySavings(double value) {

		if (getWithSaving() == 0) {

			if (value + 1 <= getSaving()) {

				return true;

			}

			else {

				return false;

			}

		}

		else if (value <= getSaving()) {

			return true;

		}

		else {

			return false;

		}
	}

	public boolean enoughMoneyChequing(double value) {

		if (getWithChequing() < 10) {

			if (value + 0.50 <= getChequing()) {

				return true;

			}

			else {

				return false;

			}

		}

		else if (value <= getChequing()) {

			return true;

		}

		else {

			return false;

		}
	}
}
