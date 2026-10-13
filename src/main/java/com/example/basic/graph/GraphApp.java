package com.example.basic.graph;

public class GraphApp {

	public static void main(String[] args) {

		/*-
		 * un-directed Graph
		 * 0 -> 1
		 * 0 -> 3
		 * 1 -> 2
		 * 3 -> 4 
		 * 2 -> 3
		 */
		GraphA graph = new GraphA(5, true);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(2, 3);
		//graph.print();
		
		
		
		/*-
		 * un-directed Graph
		 * 0 -> 1
		 * 0 -> 3
		 * 1 -> 2
		 * 3 -> 4 
		 * 2 -> 3
		 */
		GraphAdjList graphB = new GraphAdjList(5, true);
		graphB.addEdge(0, 1);
		graphB.addEdge(0, 3);
		graphB.addEdge(1, 2);
		graphB.addEdge(3, 4);
		graphB.addEdge(2, 3);
		graphB.print();
		
		GraphAdjListBSF graphc = new GraphAdjListBSF(7, true);
		graphc.addEdge(0, 1);
		graphc.addEdge(0, 3);
		graphc.addEdge(1, 2);
		graphc.addEdge(6, 5);
		graphc.addEdge(3, 4);
		graphc.addEdge(2, 3);
		
		//graphc.print();
		
		//graphc.bsf();

	}

}
