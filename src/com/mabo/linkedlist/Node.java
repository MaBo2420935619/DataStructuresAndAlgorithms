package com.mabo.linkedlist;

public class Node{
    String nodeName;

    Node next;

    int value;

    public Node(String nodeName, int value, Node next) {
        this.nodeName = nodeName;
        this.next = next;
        this.value = value;
    }

    public Node(String nodeName, Node next) {
        this.nodeName = nodeName;
        this.next = next;
    }
}
