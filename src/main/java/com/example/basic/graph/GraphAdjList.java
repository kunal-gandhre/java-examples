package com.example.basic.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Complexity O(v + e)
 */

public class GraphAdjList {
	
	protected boolean undirected;
	protected List<List<Integer>> adjList;
	
	GraphAdjList(int n, boolean underiected){
		this.undirected = underiected;
		adjList = new ArrayList<List<Integer>>(n);
		int t = 0;
		while(t < n) {
			ArrayList<Integer> list = new ArrayList<>(n);
			adjList.add(list);
			t++;
		}
	}
	
	public void addEdge(int i, int j) {
		adjList.get(i).add(j);
		if(undirected) {
			adjList.get(j).add(i);
		}
	}
	
	public void print() {
		for(List<Integer> list : adjList) {
			System.out.println(list.toString());
		}
	}

}
