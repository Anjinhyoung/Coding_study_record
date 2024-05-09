package day31;

public class StringBufferEx {
	public static void main(String[] args) {
//		StringBuffer buffer="test"; --> 불가능
		StringBuffer buffer=new StringBuffer("test");
		String str="test";
		
		System.out.println("str:"+str);
		System.out.println("buffer:"+buffer);
		//append
		buffer.append(" Test");
		System.out.println("buffer.append:"+buffer);
		str.concat(" Test");
		System.out.println("str.concat:"+str);
		
		//replace(int start, int end,String str)
		buffer.replace(0, 10, "HELLO");
		System.out.println("buffer.replace:"+buffer);
		
		str.replace('t','T');
		System.out.println("str.replace:"+str);
		
		//reverse()
		buffer.reverse();
		System.out.println("buffer.reverse:"+buffer);
		//str.reverse()->없음
		
		//insert()
		buffer.insert(2,"BYE");
		System.out.println("buffer.insert:"+buffer);
		
		//delete
		buffer.delete(0,3);
		System.out.println("buffer.delete:"+buffer);
		//deleteCharAt()
		buffer.deleteCharAt(3);
		System.out.println("buffer.deleteCharAt:"+buffer);
		
		
	}

}
