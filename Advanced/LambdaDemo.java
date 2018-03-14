package hackerrank.java.Advanced;

/*
 * https://www.hackerrank.com/challenges/java-lambda-expressions/problem
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@FunctionalInterface
interface PerformOperation {
	boolean check(int a);
}

/*
 * Sample Input

The first line contains an integer,  (the number of test cases).

The  subsequent lines each describe a test case in the form of  space-separated integers: 
The first integer specifies the condition to check for ( for Odd/Even,  for Prime, or  for Palindrome). The second integer denotes the number to be checked.

5
1 4
2 5
3 898
1 3
2 12

Sample Output

EVEN
PRIME
PALINDROME
ODD
COMPOSITE

 */
class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	PerformOperation is_odd() {
		return n ->
			{
				if ((n % 2) == 0) {
					return false;
				}
				return true;
			};
	}

	PerformOperation is_prime() {
		return n ->
			{
				for (int i = 2; 2 * i < n; i++) {
					if (n % i == 0)
						return false;
				}
				return true;
			};
	}

	//123454321
	PerformOperation is_palindrome() {
		return n ->
			{
				int copy = n;
				int rev = 0;
				int r;
				while (n > 0) {
					r = n % 10; // getting remainder
					rev = (rev * 10) + r;
					n = n / 10;
				}
				if (copy == rev) {
					return true;
				}
				return false;
			};
	}
}

public class LambdaDemo {

	public static void main(String[] args) throws IOException {
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.is_odd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = ob.is_prime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ob.is_palindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}
	}
}