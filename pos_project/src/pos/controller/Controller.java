package pos.controller;

import pos.model.service.PosService;
import pos.model.vo.MenuOrder;
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

}
