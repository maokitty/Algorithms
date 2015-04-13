package domain;

public class Element {
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
	public Element(){}
}
