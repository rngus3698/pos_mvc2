package pos.view;

import java.util.ArrayList;

import pos.model.vo.OrderList;
import pos.model.vo.Seat;

public class ClientResponse {

	public void displayError(String error) 
	{
		switch(error)
		{
		case "select":
			System.out.println("비어있는 테이블");
			break;
		case "insert":
			
			break;
		case "delete":
			
			break;
		case "update":
			
			break;
		}

	}

	public void seatView(Seat seat) 
	{
		System.out.println(seat);
	}

	

	

	public void insertOrderListView() 
	{
		System.out.println("orderList insert 완료");
		
	}


	public void orderListView(ArrayList<OrderList> list) {
		
		for(OrderList ol : list)
		{
			System.out.println(ol);
		}
	}

	
}
