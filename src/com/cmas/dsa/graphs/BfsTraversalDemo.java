package com.cmas.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

class BfsSolution {
	private int vertices;	// Number of Vertices in the Graph
	private LinkedList<Integer>[] adjacencyList;	// Adjacency List in Each of Vertices
	
	@SuppressWarnings("unchecked")
	public BfsSolution(int vertices) {
		this.vertices = vertices;	// Assign Vertices according to Constructor;
		this.adjacencyList = new LinkedList[vertices];	// Adjacency List equals to Number of Vertices
		for(int i = 0; i < vertices; i++) {
			adjacencyList[i] = new LinkedList<Integer>();	// Assigning Adjacency List to each Vertices
		}	
	}
	
	// Adding Edges to the Graph
	void addEdge(int source, int destination) {
		adjacencyList[source].add(destination);
		adjacencyList[destination].add(source);
	}
	
	// Bfs Traversal Method
	void bfsTraversal(int startVertex) {
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		visited[startVertex] = true;
		queue.add(startVertex);
		System.out.print("BFS Traversal: ");
		
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			System.out.print(vertex + " ");
			for(int neighbour : adjacencyList[vertex]) {
				if(!visited[neighbour]) {
					visited[neighbour] = true;
					queue.add(neighbour);
				}
			}
		}
	}
}

public class BfsTraversalDemo {
	public static void main(String[] args) {
		BfsSolution bfsgraph = new BfsSolution(6);
		bfsgraph.addEdge(0, 1);
		bfsgraph.addEdge(0, 2);
		bfsgraph.addEdge(1, 3);
		bfsgraph.addEdge(1, 4);
		bfsgraph.addEdge(2, 5);
		bfsgraph.bfsTraversal(0);
	}
}
