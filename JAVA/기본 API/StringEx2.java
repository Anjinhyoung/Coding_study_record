public class StringEx2 {
	public static void main(String[] args) {
		String str1="Hello World";
		//charAt, indexOf,equals
		System.out.println(str1.charAt(6));
		System.out.println(str1.indexOf("World"));
		System.out.println(str1.equals("Hello World"));
		System.out.println(str1.equals("hello world"));
		
		//trim, replace,replaceAll
		System.out.println(" trim test ".trim());
		System.out.println("hello".replace('l', 'L'));
		System.out.println("hello world".replaceAll("world","WORLD"));
	}
}

