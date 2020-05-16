package exception_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 声明异常  ，throws跟在方法名的后面，可以声明多个 
 *  访问修饰符  返回值类型   方法名（参数列表）  throws 异常1，异常2...{
 *  
 *  }
 *  
 *  1. 不管声明了哪种异常类型，抛出的异常，方法本身并没有处理，而是留给了调用者去处理。  
 *  2.  try-catch积极的处理方式，积极捕获，  throws消极的处理方式，就是没处理，才选择上抛 
 *  3. 对于方法抛出的异常，调用者仍旧是由2种方式，可以继续选择上抛，也可以进行try-catch捕获  
 *     对于层层上抛的异常，最终由jvm来处理。 
 *  4.对于层层上抛的异常，一定要有1个处理者，一旦某个处理者进行了try-catch捕获，后续的调用者就不需要再处理。  
 *  
 * @author Administrator
 *
 */
public class Test1 {

	/**
	 * 声明了2个不可查的异常，运行异常的子类（非受查异常）
	 * @throws ArithmeticException
	 * @throws InputMismatchException
	 */
	public void method1() throws ArithmeticException, InputMismatchException{
		Scanner input = new Scanner(System.in);
		System.out.print("请输入被除数：");
		int num1 = input.nextInt();
		System.out.print("请输入除数：");
		int num2 = input.nextInt();  
		int result = num1/num2;
		System.out.println("商为："+result);
	}
	/**
	 * method2()作为调用者没有处理
	 * @throws ArithmeticException
	 * @throws InputMismatchException
	 */
	public void method2() throws ArithmeticException, InputMismatchException{
		method1();
	}
	/**
	 * method3()作为调用者选择了处理
	 */
	public void method3(){
		try{
			method1();
		}catch(ArithmeticException e){
			e.printStackTrace();
			System.out.println("除数不能为0!");
		}catch(InputMismatchException e){
			e.printStackTrace();
			System.out.println("除数或者被除数只能是数字！");
		}
	}

}
