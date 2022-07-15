package com.cracking.coding.interview.stack;

import java.util.function.Function;
import java.util.function.Predicate;

public class Stack {

    private StackNode top;

    public Stack() {

    }

    public Stack(int data) {
        top = new StackNode(data);
    }

    public Stack(int... data) {
        for (int d : data) {
            push(d);
        }
    }

    public void push(int data) {
        if (top == null) {
            top = new StackNode(data);
        } else {
            StackNode tmp = top;
            top = new StackNode(data);
            top.next = tmp;
        }
    }

    public int pop() {
        StackNode oldTop = top;
        top = top.next;
        return oldTop.data;
    }

    public StackNode popNode() {
        StackNode oldTop = top;
        top = top.next;
        return oldTop;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        return top.data;
    }

    public void sort() {
        if (top == null || top.next == null) return;

        Stack tempStack = new Stack();
        boolean ordered = false;

        while (!ordered) {
            fillTempStack(tempStack);
            ordered = fillStack(tempStack);
        }

    }

    private Stack fillTempStack(Stack tempStack) {
        int current = pop();
        int next;

        while (!isEmpty()) {
            next = pop();

            if (current < next) {
                tempStack.push(current);
                current = next;
            } else {
                tempStack.push(next);
            }
        }
        tempStack.push(current);

        return tempStack;
    }

    private boolean fillStack(Stack tempStack) {
        boolean ordered = true;
        int current = tempStack.pop();
        int min = current;
        int next;
        while (!tempStack.isEmpty()) {
            next = tempStack.pop();

            if (current >= next) {
                push(current);
                current = next;
            } else {
                push(next);
            }

            int lastInsertedElement = peek();
            if (lastInsertedElement < min) {
                min = lastInsertedElement;
            }

            if (lastInsertedElement > min) {
                ordered = false;
            }

        }
        this.push(current);

        return ordered;
    }

    private boolean fillStack2(Stack tempStack) {
        boolean ordered = true;

        Integer current = tempStack.pop();
        int min = current;
        Integer next = null;
        while (!tempStack.isEmpty()) {
            if (current == null) {
                current = tempStack.pop();
            }

            if (next == null) {
                next = tempStack.pop();
            }


            if (current >= next) {
                this.push(current);
                if (current <= min) {
                    min = current;
                } else {
                    ordered = false;
                }
                current = null;
            } else {
                this.push(next);
                if (next <= min) {
                    min = current;
                } else {
                    ordered = false;
                }
                next = null;
            }
        }

        if (current == null) {
            push(next);
        } else {
            push(current);
        }

        return ordered;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                '}';
    }

    public static class StackNode {
        int data;
        StackNode next;

        public StackNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "->" + next;
        }
    }
}
