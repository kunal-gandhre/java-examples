package com.example.basic.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Complexity O(v + e)
 */
public class GraphAdjListBSF extends GraphAdjList {

	GraphAdjListBSF(int n, boolean underiected) {
		super(n, underiected);
	}

	private void bfsCore(int source, boolean[] visited) {
		if (visited[source] == false) {
			visited[source] = true;

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(source);

			while (queue.size() > 0) {
				System.out.println(queue.peek());
				int top = queue.poll();
				List<Integer> neighbors = super.adjList.get(top);
				for (Integer neighbor : neighbors) {
					if (visited[neighbor] == false) {
						visited[neighbor] = true;
						queue.add(neighbor);
					}
				}
			}
		}
	}
	
	public void bsf() {
		boolean[] visited = new boolean[super.adjList.size()];
		Arrays.fill(visited, false);
		for (int i = visited.length -1 ; i >= 0; i--) {
			if (visited[i] == false) {
				bfsCore(i, visited);
			}
		}
	}

}
