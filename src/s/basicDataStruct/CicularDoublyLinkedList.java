package s.basicDataStruct;

import domain.Element;

/**
 * 带哨兵的双向循环列表
 * @author wangchunli
 *
 */
public class CicularDoublyLinkedList {
	//哨兵元素
private Element nil;
public CicularDoublyLinkedList(){
	nil=new Element();
	nil.setNext(nil);
	nil.setPrev(nil);
}
public boolean isEmpty(){
	return nil.getNext()==nil;
}
/**
 * 在哨兵的后面插入新的元素
 * @param x
 */
public void insert(int x){
	Element temp=new Element(x);
	temp.setNext(nil.getNext());
//	如果 x是插入的第一个元素,此时 nil.getNext就是 nil自己，它的前一个元素也就是
//	队尾的元素，这个也就衔接上了，在初始化的时候，我刚开始写得是:
//	nil.setNext(nil.getPre()) nil.setPre(nil.getNext) 这样二者循环，并没有指向nil本身
//	而刚开始的时候都是null，所以下面就会报空的错误，初始化的时候需要注意的这点。
	nil.getNext().setPrev(temp);
	nil.setNext(temp);
	temp.setPrev(nil);
}
/**
 * 
 * @param x
 * @return没有找到返回null，找到了就返回 元素的引用
 */
public Element search(int x){
//	nil.getNext 被当成头
	Element temp=nil.getNext();
	while(temp!=nil && temp.getValue()!=x){
		temp=temp.getNext();
	}
	if(temp!=nil)
	{
		return temp;
	}
	return null;
}
public void delete(int x){
	Element temp=search(x);
//	这里用存在null的判断是因为search找不到的话就返回null
	if(temp!=null){
		temp.getPrev().setNext(temp.getNext());
		temp.getNext().setPrev(temp.getPrev());
	}else{
		System.out.println("列表中不存在元素"+x);
	}
}
public void print(){
	Element temp=nil.getNext();
//	这里犯了一个错误: 我忽略了一个事实的存在，这是个循环列表，不会存在temp为空的情况
//	之前写得代码是 :temp!=null
	while(temp!=nil){
		if(temp.getNext()!=nil){
			System.out.print(temp.getValue()+"\t");
		}else{
			System.out.println(temp.getValue());
		}
		temp=temp.getNext();
	}
}
}
