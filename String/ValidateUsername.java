package hackerrank.java.String;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * https://www.hackerrank.com/challenges/valid-username-checker/problem
 * 
 * The username can contain alphanumeric characters and/or underscores(_).
 * The username must start with an alphabetic character.
 * 8  |Username|  30.
 * 
 *  Input:
 * 4
alpha_naheed
xahidbuffon
nagib@007
123Swakkhar
 * 
 */
public class ValidateUsername {
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      int testCases = Integer.parseInt(in.nextLine());
      while(testCases>0){
         String username = in.nextLine();
         //String pattern = Complete this line in the editable area below 
         //String pattern = "^[a-zA-Z][a-zA-Z_]{7,29}$";
         String pattern = "^[a-zA-Z]\\w{7,29}$"; // w same [a-zA-Z0-9_]
         
         Pattern r = Pattern.compile(pattern);
         Matcher m = r.matcher(username);
          
         if (m.find( )) {
            System.out.println("Valid");
         } else {
            System.out.println("Invalid");
         }
         testCases--;
      }
   }
}