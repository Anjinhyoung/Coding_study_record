package day36;

public class TypeSearch {
	public static void main(String[] args) {
		Value v= new Value();
		v.typeSearch(3);
		v.typeSearch(3.14);
		v.typeSearch(3.14f);
		v.typeSearch('a');
		v.typeSearch("hello");
	}
}
class Value{
	public <T> void typeSearch(T x){
		if(x instanceof Integer) {
			System.out.println(x+"는 정수 입니다.");
			
		}
		else if(x instanceof Double||x instanceof Float) {
			System.out.println(x+ "는 실수 입니다.");
		}
		else if(x instanceof Character) {
			System.out.println(x+"는 문자형 입니다.");
		}
		else if(x instanceof String) {
			System.out.println(x+"는 문자열 입니다.");
			
		}
	}
}

