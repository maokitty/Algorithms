package t.basicDataStruct;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import s.binarySearchTree.MyBinarySearchTree;

public class BinarySearchTreeTest {

	@Test
	public void testInsertAndPrint() {
		MyBinarySearchTree t=new MyBinarySearchTree();
		t.insert(15);
		t.insert(5);
		t.insert(16);
		t.insert(3);
		t.insert(12);
		t.insert(10);
		t.insert(13);
		t.insert(6);
		t.insert(7);
		t.insert(20);
		t.insert(18);
		t.insert(23);
		t.treeWalk(t.getRoot(), 0);
		System.out.println("****************************");
	}
    @Test 
    public void testMinimunAndMaxmun(){
    	MyBinarySearchTree t=new MyBinarySearchTree();
		t.insert(15);
		t.insert(5);
		t.insert(16);
		t.insert(3);
		t.insert(12);
		t.insert(10);
		t.insert(13);
		t.insert(6);
		t.insert(7);
		t.insert(20);
		t.insert(18);
		t.insert(23);
		Assert.assertEquals(23, t.maximun(t.getRoot()).getValue());
		Assert.assertEquals(3, t.minimum(t.getRoot()).getValue());
		System.out.println("****************************");
    }
    @Test
    public void testDeleteNullAndNoChild(){
    	MyBinarySearchTree t=new MyBinarySearchTree();
		t.insert(15);
		t.insert(5);
		t.insert(16);
		t.insert(3);
		t.insert(12);
		t.insert(10);
		t.insert(13);
		t.insert(6);
		t.insert(7);
		t.insert(20);
		t.insert(18);
		t.insert(23);
		Assert.assertNull(t.delete(11));
		Assert.assertEquals(7, t.delete(7).getValue());
		System.out.println("after delete 7 :");
		t.treeWalk(t.getRoot(), 0);
		System.out.println("****************************");
    }
    @Test
    public void deleteRoot(){
    	MyBinarySearchTree t=new MyBinarySearchTree();
		t.insert(15);
		t.insert(5);
		t.insert(16);
		t.insert(3);
		t.insert(12);
		t.insert(10);
		t.insert(13);
		t.insert(6);
		t.insert(7);
		t.insert(20);
		t.insert(18);
		t.insert(23);
//		这里我范了一个错误，由于删除当要删除的节点有两个子节点的时候，返回的元素是后继元素
		Assert.assertEquals(16, t.delete(15).getValue());
		System.out.println("after delete root 15:");
		t.treeWalk(t.getRoot(), 0);
		System.out.println("****************************");
    }
    @Test
    public void deleteElementWithLeftChild(){
    	MyBinarySearchTree t=new MyBinarySearchTree();
		t.insert(15);
		t.insert(5);
		t.insert(16);
		t.insert(3);
		t.insert(12);
		t.insert(10);
		t.insert(13);
		t.insert(6);
		t.insert(7);
		t.insert(20);
		t.insert(18);
		t.insert(23);
		t.insert(17);
		System.out.println("before delete 18 :");
		t.treeWalk(t.getRoot(), 0);
		Assert.assertEquals(18, t.delete(18).getValue());
		System.out.println("after delete 18 :");
		t.treeWalk(t.getRoot(), 0);
		System.out.println("****************************");
    }
    @Test
    public void deleteElementWithRightChild(){
    	MyBinarySearchTree t=new MyBinarySearchTree();
    	t.insert(15);
    	t.insert(5);
    	t.insert(16);
    	t.insert(3);
    	t.insert(12);
    	t.insert(10);
    	t.insert(13);
    	t.insert(6);
    	t.insert(7);
    	t.insert(20);
    	t.insert(18);
    	t.insert(23);
    	
    	Assert.assertEquals(6, t.delete(6).getValue());
    	System.out.println("after delete 6 :");
    	t.treeWalk(t.getRoot(), 0);
    	System.out.println("****************************");
    }
    @Test
    public void deleteElementWithTwoChild(){
    	MyBinarySearchTree t=new MyBinarySearchTree();
    	t.insert(15);
    	t.insert(5);
    	t.insert(16);
    	t.insert(3);
    	t.insert(12);
    	t.insert(10);
    	t.insert(13);
    	t.insert(6);
    	t.insert(7);
    	t.insert(20);
    	t.insert(18);
    	t.insert(23);
    	
    	Assert.assertEquals(6, t.delete(5).getValue());
    	System.out.println("after delete 5 :");
    	t.treeWalk(t.getRoot(), 0);
    	System.out.println("****************************");
    }
}
