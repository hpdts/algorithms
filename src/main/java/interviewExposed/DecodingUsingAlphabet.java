package interviewExposed;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DecodingUsingAlphabet{
	//a=1,b=2,c=3,d=4,e=5,f=6,g=7,h=8,i=9,j=10,k=11,l=12,m=13,n=14,
	//o=15,p=16,q=17,r=18,s=19,t=20,u=21,v=22,w=23,x=24,y=25,z=26
	public int countDecoding(char[] digits, int n){

		if(n == 0 || n == 1){
			return 1;
		}

		int count = 0;
		if(digits[n-1] > '0'){
			count = countDecoding(digits, n-1);
		}

		if(digits[n-2] == '1' || digits[n-2] == '2' && digits[n-1] < '7'){
			count += countDecoding(digits, n - 2);
		}

		return count;
	}

	//Using dynamic programming
	public int countDecodingDP(char[] digits, int n){
		int[] count = new int[n + 1];
		count[0] = 1;
		count[1] = 1;
		System.out.println("digits: " + Arrays.toString(digits));
		for(int i = 2; i <= n ; i++){
			count[i] = 0;
			System.out.println("i: " + i);
			System.out.println("before count[i]: " + count[i]);
			System.out.println("before count[i-1]: " + count[i-1]);
			System.out.println("digits[i - 1]: " + digits[i - 1]);
			if(digits[i - 1] > '0'){
				count[i] = count[i - 1];
			}
			System.out.println("count[i]: " + count[i]);
			System.out.println("digits[i - 2] : " + digits[i - 2]);

			if(digits[i - 2] == '1' || digits[i - 2] == '2' && digits[i - 1] < '7'){
				count[i]+= count[i - 2];
			}
			System.out.println("after 2 count[i]: " + count[i]);
	
		}
		return count[n];
	}
}