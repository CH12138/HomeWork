package exception_demo;

public class IllegalAgeException extends Exception{
	
	private String errorMsg;  //错误消息 
	private String errorCode; //错误码 
	
	public String getErrorMsg() {
		return errorMsg;
	}



	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}



	public String getErrorCode() {
		return errorCode;
	}



	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}



	public IllegalAgeException(String message) {
		super(message);
	}
	
	public IllegalAgeException(String message,String errorCode) {
		super(message);
		//给本类的属性赋值
		this.errorMsg=message;
		this.errorCode=errorCode;
	}
}
