public class Constructor3 {
	public static void main(String[] args) {
		Bclass b1= new Bclass("가길동");
		System.out.println(b1.name);
		Bclass b= new Bclass();
		System.out.println(b);
	}

}
class Bclass{
	String name;
	//생성자오버로딩: 여러개 생성자 중복정의
	Bclass(){}
	Bclass(String name){ //매개변수 생성자
		System.out.println("Bclass의 매개변수 생성자( )");
		this.name=name;
	}
}

