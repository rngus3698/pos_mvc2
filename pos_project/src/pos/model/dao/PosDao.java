package pos.model.dao;

import static common.JDBCTemplate.close;

//import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import pos.model.vo.MenuOrder;
import pos.model.vo.OrderList;
import pos.model.vo.Seat;

public class PosDao {

	//menu테이블에서 메뉴에 해당하는 가격을 찾아옴
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

	//ORDERMENU 테이블 INSERT
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

	public Seat selectTable(Connection conn, int tableNum) 
	{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Seat seat = null;
		
		int resultPrice = 0;
		
		Properties prop = new Properties();
		
		try 
		{
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("selectMenuOrderPrice");
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, tableNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				resultPrice += rset.getInt("price");
				seat = new Seat();
				seat.setTableNum(rset.getInt("tablenum"));
				seat.setPrice(resultPrice);
			}
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
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
			close(rset);
		}
		
		return seat;
	}

	public int deleteTable(Connection conn, int tableNum) 
	{
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		try 
		{
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("deleteTable");
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, tableNum);
			
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
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
		}
		
		return result;
	}

	public int insertOrderList(Connection conn, MenuOrder menuOrder) 
	{
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		try 
		{
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("insertOrderList");
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, menuOrder.getMenu());
			pstmt.setInt(2, menuOrder.getPrice());
			
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
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
		}
		return result;
	}

	public ArrayList<OrderList> selectOrderList(Connection conn) 
	{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Properties prop = new Properties();
		
		ArrayList<OrderList> list = new ArrayList<OrderList>();
		try 
		{
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("selectOrderList");
			
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				OrderList ol = new OrderList();
				
				ol.setOrderDate(rset.getString("orderdate"));
				ol.setOrderNum(rset.getInt("ordernum"));
				ol.setMenu(rset.getString("menu"));
				ol.setPrice(rset.getInt("price"));
				
				list.add(ol);
			}
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
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
