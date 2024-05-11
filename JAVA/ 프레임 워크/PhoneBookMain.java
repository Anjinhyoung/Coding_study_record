import java.util.*;

public class PhoneBookMain {
	static Scanner sc= new Scanner (System.in);
	static HashMap hm = new HashMap();
	public static void main(String[] args) {
		
		hm.put("가길동","010-1234-1234");
		hm.put("또치","010-1111-2222");
		hm.put("최민수","010-2345-2345");
		hm.put("유재석","010-1313-1313");
		hm.put("박명수","010-4444-5555");
		hm.put("노홍철","010-1010-2020");
		hm.put("하하","010-3030-4044");
		int choice;
		while(true) {
			System.out.println("***********전화번호부 프로그램***********");
			System.out.println("1. 고객 저장");
			System.out.println("2. 고객 검색");
			System.out.println("3. 전체 보기");
			System.out.println("4. 끝내기");
			System.out.print("번호 입력:");
			choice= sc.nextInt();
			if(choice==1) {insert();}
			else if(choice==2) {search();}
			else if(choice==3) {show();}
			else if(choice==4) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}
	public static void insert() {
		System.out.print("저장할 고객의 이름:");
		String insertName= sc.next();
		if(hm.containsKey(insertName)) {
			System.out.println("이미 존재하는 사람이므로 저장할 수 없습니다.");
			return;
		}
		else {
			System.out.print("저장할 고객 번호:");
			String insertPhone= sc.next();
			hm.put(insertName,insertPhone);
			System.out.println("저장이 완료되습니다.");
		}
		
	}
	public static void search() {
		System.out.print("검색할 이름:");
		String searchName = sc.next();
		if(hm.containsKey(searchName)){
			System.out.println("검색 완료!");
			System.out.println("검색된 전화번호:"+hm.get(searchName));
			
		}
		else {
			System.out.println("존재하지 않는 이름입니다.");
		}
	}
	public static void show() {
		Set keySet = hm.keySet();
		Iterator i = keySet.iterator();
		System.out.println("-----전체 고객 조회-------");
		while(i.hasNext()) {
			String curName=(String)i.next();
			System.out.println("name:"+curName+",phone:"+hm.get(curName));
		}
	}
}


