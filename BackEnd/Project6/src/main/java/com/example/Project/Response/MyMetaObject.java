package com.example.Project.Response;

public class MyMetaObject {
	private int totalItems;
	private int pageSize;
	private int currentPage;
	private int totalPage;
	public MyMetaObject() {
	}
	public MyMetaObject(int totalItems, int pageSize, int currentPage, int totalPage) {
		super();
		this.totalItems = totalItems;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
