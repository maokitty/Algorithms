package s.basicDataStruct;

/**
 * 这个队列的所有数组是不能装满的，即，如果数组的长度是3，那么队列中只会存在两个数
 * (这点切记，因为我就忽略了这点，在测试时一直以为能够插入3个数，但是一直报错，但实际上是我理解的错，代码本身上是正确的
 * 因为本来就只能放2个数，而我放了3个数，那么当然不能通过测试，代码本身的反应是正确的)
 * @author wangchunli
 *
 */
public class MyQueue {
private int[] Q;
private int head=0;
private int tail=0;
public boolean isEmpty(){
	return head==tail;
}
public boolean isFull(){
//	错误写法1 return head== tail+1; 由于是从0开始的下标，这里错在第一轮循环末尾，即head ==0 tail==Q.length-1时
//		应该是满了的
	return head==(tail+1)%Q.length;
}
public MyQueue(int[] Q){
	this.Q=Q;
}
public void enqueue(int x){
	if(isFull()){
		throw new Error("队列上溢");
	}
	Q[tail]=x;
	if(tail==Q.length){
		tail=0;
	}else{
		tail++;
	}
}
public int dequeue(){
	if(isEmpty()){
		throw new Error("队列下溢");
	}
	int x=Q[head];
	if(head==Q.length){
		head=0;
	}else{
		head++;
	}
	return x;
}
}
