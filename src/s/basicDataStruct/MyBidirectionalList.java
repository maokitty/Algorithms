package s.basicDataStruct;

public class MyBidirectionalList {
public class Element{
	private int value;
	private Element prev;
	private Element next;
	public int getValue() {
		return value;
	}

	public Element getPrev() {
		return prev;
	}
	public void setPrev(Element prev) {
		this.prev = prev;
	}
	public Element getNext() {
		return next;
	}
	public void setNext(Element next) {
		this.next = next;
	}
	public Element(int value) {
		super();
		this.value = value;
	}
	
}
private Element head=null;
public MyBidirectionalList(){	
}
public boolean isEmpty(){
	return head==null;
}
/*
 * 这里选择的是插到链表的前端
 */
public void insert(int x){
	Element temp=new Element(x);
	temp.setNext(head);
	if(!isEmpty()){
		head.setPrev(temp);
	}
	head=temp;
	temp.setPrev(null);
}
/**
 * 看值x是否在链表里面
 * @param x
 * @return
 */
public Element search(int x){
	Element temp=head;
	while(temp!=null && temp.getValue()!=x){
		temp=temp.getNext();
	}
	return temp;
}
/**
 * 删除值是 x的元素
 * @param x
 */
public void delete(int x){
	Element temp=search(x);
	if(temp!=null){
		if(temp.getPrev()!=null){
			temp.getPrev().setNext(temp.getNext());
		}else{
			head=temp.getNext();
		}
		if(temp.getNext()!=null){
			temp.getNext().setPrev(temp.getPrev());
		}
	}else{
		System.out.println("链表中没有值为"+x+"的元素");
	}
}
/**
 * 遍历链表
 */
public void print(){
	Element temp=head;
	while(temp!=null){
		if(temp.getNext()!=null)
		{
			System.out.print(temp.getValue()+"\t");
		}else{
			System.out.println(temp.getValue());
		}
		temp=temp.getNext();
	}
}
}
