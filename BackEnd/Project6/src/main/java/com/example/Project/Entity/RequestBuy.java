package com.example.Project.Entity;

public class RequestBuy {
	private Line line;
	private Order order;
	public RequestBuy() {
	}
	public RequestBuy(Line line, Order order) {
		super();
		this.line = line;
		this.order = order;
	}
	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
