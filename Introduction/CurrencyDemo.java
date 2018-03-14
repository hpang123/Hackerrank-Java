package hackerrank.java.Introduction;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-currency-formatter/problem
 */
public class CurrencyDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();

		// Write your code here.
		NumberFormat format = NumberFormat.getCurrencyInstance();
		String us = format.format(payment);

		format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
		String india = format.format(payment);

		format = NumberFormat.getCurrencyInstance(new Locale("zh", "cn"));
		String china = format.format(payment);

		format = NumberFormat.getCurrencyInstance(new Locale("fr", "fr"));
		String france = format.format(payment);

		System.out.println("US: " + us);
		System.out.println("India: " + india);
		System.out.println("China: " + china);
		System.out.println("France: " + france);
	}
}
