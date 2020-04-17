package pos.model.vo;

import java.io.Serializable;

public class Seat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1303130812779922197L;
	
	private String orderDate;
	private int tableNum;
	private int price;
	
	
	public Seat() {
		super();
	}
	
	public Seat(String orderDate, int tableNum, int price) {
		super();
		this.orderDate = orderDate;
		this.tableNum = tableNum;
		this.price = price;
	}
	
	
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		return "Seat [orderDate=" + orderDate + ", tableNum=" + tableNum + ", price=" + price + "]";
	}
	
	

}
