package com.mabo.linkedlist;
/**
 * @Author mabo
 * @Description   单链表
 */

public class SingleList {

    private   Node head=new Node("head",0,null);

    public void add(String  nodeName,int value){
        if (!exist(nodeName)){
            Node node = new Node(nodeName,value, null);
            if (head.next==null){
                head.next= node;
            }
            else {
                Node next=head.next;
                head.next=node;
                head.next.next=next;
            }
            show();
        }else {
            update(nodeName,value);
        }

    }

    public void remove(String  nodeName){
        Node node = new Node(nodeName, null);
        Node position = head;
        Node before =head;
        while (position.next!=null){
            position=position.next;
           if ( position.nodeName.equals(node.nodeName)){
               before.next= position.next;
               break;
           }
            before=position;
        }
        show();
    }

    public void show(){
        Node position = head;
        do {
            System.out.print("["+position.nodeName+" "+position.value+"]  ");
            position=position.next;
        }
        while (position!=null);
        System.out.println();
    }


    public void update(String  nodeName,int valve){
        Node position = head;
        Node before =head;
        while (position.next!=null){
            position=position.next;
            if ( position.nodeName.equals(nodeName)){
                position.value=valve;
                break;
            }
            before=position;
        }
        show();
    }

    public boolean exist(String  nodeName){
        Node position = head;
        Node before =head;
        while (position.next!=null){
            position=position.next;
            if ( position.nodeName.equals(nodeName)){
                return true;
            }
            before=position;
        }
        return false;
    }

    public int getLength(){
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
