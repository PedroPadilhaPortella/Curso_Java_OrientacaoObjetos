package entities;

public class Employee {
    private int Id;
    private String Name;
    private double Salary;

    public Employee(int id, String name, double salary) {
        this.Id = id;
        this.Name = name;
        this.Salary = salary;
    }

    public Employee() {}

    public Integer getId() {
		return this.Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public Double getSalary() {
		return this.Salary;
	}

	public void setSalary(Double salary) {
		this.Salary = salary;
	}

    public void IncreaseSalary(double percentage) {
        if(percentage > 0 && percentage <= 100)
            this.Salary += this.Salary * percentage / 100;
        else
            System.out.println("Invalid Percentage.");
    }

    public String toString() {
		return Id + ", " + Name + ", " + String.format("R$ %.2f", Salary);
	}
}
