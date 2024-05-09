import java.util.Scanner;

public class Cafe {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int count=0;
		String orderList[]=new String[5];
		int total=0;
		for(int i=0;i<orderList.length;i++) {
			orderList[i]="";
		}
		while(true) {
			System.out.println("☆★☆★ Cafe ☆★☆★");
			System.out.println("현재 금액:"+total+"원");
			System.out.println("주문내역-------");
			for(int i=0;i<count;i++) {
				System.out.println(i+1+". "+orderList[i]);
			}
			System.out.println("--------------");
			System.out.println("1. 주문하기");
			System.out.println("2. 취소하기");
			System.out.println("3. 결제하기");
			System.out.println("4. 끝내기");
			System.out.print("입력:");
			int num=sc.nextInt();
			if(num==1) {
				String menuName;
				int menuPrice=3800;
				System.out.println("☆★☆★MENU☆★☆★");
				System.out.println("1.아메리카노\t3800 원");
				System.out.println("2.에스프레소\t2400 원");
				System.out.println("3.카페라떼\t\t4200 원");
				System.out.println("4.밀크티\t\t5100 원");
				System.out.print("주문할 메뉴:");
				int choice=sc.nextInt();
				if(choice==1) {
					menuName="아메리카노";
					menuPrice=3800;
				}
				else if(choice==2) {
					menuName="에스프레소";
					menuPrice=2400;
				}
				else if(choice==3) {
					menuName="카페라떼";
					menuPrice=4200;}
				else if(choice==4) {
					menuName="밀크티";
					menuPrice=5100;
				}
				else {
					System.out.println("잘못입력하셨습니다.");
					continue;
				}
				System.out.println("주문한 메뉴는 "+menuName+"입니다.");
				System.out.println("가격은 "+menuPrice+"원 입니다.");
				orderList[count]=menuName;
				total+=menuPrice;
				count++;
			}
			else if(num==2) {
				for(int i=0;i<count;i++) {
				System.out.println(i+1+":"+orderList[i]);
				}
				System.out.print("취소할 메뉴 번호:");
				int cancel=sc.nextInt();
				if(1<=cancel && cancel<=count) {
					String delMenu=orderList[cancel-1];
					System.out.println(delMenu+" 메뉴 삭제!");
					for(int i=cancel-1;i<count;i++) {
						orderList[i]=orderList[i+1];
					}
					if(delMenu.equals("아메리카노")){
						total-=3800;
					}
					else if(delMenu.equals("에스프레소")){
						total-=2400;
					}
					else if(delMenu.equals("카페라떼")){
						total-=4200;
					}
					else if(delMenu.equals("밀크티")){
						total-=5100;
					}
					count--;
				}
			}
			else if(num==3) {
				System.out.println("결제해야할 금액: "+total+"원");
				System.out.print("지불할 금액:");			
				int money=sc.nextInt();
				if(money<total) {
					System.out.println("잔돈이 부족합니다.");
					continue;
				}
				else{
					System.out.println("잔돈은 "+(money-total)+"원 입니다.");
					System.out.println("결제가 완료되었습니다.");
				}
				total=0;
				for(int i=0;i<orderList.length;i++) {
					orderList[i]="";
				}
				count=0;
			}
			else if(num==4) {
				System.out.println("프로그램 종료!");
				 break;
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
			
		}
	}

}
