public class InnerEx1 {
	public static void main(String[] args) {

	}
}

class A{
	static class StaticInner{
		
	}
	class InstanceInner{
		
	}
	StaticInner st1=new StaticInner();
	InstanceInner ii1 = new InstanceInner();
	
	static void StaticMethod() {
		StaticInner st2=new StaticInner();
//		InstanceInner ii2=new InstanceInner(); ¿À·ù¹ß»ý
	}
	void InstanceMethod(){
		StaticInner  st3=new StaticInner();
		InstanceInner ii3=new InstanceInner();
	}
	
}
