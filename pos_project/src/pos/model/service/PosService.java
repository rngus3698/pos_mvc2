package pos.model.service;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import pos.model.dao.JDBCJeonju;
import pos.model.vo.MenuOrder;

import static common.JDBCTemplate.*;

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

}
