package t.basicDataStruct;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import s.basicDataStruct.MyBidirectionalList;

public class MyBidirectionalListTest {

	@Test
	public void testEmpty() {
		MyBidirectionalList l=new MyBidirectionalList();
		Assert.assertEquals(true, l.isEmpty());
	}
    @Test
    public void testInsertAndPrint(){
    	MyBidirectionalList l=new MyBidirectionalList();
    	l.insert(1);
    	l.insert(2);
    	l.print();
    }
    @Test
    public void testSearch(){
    	MyBidirectionalList l=new MyBidirectionalList();
    	l.insert(1);
    	l.insert(2);
    	l.insert(3);
    	Assert.assertEquals(true, l.search(2).getValue()==2);
    	Assert.assertNull(l.search(4));
    }
    @Test
    public void testDelete(){
    	MyBidirectionalList l=new MyBidirectionalList();
    	l.insert(1);
    	l.insert(2);
    	l.insert(3);
    	l.insert(4);
    	System.out.println("before delete:");
    	l.print();
    	l.delete(3);
    	System.out.println("after delete:");
    	l.print();
    	l.delete(5);
    }
}
