import java.util.Stack;

public class StackEx {
	public static void main(String[] args) {
			Stack<String> s = new Stack<String>();
			
			s.push("apple");
			s.push("banana");
			s.push("cherry");
			System.out.println(s);
			
			System.out.println("peek: "+s.peek());
			System.out.println("pop: "+s.pop());
			System.out.println(s);
			s.push("tomato");
			System.out.println(s);
			System.out.println("search(apple):"+s.search("apple"));
			System.out.println("search(banana):"+s.search("banana"));
			System.out.println("search(tomato):"+s.search("tomato"));
	}
}

