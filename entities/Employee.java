package entities;

public class Employee {

	private String name;
	private double salary;
	private int id;

	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return this.name;
	}

	public double getSalary() {
		return this.salary;
	}

	public int getId() {
		return this.id;
	}

	public double increaseSalary(double percentage) {

		return this.salary = this.salary + (this.salary * (percentage / 100));
	}
	public String toString() {
		return "ID: "+this.id+"\nName: "+this.name+"\nSalary: "+this.salary;
	}
}
