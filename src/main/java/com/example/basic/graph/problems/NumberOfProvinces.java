package com.example.basic.graph.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

	/*-
	 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
	
	A province is a group of directly or indirectly connected cities and no other cities outside of the group.
	
	You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
	
	Return the total number of provinces.
	
	Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
	Output: 2
	
	Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
	Output: 3
	
	Constraints:	
	1 <= n <= 200
	n == isConnected.length
	n == isConnected[i].length
	isConnected[i][j] is 1 or 0.
	isConnected[i][i] == 1
	isConnected[i][j] == isConnected[j][i]
	 */

	public static void main(String[] args) {
		int[][] input1 = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int[][] input2 = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		int[][] input3 = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };

		// System.out.println(findCircleNum(input1));
		// System.out.println(findCircleNum(input2));
		System.out.println(findCircleNum(input3));
	}

	public static int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		int count = 0;
		for (int i = 0; i < n; i++) {
			System.out.println("Not visited " + i);
			if (visited[i] == false) {
				visited[i] = true;
				count++;
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.add(i);
				while (queue.size() > 0) {
					Integer top = queue.poll();
					System.out.println(top);
					for (int j = 0; j < n; j++) {
						if (isConnected[top][j] == 1 && isConnected[j][top] == 1) {
							System.out.println("J:" + j);
							if (visited[j] == false) {
								visited[j] = true;
								queue.add(j);
							}
						}
					}
				}

			}

		}

		return count;

	}
}
