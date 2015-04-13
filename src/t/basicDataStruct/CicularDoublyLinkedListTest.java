package t.basicDataStruct;

import junit.framework.Assert;

import org.junit.Test;

import s.basicDataStruct.CicularDoublyLinkedList;

public class CicularDoublyLinkedListTest {

	@Test
	public void testEmpty(){
		CicularDoublyLinkedList l=new CicularDoublyLinkedList();
        Assert.assertEquals(true, l.isEmpty());		
	}
	@Test
	public void testInsertAndPrint() {
		CicularDoublyLinkedList l=new CicularDoublyLinkedList();
		l.insert(1);
		l.insert(2);
		l.print();
	}
	@Test
	public void testSearch(){
		CicularDoublyLinkedList l=new CicularDoublyLinkedList();
		l.insert(1);
		l.insert(2);
		Assert.assertEquals(2, l.search(2).getValue());
//		这个在测试的时候我刚开始用得语句是:Assert.assertNull(l.search(3).getValue());
//		我的语义上得理解是 nil刚开始是没有赋值的，而实际上，由于value的类型是int，所以会自动赋值为0
//		从语义上来讲，这是行不通的，因为如果这个值恰好是0的话，就合语义对不上了，应该返回 null比较好，在搜索不到的时候
		Assert.assertNull(l.search(0));
	}
    @Test 
    public void testDelete(){
    	CicularDoublyLinkedList l=new CicularDoublyLinkedList();
		l.insert(1);
		l.insert(2);
		System.out.println("before delete:");
		l.print();
		System.out.println("after delete:");
		l.delete(2);
		l.print();
		l.delete(4);
		l.delete(1);
		Assert.assertEquals(true, l.isEmpty());
    }
}
