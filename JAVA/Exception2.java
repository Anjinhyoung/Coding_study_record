public class Exception2 {
	public static void main(String[] args) {
		try {
			Exception e=new Exception("°íÀÇ ¿¹¿Ü");
			throw e;
		}
		catch(Exception e) {
			System.out.println("¿¹¿Ü ¹ß»ý");
			System.out.println(e.getMessage());
		}
	}
}

