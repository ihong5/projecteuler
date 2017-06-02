package net.inkihong.project.euler.util;

public class Triangle {
	
	private TriNode root;
	
	public Triangle(int value, int lv, int rv) {
		this.root = new TriNode(value);
		
		addChildren(this.root, lv, rv);
	}
	
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
		
		parent.setLeftChild(leftChild);
		parent.setRightChild(rightChild);
		
		leftChild.setRightSibling(rightChild);
		rightChild.setLeftSibling(leftChild);
	}
	
	// use this method when parent is not left most parent
	public void addChildren(TriNode parent, TriNode sibling, int rv) {
		TriNode leftChild = sibling.getRightChild(),
				rightChild = new TriNode(rv);
		
		parent.setLeftChild(leftChild);
		parent.setRightChild(rightChild);
		
		leftChild.setLeftSibling(sibling.getLeftChild());
		leftChild.setRightSibling(rightChild);
		
		rightChild.setLeftSibling(leftChild);
	}
}
