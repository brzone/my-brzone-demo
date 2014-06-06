package junittest;


import java.lang.reflect.InvocationTargetException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Jian Lee
 * @mail   brzone@126.com
 * @date 2012-11-19 下午03:37:46
 */
public class HelloJunit extends TestCase {

	public void testSayHello() {

		System.out.println("hello Junit");
	}

	 public static Test suite() {
	       return new TestSuite(HelloJunit.class);//1
	   }

	public static void main(String[] args) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {

		junit.textui.TestRunner.run(suite());//2



	}

}
