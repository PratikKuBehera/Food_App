package com.tap.decode;

public class Decode {
	
	private static final int KEY = 9;

	
	public static String encrypt(String str) {
		
		String newstr ="";
		
		for(int i =0 ; i<=str.length()-1 ; i++) {
			
			newstr = newstr+((char)(str.charAt(i)+getkey())); 
			
		}
		return newstr;		
	}

	
   public static String  decrypt(String str) {
	   
	   String newstr ="";

	   for(int i=0 ; i<=str.length()-1 ; i++) {
		   
			newstr = newstr+((char)(str.charAt(i)-getkey())); 
	   }
	   return newstr;
		
	}
   
   
   public static int  getkey() {
	   
	   return KEY;
	   
		
	}


	
	
}
