package com.example.basic.graph;

import java.util.Arrays;

public class GraphA {
	
	// complexity O(n2)

	/*-
	 * un-directed Graph
	 * 0 -> 1
	 * 0 -> 3
	 * 1 -> 2
	 * 3 -> 4 
	 */

	protected boolean undirected;
	protected int[][] matrix;

	public GraphA(int n, boolean undirected) {
		this.matrix = new int[n][n];
		this.undirected = undirected;
	}

	public void addEdge(int i, int j) {
		matrix[i][j] = 1;
		if (this.undirected) {
			matrix[j][i] = 1;
		}
	}
	
	public void print() {
		for(int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	

}
