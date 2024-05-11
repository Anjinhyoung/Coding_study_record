package day38;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
	public static void main(String[] args) {
		
			Queue<String> q = new LinkedList<String>();
			q.add("apple");
			q.add("banana");
			q.add("cherry");
			
			System.out.println(q);
			
			System.out.println("peek:"+q.peek());
			System.out.println("remove:"+q.remove());
			q.offer("tomato");
			System.out.println(q);
			System.out.println("poll:"+q.poll());
			System.out.println(q);
	}
}


