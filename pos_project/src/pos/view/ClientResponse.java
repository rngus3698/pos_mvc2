package pos.view;

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

	
}
