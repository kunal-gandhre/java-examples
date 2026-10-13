package com.example.basic.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAadjList extends GraphA{

	public GraphAadjList(int n, boolean undirected) {
		super(n, undirected);
	}
	
	private void coreBSF(int entry, boolean[] visited) {
		
		if(visited[entry] == false) {
			visited[entry] = true;
			
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(entry);
			
			while(queue.size() > 0) {
				Integer top = queue.poll();
				for(int i = 0; i < matrix.length ; i++) {
					if(matrix[entry][i] == 1
							&& matrix[i][entry] == 1) {
						if (visited[i] == false) {
							visited[i] = true;
							queue.add(i);
						}
					}
				}
				System.out.println(top);
			}
			
		}
	}
	
	public void bsf() {
		boolean[] visited = new boolean[matrix.length];
		Arrays.fill(visited, false);
		for (int i = visited.length -1 ; i >= 0; i--) {
			if (visited[i] == false) {
				System.out.println("Vertex" + i);
				coreBSF(i, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		GraphAadjList graphc = new GraphAadjList(3, true);
		graphc.addEdge(0, 0);
		graphc.addEdge(1, 1);
		graphc.addEdge(2, 2);
		graphc.print();
		graphc.bsf();
	}
	
	

}
