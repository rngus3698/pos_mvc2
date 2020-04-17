package pos.model.vo;

import java.io.Serializable;

public class MenuOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4433367066027175009L;
	
	private String orderDate;
	private int orderNum;
	private int tableNum;
	private int price;
	private String menu;
	
	
	public MenuOrder() {
		super();
	}
	
	
	public MenuOrder(int tableNum, int price, String menu) {
		super();
		this.tableNum = tableNum;
		this.price = price;
		this.menu = menu;
	}


	public MenuOrder(String orderDate, int orderNum, int tableNum, int price, String menu) {
		super();
		this.orderDate = orderDate;
		this.orderNum = orderNum;
		this.tableNum = tableNum;
		this.price = price;
		this.menu = menu;
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
	public int getTableNum() {
		return tableNum;
	}
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		return "MenuOrder [orderDate=" + orderDate + ", orderNum=" + orderNum + ", tableNum=" + tableNum + ", price="
				+ price + ", menu=" + menu + "]";
	}
	
	

}
