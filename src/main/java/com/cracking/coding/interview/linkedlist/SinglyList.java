package com.cracking.coding.interview.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SinglyList {
    private Node head;

    public SinglyList(int data) {
        this.head = new Node(data);
    }

    public SinglyList(int... values) {
        Node current = null;
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                this.head = new Node(values[i]);
                current = head;
            } else {
                current.next = new Node(values[i]);
                current = current.next;
            }

        }
    }

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    public void printList() {
        System.out.println(head);
    }

    public void partition(int x) {
        Node partitionNode = getKthOrdinalNode(x);
        Node previous = null;
        Node current = head;
        while (current != partitionNode) {
            if (current.data > partitionNode.data) {
                Node oldNext = partitionNode.next;
                if (current == head) {
                    head = head.next;
                }
                Node tmp = current.next;
                current.next = oldNext;

                if (previous == null) {
                    if (tmp != head) {
                        previous = head;
                    }
                } else {
                    previous.next = tmp;
                }
                partitionNode.next = current;
                current = tmp;
            } else {
                previous = current;
                current = current.next;
            }
        }
        System.out.println("Partition first half: " + head);

        previous = partitionNode;
        current = partitionNode.next;
        while (current != null) {
            if (current.data < partitionNode.data) {
                Node oldNext = current.next;
                previous.next = oldNext;
                if (partitionNode == head) {
                    head = current;
                    current.next = partitionNode;
                } else {
                    Node oldHeadNext = head.next;
                    head.next = current;
                    current.next = oldHeadNext;
                }
                current = oldNext;
            } else {
                previous = current;
                current = current.next;
            }
        }
        System.out.println("Partition second half: " + head);
    }

    public void removeDuplicates() {
        Set<Integer> seen = new HashSet<>();
        seen.add(head.data);
        Node previous = head;
        Node current = head.next;

        while (current != null) {
            if (seen.contains(current.data)) {
                previous.next = current.next;
            } else {
                seen.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public int getKthToLast(int kthToLast) {
        Map<Integer, Integer> map = new HashMap<>();

        int size = 0;
        int index = 0;

        Node current = head;
        while (current != null) {
            map.put(index, current.data);
            index++;
            size++;
            current = current.next;
        }

        if (kthToLast > size) {
            return -1;
        }

        return map.get(size - kthToLast);
    }

    public static SinglyList sumLists(SinglyList list1 , SinglyList list2) {
        //TODO

        return null;
    }

    private Node getKthOrdinalNode(int kth) {
        int index = 1;
        Node kthNode = head;
        while (index < kth) {
            kthNode = kthNode.next;
            index++;
        }

        if (index != kth) {
            return null;
        }

        return kthNode;
    }


    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + " -> " + next;
        }
    }
}
