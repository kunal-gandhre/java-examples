package com.example.basic.graph;

import java.util.ArrayList;

/**
 * 
 */
public class Graph {

	private ArrayList<Vertex> vertices;
	private boolean isWeighted;
	private boolean isDirected;

	public Graph(boolean isWeighted, boolean isDirected) {
		super();
		this.vertices = new ArrayList<Vertex>();
		this.isWeighted = isWeighted;
		this.isDirected = isDirected;
	}

	public Vertex addVertex(String data) {
		Vertex newVerTex = new Vertex(data);
		this.vertices.add(newVerTex);
		return newVerTex;
	}

	public void addEdge(Vertex v1, Vertex v2, Integer weight) {
		if (!isWeighted) {
			weight = null;
		}
		v1.addEdge(v2, weight);
		if (!this.isDirected) {
			v2.addEdge(v1, weight);
		}
	}

	public void removeEdge(Vertex vertex1, Vertex vertex2) {
		vertex1.removeEdge(vertex2);
		if (!this.isDirected) {
			vertex2.removeEdge(vertex1);
		}
	}
	
	public void removeVertex(Vertex vertex) {
		this.vertices.remove(vertex);
	}

	public ArrayList<Vertex> getVertices() {
		return vertices;
	}

	public boolean isWeighted() {
		return isWeighted;
	}

	public boolean isDirected() {
		return isDirected;
	}
	
	public Vertex getVertexValue(String value) {
		for (Vertex v: this.vertices) {
			if(v.getData().equals(value)) {
				return v;
			}
		}
		return null;
	}

	
	public void print() {
		if(vertices.isEmpty()) {
			System.out.println("Empty Graph");
		}
		for (Vertex vertex : vertices) {
			vertex.print(true);
		}
	}
}
