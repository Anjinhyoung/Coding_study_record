package day25;

public class Polymorphism1 {
	public static void main(String[] args) {

		A obj = new B();//부모 변수= 자식값 : 업캐스팅
		obj.methodA();
//		obj.methodB();에러발생
	}
}
class A{
	void methodA() {
		System.out.println("methodA");
	}
}
class B extends A{
	void methodB() {
		System.out.println("methodB");
	}
}