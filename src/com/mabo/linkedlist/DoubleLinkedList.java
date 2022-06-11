package com.mabo.linkedlist;
/**
 * @Author mabo
 * @Description  头插法 双向链表
 */

public class DoubleLinkedList {

    private   DoubleNode head=new DoubleNode("head",0);

    public void add(String  nodeName,int value){
        if (!exist(nodeName)){
            DoubleNode node = new DoubleNode(nodeName,value);
            if (head.next==null){
                head.next= node;
            }
            else {
                DoubleNode next=head.next;
                head.next=node;
                node.pre=head;
                node.next=next;
            }
            show();
        }else {
            update(nodeName,value);
        }

    }

    public void remove(String  nodeName){
        DoubleNode position = head;
        while (position.next!=null){
            position=position.next;
            if ( position.nodeName.equals(nodeName)){
                position.pre.next=position.next;
                break;
            }
        }
        show();
    }

    public void show(){
        DoubleNode position = head;
        do {
            System.out.print("["+position.nodeName+" "+position.value+"]  ");
            position=position.next;
        }
        while (position!=null);
        System.out.println();
    }


    public void update(String  nodeName,int valve){
        DoubleNode position = head;
        while (position.next!=null){
            position=position.next;
            if ( position.nodeName.equals(nodeName)){
                position.value=valve;
                break;
            }
        }
        show();
    }

    public boolean exist(String  nodeName){
        DoubleNode position = head;
        while (position.next!=null){
            position=position.next;
            if ( position.nodeName.equals(nodeName)){
                return true;
            }
        }
        return false;
    }

    public int getLength(Node head){
        int length=0;
        Node position = head;
        while (position.next!=null){
            position=position.next;
            length++;;
        }
        System.out.println("链表长度为"+length);
        return length;
    }
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.add("1",1);
        singleList.add("2",2);
        singleList.add("3",3);
        singleList.add("4",4);
        singleList.add("1",5);
        singleList.add("6",6);
        singleList.remove("3");
        singleList.getLength();
    }
}
