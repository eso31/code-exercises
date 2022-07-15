package com.cracking.coding.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GraphNode {
    int data;
    boolean visited;
    List<GraphNode> children;

    public GraphNode(int data) {
        this.data = data;
        this.visited = false;
        this.children = new ArrayList<>();
    }

    public void addChildren(GraphNode... nodes) {
        this.children.addAll(Arrays.asList(nodes));
    }

    @Override
    public String toString() {
        return "data=" + this.data + " children: " + this.children.stream()
                .map(graphNode -> graphNode.data)
                .collect(Collectors.toList());
    }
}
