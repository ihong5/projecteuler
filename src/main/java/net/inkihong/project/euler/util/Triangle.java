package net.inkihong.project.euler.util;

public class Triangle {
	
	private TriNode root;
	
	public TriNode getRoot() {
		return root;
	}

	public void setRoot(TriNode root) {
		this.root = root;
	}

	// use this method when parent is left most parent
	public void addChildren(TriNode parent, int lv, int rv) {
		TriNode leftChild = new TriNode(lv),
				rightChild = new TriNode(rv);
		
		parent.leftChild = leftChild;
		parent.rightChild = rightChild;
		
		leftChild.rightSibling = parent.rightChild;
		rightChild.leftSibling = parent.leftChild;
	}
	
	// use this method when parent is not left most parent
	public void addChildren(TriNode parent, int rv) {
		TriNode sibling = parent.leftSibling;
		TriNode leftChild = sibling.rightChild;
		TriNode rightChild = new TriNode(rv);
		
		parent.leftChild = leftChild;
		parent.rightChild = rightChild;
		
		leftChild.rightSibling = rightChild;
		rightChild.leftSibling = leftChild;
	}
}
