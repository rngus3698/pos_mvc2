package pos.view;

import java.util.ArrayList;

import pos.model.vo.OrderList;
import pos.model.vo.Seat;

public class ClientResponse {

	public void error(String string) {
		// TODO Auto-generated method stub
		System.out.println("error");
	}

	public void seatView(Seat seat) 
	{
		System.out.println(seat);
	}

	public void alert(String string) 
	{
		switch(string)
		{
		case "order":
			System.out.println("주문이 들어갔습니다.");
			break;
			
			default: break;
		}
		
	}

	public void deleteView(int tableNum) 
	{
		System.out.println(tableNum + "번 테이블 결제 완료");
	}

	public void insertOrderListView() 
	{
		System.out.println("orderList insert 완료");
		
	}


	public void orderListView(ArrayList<OrderList> list) {
		// TODO Auto-generated method stub
		for(OrderList ol : list)
		{
			System.out.println(ol);
		}
	}

	
}
