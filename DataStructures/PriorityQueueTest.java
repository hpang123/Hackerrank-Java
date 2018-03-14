package hackerrank.java.DataStructures;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-priority-queue/problem
 */
class Student {
	private int token;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getToken() {
		return token;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

class StudentComparator implements Comparator<Student> {
	public int compare(Student o1, Student o2) {
		if (o1.getCgpa() > o2.getCgpa()) {
			return -1;
		} else if (o1.getCgpa() < o2.getCgpa()) {
			return 1;
		} else if (o1.getFname().compareTo(o2.getFname()) != 0) {
			return o1.getFname().compareTo(o2.getFname());
		} else if (o1.getToken() > o2.getToken()) {
			return 1;
		} else if (o1.getToken() > o2.getToken()) {
			return -1;
		}
		return 0;

	}
}

public class PriorityQueueTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int totalEvents = Integer.parseInt(in.nextLine());

		Comparator<Student> comparator = new StudentComparator();
		PriorityQueue<Student> queue = new PriorityQueue<Student>(
				totalEvents + 1, comparator);

		while (totalEvents > 0) {
			String event = in.next();

			// Complete your code
			if (event.compareToIgnoreCase("ENTER") == 0) {
				String name = in.next();
				double cgpa = in.nextDouble();
				int token = in.nextInt();
				Student student = new Student(token, name, cgpa);
				queue.add(student);
				// System.out.println(name + " " + cgpa + " " + token);
			} else {
				// System.out.println("SERVED");
				queue.poll();
			}

			totalEvents--;
		}
		if (queue.size() == 0) {
			System.out.println("EMPTY");
		} else {
			while (queue.size() > 0) {
				System.out.println(queue.poll().getFname());
			}
		}
	}
}
