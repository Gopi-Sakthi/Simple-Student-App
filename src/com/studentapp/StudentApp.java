package com.studentapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentApp {
	static {
		System.out.println("Welcome to Studnet Details Application");
	}
	static Scanner sc = new Scanner(System.in);
	static StudentDao dao = new StudentDao();

	public static void main(String[] args) {
		boolean flag = true;
		while (flag) {
			System.out.println("********************************************\n"
					+ "Select an Option\n********************************************\n" + "1)Add Student \n"
					+ "2)Display Student Details \n" + "3)Search Student by Id \n" + "4)Delete Student by Id \n"
					+ "5)Exit");
			try {
				int choice = sc.nextInt();
				System.out.println("********************************************");
				switch (choice) {
				case 1:
					dao.saveStudnet(readStudentInfo());
					break;
				case 2:
					dao.displayStudentDetails();
					break;
				case 3:
					dao.searchStudentById(readId());
					break;
				case 4:
					dao.deleteStudentById(readId());
					break;
				case 5:
					flag = false;
					break;
				default:
					System.out.println("Invalid Input");
				}
			} catch (InputMismatchException e) {
				System.err.println("Invalid Input");
				sc.next();
			}
		}
		System.out.println("Thank you using app...");

	}

	public static Student readStudentInfo() {
		try {
			System.out.println("Enter the Studnet id");
			int sid = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Studnet name");
			String sname = sc.nextLine();
			System.out.println("Enter the Studnet marks");
			double marks = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter the Studnet phone");
			String phone = sc.nextLine();
			System.out.println("Enter the Studnet email");
			String email = sc.next();
			System.out.println("Enter the Studnet gender");
			String gender = sc.next();
			return new Student(sid, sname, marks, phone, email, gender);
		} catch (InputMismatchException e) {
			e.printStackTrace();
			sc.next();
		}
		return null;
	}

	public static int readId() {

		System.out.println("Enter the Student id");
		return sc.nextInt();

	}

}
