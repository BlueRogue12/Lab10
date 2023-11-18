
/**
 * File: Lab 10
 * Class: CSCI 1302 
 * Author: Sydney Boles, Michael Aaron, and Lana Marin
 * Created on: November 17, 2023
 * Last modified: November 18, 2023 
 * Description: Input and output utilizing ArrayList and a Person class
 */

import java.io.*;
import java.util.*;

public class Lab10Prob02 {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Create arrayList
		ArrayList<Person> people = new ArrayList<>();

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

				output.writeUTF(name);
				output.writeInt(age);
				output.writeUTF(address);
				output.writeInt(zipCode);
				output.writeDouble(salary);
				people.add(new Person(name, age, address, zipCode, salary));

			}

		} catch (EOFException e) {

		} catch (Exception e) {

		}

		Collections.sort(people);

		try (DataOutputStream output = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("src/people-salary-sorted.dat")));) {

			for (Person personsList : people) {
				output.writeUTF(personsList.toString());
			}
		} catch (Exception e) {

		}
	}
}

class Person implements Comparable<Person> {

	// Data fields
	private int age;
	private String name;
	private String address;
	private int zipCode;
	private double salary;

	// Default constructor
	public Person() {

	}

	// Convenience constructor
	public Person(String name, int age, String address, int zipCode, double salary) {
		this();
		setName(name);
		setAge(age);
		setAddress(address);
		setZipCode(zipCode);
		setSalary(salary);
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
		return String.format("%d %s %s %d $%,.2f", getAge(), getName(), getAddress(), getZipCode(), getSalary());

	}

	// CompareTo() Method
	@Override
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
