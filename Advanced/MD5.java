package hackerrank.java.Advanced;

/*
 * https://www.hackerrank.com/challenges/java-md5/problem
 */
import java.security.MessageDigest;
import java.util.Scanner;

public class MD5 {

	/*
	 * HelloWorld -> 68e109f0f40ca72a15e05cc22786f8e6
	 */
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		String original = sc.nextLine();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(original.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b));
			}

			System.out.println(sb.toString());
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}
