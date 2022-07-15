package com.cracking.coding.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    List<GraphNode> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void addNodes(GraphNode... graphNodes) {
        this.nodes.addAll(Arrays.asList(graphNodes));
    }
}
