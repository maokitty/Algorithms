package s.binarySearchTree;

import domain.BinarySearchTreeElement;

/**
 * 这里没有测试存在相同元素的情况
 * @author wangchunli
 *
 */
public class MyBinarySearchTree {
private BinarySearchTreeElement root=null;
public BinarySearchTreeElement getRoot() {
	return root;
}
public void setRoot(BinarySearchTreeElement root) {
	this.root = root;
}
public void insert(int z){
	BinarySearchTreeElement rootOfz=null;
	BinarySearchTreeElement x=root;
	BinarySearchTreeElement temp=new BinarySearchTreeElement(z);
	while(x!=null){
		rootOfz=x;
		if(temp.getValue()<x.getValue()){
			x=x.getLeft();
		}else{
			x=x.getRight();
		}
	}
	temp.setP(rootOfz);
	if(rootOfz==null){
		root=temp;
	}else{
		if(temp.getValue()<rootOfz.getValue()){
			rootOfz.setLeft(temp);
		}else{
			rootOfz.setRight(temp);
		}
	}
}
/**
 * 非递归版本的查找
 * @param k 要查找的元素
 */
public BinarySearchTreeElement search(int k){
	BinarySearchTreeElement temp=root;
	while(temp!=null && k!=temp.getValue()){
		if(k<temp.getValue()){
			temp=temp.getLeft();
		}else{
			temp=temp.getRight();
		}
	}
	return temp;
}
/**
 * 返回子树中最小的元素
 * @param temp
 * @return
 */
public BinarySearchTreeElement minimum(BinarySearchTreeElement temp){
	while(temp!=null && temp.getLeft()!=null){
		temp=temp.getLeft();
	}
	return temp;
}
/**
 * 找到一个元素的后继元素
 * @param temp
 * @return
 */
private BinarySearchTreeElement successor(BinarySearchTreeElement temp){
	if(temp.getRight()!=null){
		return minimum(temp.getRight());
	}
	BinarySearchTreeElement y=temp.getP();
	while(y!=null && temp==y.getRight()){
		temp=y;
		y=y.getP();
	}
	return y;
}
/**
 * 返回子树中最大的元素
 * @param temp
 * @return
 */
public BinarySearchTreeElement maximun(BinarySearchTreeElement temp){
	while(temp!=null && temp.getRight()!=null){
		temp=temp.getRight();
	}
	return temp;
}
/**
 * 删除值
 * @param k
 * @return 返回被删除的节点，当删除值所在的节点不存在时，控制台输出元素不存在
 * <p>当删除值所在节点没有子女节点时或有一个子节点，直接删除这个节点，返回的是要删除的元素
 * <p>当删除值所在节点有两个子女节点时，返回的是其后继节点（当然这个值被保存在了该删除元素的位置）
 */
public BinarySearchTreeElement delete(int k){
	BinarySearchTreeElement temp=search(k);
	if(temp==null){
		System.out.println("要删除的"+k+"不存在");
		return null;
	}
	BinarySearchTreeElement y=null;
	if(temp.getLeft()==null || temp.getRight()==null){
		y=temp;
	}else{
		y=successor(temp);
	}
	BinarySearchTreeElement x=null;
	if(y.getLeft()!=null){
		x=y.getLeft();
	}else{
		x=y.getRight();
	}
	if(x!=null){
		x.setP(y.getP());
	}
	if(y.getP()==null){
		root=x;
	}else if(y.getP().getLeft()==y){
		y.getP().setLeft(x);
	}else{
		y.getP().setRight(x);
	}
	if(y!=temp){
		temp.setValue(y.getValue());
	}
	return y;
}
/**
 *采用前序遍历的方式输出树的结构 
 * @param temp
 * @param Indentation
 */
private final String HEAD_FLAG="*";
private final String SPACE="--";
public void treeWalk(BinarySearchTreeElement temp,int indentation){
	if(temp!=null){
		if(temp==root){
			System.out.println(HEAD_FLAG+temp.getValue());
		}else{
			System.out.print("|");
			for(int i=0;i<indentation;i++)
			{
				if(i==indentation/2){
//					这里就算 left为空也没关系，只是不等而已，然后P是一定存在的，因为root不会跑到这里来的
					if(temp==temp.getP().getLeft()){
						System.out.print("L");
					}else{
						System.out.print("R");
					}
				}
				System.out.print(SPACE);
			}
			System.out.println(temp.getValue());
		}
//		这里犯了一个错误，我刚开始用的是 identation++这个会影响identation本身的值，打印不出我想要的树结构 
		treeWalk(temp.getLeft(),indentation+2);
		treeWalk(temp.getRight(),indentation+2);
	}else if(temp==root){
//		这里面范了一个错误，由于我用的是循环输出的方式，所以到最后一定会有为null的情况出现
//		所以，必须有一个判断说明 是不是根才能下结论说树为空
		System.out.println("树为空");
	}
}
}
