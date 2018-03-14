package hackerrank.java.BigNumber;

/*
 * https://www.hackerrank.com/challenges/java-bigdecimal/problem
 */
import java.math.BigDecimal;
import java.util.*;
class SortBigDecimal{
    public static void main(String []args){
        //Input
    	/*
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();
        */
        
        String s[] = {"9" ,"-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000"};
        
        Arrays.sort(s, 0, s.length, (first, second) -> {
            BigDecimal a = new BigDecimal(first);
            BigDecimal b = new BigDecimal(second);
            return b.compareTo(a);
        });
      //Output
        for(int i=0;i<s.length;i++)
        {
            System.out.println(s[i]);
        }
    }
}

        