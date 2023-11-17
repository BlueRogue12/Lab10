
/**
 * File: Lab 10
 * Class: CSCI 1302 
 * Author: Sydney Boles, Michael Aaron, and Lana Marin
 * Created on: November 17, 2023
 * Last modified: November 17, 2023 
 * Description: Input and output exact data into new file
 */

import java.io.*;

public class Lab10Prob01 {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Try with resources for input and output
		try (DataInputStream input = new DataInputStream(
				new BufferedInputStream(new FileInputStream("src/people.dat")));
				DataOutputStream output = new DataOutputStream(
						new BufferedOutputStream(new FileOutputStream("src/people-copy.dat")));) {

			// Input file and display to console, then output to a new file
			while (true) {
				int age = input.readInt();
				String name = input.readUTF();
				String address = input.readUTF();
				int zipCode = input.readInt();
				double salary = input.readDouble();
				System.out.printf("%s %d %s %d %.2f%n", name, age, address, zipCode, salary);

				output.writeInt(age);
				output.writeUTF(name);
				output.writeUTF(address);
				output.writeInt(zipCode);
				output.writeDouble(salary);
			}

		} catch (EOFException e) {
		}

	}
}

class Person {

	// Data fields
	private int age;
	private String name;
	private String address;
	private int zipCode;
	private double salary;

	// Default constructor
	public Person() {

	}

	// Mutators for all data members
	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	// Accessors for all data members
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public double getSalary() {
		return salary;
	}

	// toString method
	public String toString() {
		return String.format("%s %d %s %d $%,.2f%n", getName(), getAge(), getAddress(), getZipCode(), getSalary());

	}

	// CompareTo() Method
	public int compareTo(Person otherSalary) {
		if (this.salary < otherSalary.salary) {
			return 1;
		} else if (this.salary > otherSalary.salary) {
			return -1;
		} else {
			return 0;
		}
	}

}
