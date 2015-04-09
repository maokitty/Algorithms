package t.basicDataStruct;

import junit.framework.Assert;

import org.junit.Test;

import s.basicDataStruct.MyQueue;

public class MyQueueTest {
	@Test
	public void testEnqueue(){
		MyQueue myQueue=new MyQueue(new int[3]);
		myQueue.enqueue(1);
		myQueue.enqueue(2);
	}
	@Test
	public void testDequeue(){
		MyQueue myQueue=new MyQueue(new int[3]);
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		Assert.assertEquals(1,myQueue.dequeue());
		Assert.assertEquals(2,myQueue.dequeue());
	}
@Test
public void testEmpty(){
	MyQueue myQueue=new MyQueue(new int[3]);
	myQueue.enqueue(1);
	myQueue.enqueue(2);
	myQueue.dequeue();
	myQueue.dequeue();
	Assert.assertEquals(true,myQueue.isEmpty());
}

@Test
public void testFull(){
	MyQueue myQueue=new MyQueue(new int[3]);
	myQueue.enqueue(1);
	myQueue.enqueue(2);
	Assert.assertEquals(true,myQueue.isFull());
}
@Test
public void testFull2(){
	MyQueue myQueue=new MyQueue(new int[3]);
	myQueue.enqueue(1);
	myQueue.enqueue(2);
	Assert.assertEquals(1,myQueue.dequeue());
	myQueue.enqueue(3);
	Assert.assertEquals(true,myQueue.isFull());
}
}
