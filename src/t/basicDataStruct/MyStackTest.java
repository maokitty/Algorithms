package t.basicDataStruct;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import s.basicDataStruct.MyStack;

public class MyStackTest {
    private MyStack stack;
    @Before
    public void setup(){
    	stack=new MyStack(new int[4]);
    }
	@Test
	public void testPush() {
		stack.push(1);
		stack.push(2);
	}
	@Test 
	public void testPop(){
		stack.push(1);
		stack.push(3);
		stack.push(2);
		Assert.assertEquals(2, stack.pop());
	}
	@Test 
	public void testEmpty(){
		Assert.assertEquals(true, stack.stackEmpty());
	}
	@Test
	public void testFull(){
		for(int i=0;i<stack.size();i++){
			stack.push(i);
		}
		Assert.assertEquals(true, stack.stackFull());
	}
	@Test
	public void testBadPush(){
		for(int i=0;i<stack.size();i++){
			stack.push(i);
		}
//		这里可以得到栈上溢
		stack.push(4);
	}
}
