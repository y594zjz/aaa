package myException;

import java.util.Scanner;

public class Test {

	public void regist(int num) throws MyException{
		if(num<0)
			throw new MyException("人数不能为负",3);
		else
			System.out.println("登记人数"+num);
	}
	
	public void manager() {
		System.out.println("请输入人数");
		//键盘输入
		Scanner in=new Scanner(System.in);
		try {
			regist(in.nextInt());
		}catch(MyException e){
			System.out.println("登记失败，出错种类为"+e.getId());
		}
		System.out.println("本次登记结束");
	}
	
	public static void main(String args[]) {
		Test t=new Test();
		t.manager();
	}
	
}
