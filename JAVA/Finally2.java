import java.util.Scanner;
public class Finally2 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a,b;
		System.out.print("a:");
		a=sc.nextInt();
		System.out.print("b:");
		b=sc.nextInt();
		try {
			int c=b/a;
			System.out.println("c:"+c);
		}
		catch(ArithmeticException e) {
		System.out.println("오류가 발생했습니다.");
		}
		finally {
			System.out.println("무조건 실행~");
		}
	}
}


