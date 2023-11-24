package com.example.Project.Response;

import java.util.List;

import com.example.Project.Auth.AuthenticationResponse;

public class MyDataObject<T> {
	private List<T> data;

	public MyDataObject() {
		super();
	}

	public MyDataObject(List<T> data) {
		super();
		this.data = data;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MyDataObject [data=" + data + "]";
	}
	
	

}
