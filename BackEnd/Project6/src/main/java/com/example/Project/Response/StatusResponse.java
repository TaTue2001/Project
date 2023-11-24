package com.example.Project.Response;

public enum StatusResponse {
	SUCCESS(true, "000000", ""),
	PARAMETER_OUT_OF_RANGE(false, "40001", "PARAMETER_OUT_OF_RANGE"),
	REQUIRED_NOT_PROVIDED(false, "40002", "REQUIRED_NOT_PROVIDED"),
	DATA_ALREADY_EXISTS(false, "40003", "DATA_ALREADY_EXISTS"),
	DATA_EXCEEDS_LIMIT(false, "40004", "DATA_EXCEEDS_LIMIT"),
	CHANGE_DATA_NOT_NEW(false, "40005", "CHANGE_DATA_NOT_NEW"),
	ASSOCIATED_SERVICE_IS_OUT_OF_ORDER(false, "40006", "ASSOCIATED_SERVICE_IS_OUT_OF_ORDER"),
	CREATE_DATA_ERROR(false, "40007", "CREATE_DATA_ERROR"), DATA_NOT_EXIST(false, "40021", "DATA_NOT_EXIST"),
	DATA_HAS_BEEN_CONFIRMED(false, "40031", "DATA_HAS_BEEN_CONFIRMED"),
	ILLEGAL_ENTERACCOUNT_ACTION(false, "40032", "ILLEGAL_ENTERACCOUNT_ACTION"),
	ILLEGAL_CANCELACCOUNT_ACTION(false, "40033", "ILLEGAL_CANCELACCOUNT_ACTION"),
	BATCH_ADD_FAIL(false, "40034", "BATCH_ADD_FAIL"), ILLEGAL_MODIFY_ACTION(false, "40061", "ILLEGAL_MODIFY_ACTION"),
	CANCEL_DATA_NOT_EXIST(false, "40071", "CANCEL_DATA_NOT_EXIST"),
	ILLEGAL_DELETE_ACTION(false, "40072", "ILLEGAL_DELETE_ACTION"),
	UPLOAD_FILE_ANALYSIS_FAIL(false, "40081", "UPLOAD_FILE_ANALYSIS_FAIL"),
	UPLOAD_FILE_DATA_IS_EMPTY(false, "40082", "UPLOAD_FILE_DATA_IS_EMPTY"),
	UPLOAD_FILE_DATA_EXCEEDS_LIMIT(false, "40083", "UPLOAD_FILE_DATA_EXCEEDS_LIMIT"),
	SCHEDULE_TASK_CODE_UNDEFINED(false, "40091", "SCHEDULE_TASK_CODE_UNDEFINED"),
	SCHEDULE_TASK_CODE_ERROR(false, "40092", "SCHEDULE_TASK_CODE_ERROR"),
	PERMISSIONS_ERROR(false, "403", " PERMISSIONS_ERROR"),

	UNKNOW(false, "500", "UNKNOW");
	
	
    public boolean success =true;
    public String errorCode = "";
    public String errorMessage = "";


    StatusResponse(boolean success, String errorCode, String errorMessage) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
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


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
}

