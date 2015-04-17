package domain;

public class BinarySearchTreeElement {
 private int value;
 private BinarySearchTreeElement left;
 private BinarySearchTreeElement right;
 private BinarySearchTreeElement p;
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public BinarySearchTreeElement getLeft() {
	return left;
}
public void setLeft(BinarySearchTreeElement left) {
	this.left = left;
}
public BinarySearchTreeElement getRight() {
	return right;
}
public void setRight(BinarySearchTreeElement right) {
	this.right = right;
}
public BinarySearchTreeElement getP() {
	return p;
}
public void setP(BinarySearchTreeElement p) {
	this.p = p;
}
public BinarySearchTreeElement(int value) {
	super();
	this.value = value;
}
public BinarySearchTreeElement() {
	super();
	// TODO Auto-generated constructor stub
}

}
