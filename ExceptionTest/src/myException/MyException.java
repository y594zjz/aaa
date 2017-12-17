package myException;

public class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idnumber;
	public MyException(String message,int id) {
		super(message);
		this.idnumber=id;
	}
	
	public int getId() {
		return idnumber;
	}
	
}
