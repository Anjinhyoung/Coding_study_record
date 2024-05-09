package day28;

public class Anonymous4 {
	public static void main(String[] args) {
//		Abstract1 ab1 = new Abstract1();  추상클래스 객체 생성 불가
		Abstract1 ab1 = new Abstract1() {
			void f2() {
				System.out.println("f2( )");
			}};
	}
}

abstract class Abstract1{
	abstract void f2();
}


