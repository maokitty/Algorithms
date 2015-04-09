package s.basicDataStruct;
//算法导论第二版 P120页伪代码
public class MyStack {
	//存放所有的元素,栈中只存放4个
private int[] S;
// topS=0 书中<==> topS=-1代码中
private int topS=-1;
public MyStack(int[] S){
	this.S=S;
}
public int size(){
	return S.length;
}
/**
 * 
 * topS 最顶端元素在数组中得位置
 * @return true 栈为空，false 栈非空
 */
public boolean stackEmpty(){
	if(topS==-1){
//		栈为空
		return true;
	}
	return false;
}
/**
 * 
 * @return true 栈满，false 栈没满
 */
public boolean stackFull(){
	if(topS==size()-1){
		return true;
	}
	return false;
}
/**
 * 
 * @param S 存放数据的数组
 * @param x 要存放的数据
 */
public void push(int x){
	if(stackFull()){
		throw new Error("栈上溢");
	}
	topS++;
	S[topS]=x;
}
public int pop(){
	if(stackEmpty()){
		throw new Error("栈下溢");
	}
	topS--;
	return S[topS+1];
}
//错误代码示例
public void badPush(int x){
	topS++;
	if(badStackFull()){
		throw new Error("栈上溢");
	}
	S[topS]=x;
}
//错误代码示例
public boolean badStackFull(){
	if(topS==size()){
		return true;
	}
	return false;
}
}
/**
 *关于判断 栈满时 ，是否应该push？
 *看badPush badStackFull
 *
在做满的测试时，发现，按语义来讲，当我在栈中放满4个元素的时候，栈已满，所以
返回true，单按照这里的逻辑来看:此时有 topS==3（数组的下标从0到3为止，一共是4个元素）
而size()==4，所以一直返回false，这显然不符合语义，所以这个代码不好，不过，如若无视满
的这个规定的话，代码本身是可以正常运作的.

结论:1：对于一个存放类似的操作，取值前先确认是否能取？存之前是否能存？
2：注意数组的下标是从0开始的
 * 
*/