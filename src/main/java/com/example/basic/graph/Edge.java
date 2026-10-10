package com.example.basic.graph;

public class Edge {
	private Vertex startVertex;
	private Vertex endVertex;

	// wight graph
	private Integer weight;

	public Edge(Vertex startVertex, Vertex endVertex, Integer inputWeight) {
		super();
		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.weight = inputWeight;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public Vertex getEndVertex() {
		return endVertex;
	}

	public Integer getWeight() {
		return weight;
	}

}
