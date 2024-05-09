public class Interface1 {
	public static void main(String[] args) {
		 B b =new B();
		 b.methodA();
		 b.methodB();
		 
	}
}

interface Ainter{
	final int x=10;
	int y=20; //final »ý·«°¡´É
	abstract void methodA();
	void methodB(); //abstract »ý·«°¡´É
}
class B implements Ainter{
	@Override
	public void methodA() {
		System.out.println("methodA()");
	}

	@Override
	public void methodB() {
		System.out.println("methodB()");
	}
	
}
