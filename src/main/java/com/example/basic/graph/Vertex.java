package com.example.basic.graph;

import java.util.ArrayList;

public class Vertex {

	private String data;
	private ArrayList<Edge> edges;

	public Vertex(String inputData) {
		this.data = inputData;
		this.edges = new ArrayList<Edge>();
	}

	// directive graph
	public void addEdge(Vertex endVertex, Integer weight) {
		this.edges.add(new Edge(this, endVertex, weight));
	}
	
	public void removeEdge(Vertex endVertex) {
		this.edges.removeIf(edge -> edge.getEndVertex().equals(endVertex));
	}

	
	public String getData() {
		return data;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}
	
	public void print(boolean showWeight) {
		String message = "";
		
		if(this.edges.size() == 0) {
			System.out.println(this.data + " -->");
			System.out.println();
		}
	}

}
