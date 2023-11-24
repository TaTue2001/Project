package com.example.Project.Response;

import java.util.List;

public class ResponseAPI<T>{
	private boolean success;
	private String errorCode;
	private String message;
	private StatusResponse status;
	private MyDataObject<T>  data;
	private MyMetaObject meta;

	public ResponseAPI() {
	}

	public ResponseAPI(StatusResponse status, MyDataObject<T> data, MyMetaObject meta) {
		this.success=status.success;
		this.errorCode=status.errorCode;
		this.message=status.errorMessage;
		this.status = status;
		this.data=data;
		this.meta = meta;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StatusResponse getStatus() {
		return status;
	}

	public void setStatus(StatusResponse status) {
		this.status = status;
	}
	public MyDataObject<T> getData() {
		return data;
	}

	public void setData(MyDataObject<T> data) {
		this.data = data;
	}

	public MyMetaObject getMeta() {
		return meta;
	}

	public void setMeta(MyMetaObject meta) {
		this.meta = meta;
	}

	@Override
	public String toString() {
		return "ResponseAPI [success=" + success + ", errorCode=" + errorCode + ", message=" + message + ", data="
				+ data + ", meta=" + meta + "]";
	}
}
