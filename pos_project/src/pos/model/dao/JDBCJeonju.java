package pos.model.dao;

//import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import pos.model.vo.MenuOrder;

import static common.JDBCTemplate.*;

public class JDBCJeonju {

	public int selectMenuPrice(Connection conn, String menu) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int price = 0;
		Properties prop = new Properties();
		
		try 
		{
			prop.load(new FileReader("query.properties"));
			
			String query = prop.getProperty("selectMenuPrice");
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, menu);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				price = rset.getInt("price");
			}
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
			close(rset);
		}
		return price;
	}

	public int insertOrderMenu(Connection conn, MenuOrder menuOrder) 
	{
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		try 
		{
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("insertMenuOrder");
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, menuOrder.getTableNum());
			pstmt.setInt(2, menuOrder.getPrice());
			pstmt.setString(3, menuOrder.getMenu());
			
			result = pstmt.executeUpdate();
			
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
		}
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}