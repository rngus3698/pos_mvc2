package pos.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import pos.model.dao.JDBCJeonju;
import pos.model.vo.MenuOrder;
import pos.model.vo.OrderList;
import pos.model.vo.Seat;

public class PosService {

	public int selectMenuPrice(String menu) {
		Connection conn = getConnection();
		JDBCJeonju jj = new JDBCJeonju();
		int price = jj.selectMenuPrice(conn, menu);
		
		close(conn);
		
		return price;
	}

	public int insertMenuOrder(MenuOrder menuOrder) 
	{
		Connection conn = getConnection();
		
		JDBCJeonju jj = new JDBCJeonju();
		
		int result = jj.insertOrderMenu(conn,menuOrder);
		
		if(result > 0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Seat selectTable(int tableNum) 
	{
		Connection conn = getConnection();
		
		JDBCJeonju jj = new JDBCJeonju();
		
		Seat seat = jj.selectTable(conn, tableNum);
		
		close(conn);
		
		return seat;
		
	}

	public int deleteTable(int tableNum) {
		Connection conn = getConnection();
		
		JDBCJeonju jj = new JDBCJeonju();
		
		int result = jj.deleteTable(conn, tableNum);
		
		if(result > 0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int insertOrderList(MenuOrder menuOrder) {
		Connection conn = getConnection();
		
		JDBCJeonju jj = new JDBCJeonju();
		
		int result = jj.insertOrderList(conn, menuOrder);
		
		if(result > 0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<OrderList> selectOrderList() {
		Connection conn = getConnection();
		
		JDBCJeonju jj = new JDBCJeonju();
		
		ArrayList<OrderList> list = jj.selectOrderList(conn);
		
		close(conn);
		
		return list;
	}

}
