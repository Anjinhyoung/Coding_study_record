package day28;

public class Anonymous3 {
	public static void main(String[] args) {
//		Inter1 i1=new Inter1(); 인터페이스 객체 생성 불가
		Inter1 i1= new Inter1() {
			public void f1() {
				System.out.println("f1()");
			}
		};
		i1.f1();
	}
}

interface Inter1{
	public void f1();
}


