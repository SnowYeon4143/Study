package com.kh.app12.menu.model.vo;

public class MenuVo {
	private String menu;
	private int price;
	
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
	
	@Override
	public String toString() {
		return "MenuVo [menu=" + menu + ", price=" + price + "]";
	}
	
}
