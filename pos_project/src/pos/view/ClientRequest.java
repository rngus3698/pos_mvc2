package pos.view;

import java.util.Scanner;

import pos.controller.Controller;
import pos.model.vo.MenuOrder;

public class ClientRequest {

	Scanner sc = new Scanner(System.in);
	
	Controller ct = new Controller();
	public void request() 
	{
		do
		{
			System.out.println("***jeonju pos program***");
			System.out.println("1. 주문");
			System.out.println("2. 테이블 조회");
			System.out.println("3. 결제");
			System.out.println("4. 주문내역");
			System.out.println("9. 종료");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();
			
			switch(no)
			{
				case 1: 
					ct.insertOrder(inputOrder());
					break;
				case 2: 
					ct.selectTable(inputTableNum());
					break;
				case 3: break;
				case 4: break;
				case 9: break;
				default: System.out.println("프로그램을 종료합니다."); return;
			}
		}while(true);		
	}
	
	private int inputTableNum() 
	{
		System.out.print("테이블 번호 : ");
		int tableNum = sc.nextInt();
		return tableNum;
	}

	//주문
	public MenuOrder inputOrder() {
		System.out.print("테이블 번호 : ");
		int tableNum = sc.nextInt();
		sc.nextLine();
		System.out.print("메뉴 : ");
		String menu = sc.nextLine();
		int price = selectMenuPrice(menu);
		
		MenuOrder menuOrder = new MenuOrder(tableNum, price, menu);
		
		return menuOrder;
	}
	
	//메뉴에 대한 가격을 불러옴
	public int selectMenuPrice(String menu)
	{
		return ct.selectMenuPrice(menu);
	}
	
}
