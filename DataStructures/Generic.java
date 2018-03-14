package hackerrank.java.DataStructures;

/*
 * https://www.hackerrank.com/challenges/java-generics/problem
 */

class Printer {
	// Write your code here
	public <E> void printArray(E[] array) {
		for (E e : array) {
			System.out.println(e);
		}
	}
}

public class Generic {}