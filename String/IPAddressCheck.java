package hackerrank.java.String;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-regex/problem
 * 
 * IP address is a string in the form "A.B.C.D", 
 * where the value of A, B, C, and D may range from 0 to 255. 
 * Leading zeros are allowed. 
 * The length of A, B, C, or D can't be greater than 3.
 * 
 * Some valid IP address:

	000.12.12.034
	121.234.12.12
	23.45.12.56
	Some invalid IP address:
	
	000.12.234.23.23
	666.666.23.23
	.213.123.23.32
	23.45.22.32.
	I.Am.not.an.ip
 */
class IPAddressCheck{

    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

class MyRegex{
    //(0|1 or nothing)(0-9)(0-9 or nothing) or 2(0-4)(0-9) or 25(0-5)
    public String pattern ="^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
}