package pos.controller;

import pos.model.service.PosService;
import pos.model.vo.MenuOrder;
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
			System.out.println("메뉴가 추가 되었습니다.");
		}
		else
		{
			cr.error("insert");
		}
	}

}
