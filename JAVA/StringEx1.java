package day31;

public class StringEx1 {
	public static void main(String[] args) {
		String str1 = "Hello World";
		//concat, substring,length
		System.out.println(str1.concat(" Bye World"));
		System.out.println(str1);
		System.out.println(str1.substring(6,10));
		System.out.println(str1.length());
		// toUpper, toLower
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());
	}
}

