package cracking.stringarrays;

import java.util.*;

public class RotatedString {


	public boolean isRotationStackOverflow(String s1, String s2){
		//return (s1.length() == s2.length() && (s1+s1).indefOf(s2) != -1);
		return (s1.length() == s2.length() && (s1+s1).contains(s2));
	
	}
	
	
}
