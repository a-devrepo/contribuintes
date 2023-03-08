package entities;

public class TaxPayer {

	private double salaryIncome;
	private double serviceIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	
	public TaxPayer() {}

	public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		double monthSalary = salaryIncome / 12;

		if (monthSalary < 3000.00) {
			return 0.0;
		} else if (monthSalary < 5000.00) {
			return salaryIncome * 0.1;
		} else {
			return salaryIncome * 0.2;
		}
	}

	public double servicesTax() {
		return serviceIncome * 0.15;
	}

	public double capitalTax() {
		return capitalIncome * 0.2;
	}

	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		double maxDeductible = grossTax() * 0.3;
		double deductibleExpenses = healthSpending + educationSpending;

		if (deductibleExpenses >= maxDeductible) {
			return maxDeductible;
		} else {
			return deductibleExpenses;
		}
	}

	public double netTax() {
		return grossTax() - taxRebate();
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServiceIncome() {
		return serviceIncome;
	}

	public void setServiceIncome(double serviceIncome) {
		this.serviceIncome = serviceIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	@Override
	public String toString() {
		return "TaxPayer [salaryIncome=" + salaryIncome + ", serviceIncome=" + serviceIncome + ", capitalIncome="
				+ capitalIncome + ", healthSpending=" + healthSpending + ", educationSpending=" + educationSpending
				+ "]";
	}
}
