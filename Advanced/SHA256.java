package hackerrank.java.Advanced;

import java.security.MessageDigest;
import java.util.Scanner;

/*
 * HelloWorld -> 872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4
 * Javarmi123 -> f1d5f8d75bb55c777207c251d07d9091dc10fe7d6682db869106aacb4b7df678
 */
public class SHA256 {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		try {
			String s = sc.nextLine();
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(s.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			System.out.println(hexString.toString());
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}