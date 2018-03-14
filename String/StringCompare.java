package hackerrank.java.String;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-string-compare/problem
 */
public class StringCompare {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String min, max;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        min = s.substring(0, k);
        max = s.substring(0, k);
        for(int i=1; i<=s.length()-k; i++){
            if(min.compareTo(s.substring(i, i+k))>0){
                min= s.substring(i, i+k);
            }
            if(max.compareTo(s.substring(i, i+k))<0){
                max = s.substring(i, i+k);
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
}
