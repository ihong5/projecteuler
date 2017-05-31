package net.inkihong.project.euler.util;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private int start;
	
	private List<Integer> chain;
	
	public Node(int start) {
		this.start = start;
		chain = new ArrayList<Integer>();
		chain.add(start);
	}

	public List<Integer> getChain() {
		return chain;
	}

	public void setChain(List<Integer> chain) {
		this.chain = chain;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
}
