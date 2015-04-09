package t.basicDataStruct;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import s.basicDataStruct.MyQueue;

public class JunitTest {
	private MyQueue myQueue;
   @Before
   public void setup(){
	   myQueue=new MyQueue(new int[4]);
   }
	@Test
	public void test() {
		myQueue.enqueue(1);
		//这里入队了，但是却没有在下面获得数据。。。
		Assert.assertEquals(false, myQueue.isEmpty());
	}
   @Test
   public void testNull(){
	   Assert.assertEquals(true, myQueue.isEmpty());
   }
}
