package com.mabo.linkedlist.generics;

public class LinkedList<T> implements List<T>{
    private Node head=new Node(null,"head",null);

    @Override
    public void add(T t){
        Node node = new Node(head,t,null);
        if (head.next!=null){
            Node next=head.next;
            node.next=next;
        }
        head.next=node;
    }
    @Override
    public void remove(T t){
        Node position = head;
        while (position.next!=null){
            position=position.next;
            if ( position.item.equals(t)){
                position.prev.next=position.next;
                break;
            }
        }
    }

    public void show(){
        Node position = head;
        do {
            System.out.print(position.item);
            position=position.next;
        }
        while (position!=null);
        System.out.println();
    }

    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(123);
        list.add(123);
        System.out.println(list);
        list.remove(123);
        list.show();
    }
}
