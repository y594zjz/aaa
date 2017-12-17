package staTest;

class Root{
	static {
		System.out.println("Root的静态初始化块");
	}
	{
		System.out.println("Root的普通初始化块");
	}
	public Root() {
		System.out.println("Root的无参数构造器");
	}
}

class Mid extends Root{
	static {
		System.out.println("Mid的静态初始化块");
	}
	{
		System.out.println("Mid的普通初始化块");
	}
	public Mid() {
		System.out.println("Mid的无参数的构造器");
	}
	public Mid(String msg) {
		//调用同类中无参构造器
		this();
		System.out.println("Mid的带参数构造器，其参数值为："+msg);
	}
}

class Leaf extends Mid{
	static {
		System.out.println("Leaf的静态初始化块");
	}
	{
		System.out.println("Leaf的普通初始化块");
	}
	public Leaf() {
		super("zhang");
		System.out.println("执行Leaf的构造器");
	}
}

public class TestLeaf {
	
	public static void main(String args[]) {
		new Leaf();
	}
	
}
