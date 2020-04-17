package pos.model.vo;

import java.io.Serializable;

public class OrderList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6765754293947735548L;

	private String orderDate;
	private int orderNum;
	private String menu;
	private int price;
	
	
	public OrderList() {
		super();
	}
	
	
	public OrderList(String orderDate, int orderNum, String menu, int price) {
		super();
		this.orderDate = orderDate;
		this.orderNum = orderNum;
		this.menu = menu;
		this.price = price;
	}
	
	
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		return "OrderList [orderDate=" + orderDate + ", orderNum=" + orderNum + ", menu=" + menu + ", price=" + price
				+ "]";
	}
	
	
}

