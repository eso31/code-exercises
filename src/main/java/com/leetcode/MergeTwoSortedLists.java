package com.leetcode;

import java.util.Arrays;
import java.util.List;

/***
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);

        ListNode node1_2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4_2 = new ListNode(4);

        node1.next = node2;
        node2.next = node4;

        node1_2.next = node3;
        node3.next = node4_2;

        System.out.println(mergeListsSecondTry(node1, node1_2)); // 1 -> 1 -> 2 -> 3 -> 4 -> 4


        System.out.println(mergeListsSecondTry(new ListNode(2), new ListNode(1))); // 1 -> 2
        System.out.println(mergeListsSecondTry(new ListNode(1), new ListNode(2))); // 1 -> 2


        System.out.println(mergeListsSecondTry(createList(Arrays.asList(-9, -7, -3)), createList(Arrays.asList(-7, -7, -6)))); // -9 -> -7 -> -7 -> -7 -> -6 -> -3


    }

    private static ListNode createList(List<Integer> list) {
        ListNode head = null;
        ListNode current = null;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                head = new ListNode(list.get(i));
                current = head;
            } else {
                current.next = new ListNode(list.get(i));
                current = current.next;
            }
        }

        return head;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }


        ListNode finalHead = list2;

        if (list1.val < list2.val) {
            finalHead = list1;
        }

        ListNode c1 = list1;
        ListNode c2 = list2;

        ListNode p1 = null;
        ListNode p2 = null;

        while (c1 != null && c2 != null) {
            if (c1.val == c2.val) {
                p2 = c2;
                c2 = c2.next;

                if (c2 != null && c1 !=null && c2.val != c1.val) {
                    p2.next = c1;
                } else if (c2 == null) {
                    p2.next = c1;
                }

            } else if (c1.val < c2.val) {
                // avanzo 1
                p1 = c1;
                c1 = c1.next;

                if (c1 == null) {
                    p1.next = c2;
                }
                // si el nuevo c1 es mayor a c2, significa que p1 -> c2 -> … -> c1
                else if (c1.val >= c2.val) {
                    p1.next = c2;
                }
            } else if (c1.val > c2.val) {
                p2 = c2;
                c2 = c2.next;

                if (c2 == null) {
                    p2.next = c1;
                }
                // si el nuevo c2 es mayor a c1, significa que p2 -> c1 -> .. -> c2
                else if (c2.val > c1.val) {
                    p2.next = c1;
                }
            }

        }

        return finalHead;
    }

    public static ListNode mergeListsSecondTry(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode finalHead = null;
        if (list1.val <= list2.val) {
            finalHead = list1;
            list1 = list1.next;
        } else {
            finalHead = list2;
            list2 = list2.next;
        }
        ListNode tail = finalHead;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }

            tail = tail.next;
        }

        if (p1 == null) {
            tail.next = p2;
        }

        if (p2 == null) {
            tail.next = p1;
        }

        return finalHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }
}
