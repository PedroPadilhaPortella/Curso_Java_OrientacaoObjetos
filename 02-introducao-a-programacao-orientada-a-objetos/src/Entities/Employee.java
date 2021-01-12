package Entities;

public class Employee {
	public String Name;
	public double GrossSalary;
	public double Tax;
	
	public String toString() {
		return Name  + ", $ " + this.NetSalary();
	}
	
	public double NetSalary() {
		return this.GrossSalary - this.Tax;
	}
	
	public void IncreaseSalary(double percentage) {
		this.GrossSalary += this.GrossSalary * (percentage / 100);
	}
}
