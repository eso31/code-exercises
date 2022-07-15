package com.cracking.coding.interview.graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class GraphMain {
    public static void main(String[] args) {
        Graph graph = new Graph();
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);
        GraphNode node7 = new GraphNode(7);
        GraphNode node8 = new GraphNode(8);
        GraphNode node9 = new GraphNode(9);
        GraphNode node10 = new GraphNode(10);
        GraphNode node11 = new GraphNode(11);
        GraphNode node12 = new GraphNode(12);

        node1.addChildren(node2, node3);
        node2.addChildren(node1, node7);
        node3.addChildren(node6, node5, node4, node8);
        node4.addChildren(node3, node8);
        node5.addChildren(node3);
        node6.addChildren(node3);
        node7.addChildren(node2, node9);
        node8.addChildren(node4, node9);
        node9.addChildren(node7, node8);
        node10.addChildren(node11, node12);
        node11.addChildren(node10);
        node12.addChildren(node10);

        graph.addNodes(node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11, node12);

        System.out.println(routeExists(graph, 4, 9));
    }

    public static boolean routeExists(Graph graph, int node1, int node2) {
        List<GraphNode> nodes = graph.nodes;
        GraphNode startingNode = null;

        for (GraphNode node : nodes) {
            if (node.data == node1) {
                startingNode = node;
            }
        }

        if (startingNode == null) return false;

        boolean found = false;

        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.add(startingNode);
        startingNode.visited = true;

        while (!queue.isEmpty() && !found) {
            GraphNode node = queue.poll();
            System.out.println("Visiting node " + node);
            if (node.data == node2) {
                found = true;
            }

            for (GraphNode child : node.children) {
                if (!child.visited) {
                    child.visited = true;
//                    System.out.println(String.format("Adding %s in queue", child.data));
                    queue.add(child);
                }
            }
        }
        return found;
    }
}
