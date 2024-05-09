package day32;

public class IntegerWrapper {
	public static void main(String[] args) {
		Integer i = 100;
		//intValue():Integer ->int
		System.out.println(i.intValue()+3);
		
		//doubleValue():Integer->double
		System.out.println(i.doubleValue());
		
		//floatValue(): Integer->float
		System.out.println(i.floatValue());
		
		//toString(): Integer->String
		System.out.println(i.toString()+3);
		
		//Integer.parseInt():String->int
		System.out.println(Integer.parseInt("100"));
	}
}

