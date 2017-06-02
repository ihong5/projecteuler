package net.inkihong.project.euler.util;

public class TriNode {
	
	private int value;
	
	private TriNode leftChild, rightChild, leftSibling, rightSibling;
	
	public TriNode getLeftSibling() {
		return leftSibling;
	}

	public void setLeftSibling(TriNode leftSibling) {
		this.leftSibling = leftSibling;
	}

	public TriNode getRightSibling() {
		return rightSibling;
	}

	public void setRightSibling(TriNode rightSibling) {
		this.rightSibling = rightSibling;
	}

	public TriNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TriNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TriNode leftChild) {
		this.leftChild = leftChild;
	}

	public TriNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TriNode rightChild) {
		this.rightChild = rightChild;
	}
}
