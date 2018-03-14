package hackerrank.java.DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-sort/problem
 */
class Student {
	private int id;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

// Complete the code
class StudentComparator implements Comparator<Student> {
	public int compare(Student student1, Student student2) {
		if (student1.getCgpa() > student2.getCgpa()) {
			return -1;
		} else if (student1.getCgpa() < student2.getCgpa()) {
			return 1;
		} else if (student1.getFname().compareTo(student2.getFname()) != 0) {
			return student1.getFname().compareTo(student2.getFname());
		} else if (student1.getId() > student2.getId()) {
			return 1;
		} else if (student1.getId() < student2.getId()) {
			return -1;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}
		Collections.sort(studentList, new StudentComparator());
		for (Student st : studentList) {
			System.out.println(st.getFname());
		}
	}
}
