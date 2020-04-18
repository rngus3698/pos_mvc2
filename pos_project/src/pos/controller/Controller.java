package pos.controller;

import java.util.ArrayList;

import pos.model.service.PosService;
import pos.model.vo.MenuOrder;
import pos.model.vo.OrderList;
import pos.model.vo.Seat;
import pos.view.ClientResponse;

public class Controller {

	ClientResponse cr = new ClientResponse();
	
	public int selectMenuPrice(String menu) 
	{
		PosService ps = new PosService();
		
		return ps.selectMenuPrice(menu);
		
	}

	public void insertOrder(MenuOrder menuOrder) 
	{
		PosService ps = new PosService();
		
		int result = ps.insertMenuOrder(menuOrder);
		
		
		
		if(result > 0)
		{
			cr.alert("order");
		}
		else
		{
			cr.error("insert");
		}
	}

	public void selectTable(int tableNum) 
	{
		PosService ps = new PosService();
		
		Seat seat = ps.selectTable(tableNum);
		
		if(seat == null)
		{
			cr.error("select");
		}
		else
		{
			cr.seatView(seat);
		}
		
	}

	public void deleteTable(int tableNum) 
	{
		PosService ps = new PosService();
		
		int result = ps.deleteTable(tableNum);
		
		if(result > 0)
		{
			cr.deleteView(tableNum);
		}
		else
		{
			cr.error("delete");
		}
	}

	public void insertOrderList(MenuOrder menuOrder) 
	{
		PosService ps = new PosService();
		
		int result = ps.insertOrderList(menuOrder);
		
		if(result > 0)
		{
			cr.insertOrderListView();
		}
		else
		{
			cr.error("insert");
		}
	}

	public void selectOrderList() {
		PosService ps = new PosService();
		
		ArrayList<OrderList> list = ps.selectOrderList();
		
		if(list.isEmpty())
		{
			System.out.println("조회 실패");
		}
		else
		{
			cr.orderListView(list);
		}
		
		
	}

}
